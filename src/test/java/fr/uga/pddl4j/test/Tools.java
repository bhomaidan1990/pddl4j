package fr.uga.pddl4j.test;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.PDDLParser;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.problem.Problem;
import org.junit.Assert;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Static class that contains all shared method for manipulate the benchmark
 * directory structure.
 *
 * @author C. Gerard
 * @author D. Pellier
 * @version 1.1 - 23.06.16
 */
public abstract class Tools {

    /**
     * This enumeration defines the type of file: PDDLDomain or PDDLProblem.
     */
    public enum FileType {
        /**
         * The DOMAIN file.
         */
        DOMAIN_FILE,
        /**
         * The PROBLEM file.
         */
        PROBLEM_FILE,
    }

    /**
     * The path of the benchmarks files.
     */
    public static final String PDDL_BENCH_DIR = "src/test/resources/benchmarks/pddl" + File.separator;

    /**
     * PDDL files extension.
     */
    public static final String PDDL_EXT = ".pddl";

    /**
     * PDDL4J output plan extension for KCL validator format.
     */
    public static final String PLAN_EXT = ".val";

    /**
     * The domain file name.
     */
    public static final String DOMAIN = "domain" + PDDL_EXT;

    /**
     * The path to VAL.
     */
    public static final String VAL = "src/test/resources/validators/validate";

    /**
     * Check if benchmark are already here.
     *
     * @param path the benchmark directory path
     * @return true if the benchmark file exist
     */
    public static boolean isBenchmarkExist(String path) {
        return new File(path).exists();
    }

    /**
     * Clean all val formatted plan from the current directory and all its subdirectories.
     *
     * @param localTestPath the current path to clean up
     */
    public static void cleanValPlan(String localTestPath) {
        File dir = new File(localTestPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".val"));

        if (files != null) {
            for (File file : files) {
                try {
                    Files.deleteIfExists(FileSystems.getDefault().getPath(localTestPath, file.getName()));
                    System.out.println("Deleting " + localTestPath + file.getName());
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    /**
     * Parse domain and problem files and return the associated coded problem.
     *
     * @param domainFile  the domain file to be tested.
     * @param problemFile the file file to be tested.
     * @return a coded problem from the parsing file
     */
    public static Problem generateCodedProblem(String domainFile, String problemFile) {
        try {
            final File domain = new File(domainFile);
            final File problem = new File(problemFile);
            final ProblemFactory factory = ProblemFactory.getInstance();
            final ErrorManager errorManager = factory.parse(domain, problem);
            if (errorManager.isEmpty()) {
                return factory.encode();
            }
        } catch (IOException ioExcepion) {
            System.err.println(ioExcepion + " test files not found !");
        }
        return null;
    }

    /**
     * Change the permissions for VAL file (add read, write and execute).
     */
    public static void changeVALPerm() {
        final File val = new File(Tools.VAL);
        if (val.exists() && (isUnix() || isMac())) {
            val.setReadable(true);
            val.setExecutable(true);
        }
    }

    /**
     * Remove the extension of a filename.
     *
     * @param fileName the name of the file
     * @return the filename of the file without extension
     */
    public static String removeExtension(String fileName) {
        final Pattern ext = Pattern.compile("(?<=.)\\.[^.]+$");
        return ext.matcher(fileName).replaceAll("");
    }

    /**
     * Count the number of validated plans.
     *
     * @param outputVal the output of VAL
     * @return the number of validated plans
     */
    public static int numberValidatedPlans(String outputVal) {
        int i = 0;
        final Pattern p = Pattern.compile("Plan valid");
        final Matcher m = p.matcher(outputVal);
        while (m.find()) {
            i++;
        }
        return i;
    }

    /**
     * Read the content of a file.
     *
     * @param path     the path to the file
     * @param encoding encoding of the file
     * @return the content of the file encoded
     * @throws IOException if an error occurs when reading file from path.
     */
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Validate output plans.
     *
     * @param currentTestPath the current sub dir to test
     */
    public static void validatePlans(String currentTestPath) throws Exception {
            final String domain = currentTestPath + "domain.pddl";
            File dir = new File(currentTestPath);
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(".val"));

            if (files != null) {
                final StringBuilder output = new StringBuilder();

                for (File valfile : files) {
                    final String problem = currentTestPath + Tools.removeExtension(valfile.getName()) + ".pddl";
                    String target;
                    if (isWindows()) {
                        target = Tools.VAL + "-win.exe -v " + domain + " " + problem + " " + valfile;
                    } else if (isMac()) {
                        target = Tools.VAL + "-osx -v " + domain + " " + problem + " " + valfile;
                    } else {
                        target = Tools.VAL + "-nux -v " + domain + " " + problem + " " + valfile;
                    }

                    final Runtime rt = Runtime.getRuntime();
                    final Process proc = rt.exec(target);
                    proc.waitFor();

                    String line;
                    final InputStreamReader inputStreamReader = new InputStreamReader(proc.getInputStream(),
                        StandardCharsets.UTF_8);
                    final BufferedReader reader = new BufferedReader(inputStreamReader);
                    try {
                        while ((line = reader.readLine()) != null) {
                            output.append(line + "\n");
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally {
                        reader.close();
                        inputStreamReader.close();
                        proc.getInputStream().close();
                    }
                }

                final int number = Tools.numberValidatedPlans(output.toString());
                System.out.println("\n-- VAL on " + currentTestPath);
                System.out.println("   Plans found: " + files.length);
                System.out.println("   Plans validated: " + number);
                System.out.println("--");
                Assert.assertEquals(files.length,number);
            }

            Tools.cleanValPlan(currentTestPath);

    }

    /**
     * Check if the OS is Windows.
     *
     * @return true if the OS is Windows, false otherwise.
     */
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("win");
    }

    /**
     * Check if the OS is Mac.
     *
     * @return true if the OS is Mac, false otherwise.
     */
    private static boolean isMac() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("mac");
    }

    /**
     * Check if the OS is Linux.
     *
     * @return true if the OS is Linux, false otherwise.
     */
    private static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("nux");
    }
}
