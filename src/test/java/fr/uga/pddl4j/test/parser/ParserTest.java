/*
 * Copyright (c) 2016 by Cedric Gerard <cedric.gerard@yeastlab.fr>.
 *
 * This file is part of PDDL4J library tests.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.PDDLParser;
import fr.uga.pddl4j.test.Tools;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;


/**
 * Implements the <tt>ParserTest</tt> of the PDD4L library. The parser is tested on IPC benchmarks. The IPC benchmarks
 * used for testing are available in <code>test/ressources/benchmarks</code> directory.
 * </p>
 *
 * @author C. Gerard
 * @author D. Pellier
 * @version 1.1 - 16.02.16
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParserTest {

    /**
     * Method that executes tests using IPC 1998 Assembly ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Assembly_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/assembly/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Grid STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Grid_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/grid/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 gripper ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Gripper_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Gripper STRIPS benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Gripper_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/gripper/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 1998 Logistics STRIPS Round1 benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_STRIPS_Round1() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round1" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Logistics STRIPS Round2 benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Logistics_STRIPS_Round2() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/logistics/strips-round2" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie ADL benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Movie_ADL() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/adl" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     *  Method that executes tests using IPC 1998 Movie STRIPS benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC1998_Movie_STRIPS() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc1998/movie/strips" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Blocks_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Blocks STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Blocks_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/blocks/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL full typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_ADL_Full_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-full-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator ADL simple typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_ADL_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/adl-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_STRIPS_Simple_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Elevator STRIPS simple untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Elevator_STRIPS_Simple_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/elevator/strips-simple-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS  typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Freecell_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Freecell STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Freecell_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/freecell/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Logistics_STRIPS_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Logistics STRIPS untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Logistics_STRIPS_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/logistics/strips-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL typed benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Schedule_ADL_Typed() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-typed" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Method that executes tests using IPC 2000 Schedule ADL untyped benchmarks.
     *
     * @throws Exception if something went wrong.
     */
    @Test
    public void test_Parser_IPC2000_Schedule_ADL_Untyped() throws Exception {
        final String localTestPath = Tools.PDDL_BENCH_DIR + "ipc2000/schedule/adl-untyped" + File.separator;
        Assert.assertTrue("missing benchmark [directory: " + localTestPath + "] test skipped !",
            Tools.isBenchmarkExist(localTestPath));
        this.validate(localTestPath);
    }

    /**
     * Instantiate the PDDLParser and parse all domains and problems in the specified test path.
     *
     * @param currentTestPath the path where try to find domain and problems pddl files
     * @return all issues report as a ArrayList of String
     */
    private ArrayList<String> validate(String currentTestPath) throws Exception {

        if (!Tools.isBenchmarkExist(currentTestPath)) {
            System.out.println("missing benchmark directory + \"" + currentTestPath + "\" test skipped !");
            return null;
        }

        final PDDLParser parser = new PDDLParser();
        final ArrayList<String> errors = new ArrayList<>();
        String currentDomain = currentTestPath + Tools.DOMAIN;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(".pddl") && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("\nParserTest: Test parser on " + currentTestPath);
        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                if (nbTest < 100) {
                    problemFile = "p0" + i + Tools.PDDL_EXT;
                } else {
                    problemFile = "p00" + i + Tools.PDDL_EXT;
                }
            } else if (i < 100) {
                if (nbTest < 100) {
                    problemFile = "p" + i + Tools.PDDL_EXT;
                } else {
                    problemFile = "p0" + i + Tools.PDDL_EXT;
                }
            } else {
                problemFile = "p" + i + Tools.PDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.DOMAIN;
            }

            try {
                parser.parse(currentDomain, currentProblem);

                ErrorManager errManager = parser.getErrorManager();

                if (!parser.getErrorManager().getMessages(Message.Type.PARSER_ERROR).isEmpty()
                    || !parser.getErrorManager().getMessages(Message.Type.LEXICAL_ERROR).isEmpty()) {
                    Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                    Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));

                    final StringBuilder builder = new StringBuilder();

                    domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                    problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));

                    System.out.println("PDDLParser test: [FAILURE]");
                    System.out.println("   * " + currentProblem);
                    System.out.println("   * " + currentDomain);
                    System.out.println("   * Errors:");
                    System.out.println(builder.toString());
                    throw new Exception(builder.toString());

                } else {
                    System.out.println("PDDLParser test: [PASSED]");
                    System.out.println("   * " + currentProblem);
                    System.out.println("   * " + currentDomain);
                    if (!parser.getErrorManager().getMessages(Message.Type.PARSER_WARNING).isEmpty()) {
                        Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                        Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));
                        final StringBuilder builder = new StringBuilder();
                        domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                        problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));
                        System.out.println("   * Warnings:");
                        System.out.println(builder.toString());
                    }
                }

            } catch (FileNotFoundException fnfException) {
                System.err.println("Test files not found !");
                System.err.println("  -- " + currentDomain);
                System.err.println("  -- " + currentProblem);
                System.err.println("PDDLParser test aborted !");
            }
        }

        return errors;
    }
}
