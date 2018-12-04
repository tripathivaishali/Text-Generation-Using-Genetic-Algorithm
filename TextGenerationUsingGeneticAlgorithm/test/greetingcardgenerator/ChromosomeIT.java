/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcardgenerator;

import TextGenerationUsingGeneticAlgorithm.Gene;
import TextGenerationUsingGeneticAlgorithm.Chromosome;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vaishali Tripathi
 */
public class ChromosomeIT {
    
    public ChromosomeIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateChromosome method, of class Chromosome.
     */
    @Test
    public void testGenerateChromosome() {
        System.out.println("generateChromosome");
        int chromozomeLength = 0;
        Chromosome instance = null;
        instance.generateChromosome(chromozomeLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomWord method, of class Chromosome.
     */
    @Test
    public void testGenerateRandomWord() {
        System.out.println("generateRandomWord");
        int wordSize = 0;
        Chromosome instance = null;
        String expResult = "";
        String result = instance.generateRandomWord(wordSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFitness method, of class Chromosome.
     */
    @Test
    public void testCalculateFitness() {
        System.out.println("calculateFitness");
        String candidateString = "";
        Chromosome instance = null;
        double expResult = 0.0;
        double result = instance.calculateFitness(candidateString);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidateString method, of class Chromosome.
     */
    @Test
    public void testGetCandidateString() {
        System.out.println("getCandidateString");
        Chromosome instance = null;
        String expResult = "";
        String result = instance.getCandidateString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidateString method, of class Chromosome.
     */
    @Test
    public void testSetCandidateString() {
        System.out.println("setCandidateString");
        String candidateString = "";
        Chromosome instance = null;
        instance.setCandidateString(candidateString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFitness method, of class Chromosome.
     */
    @Test
    public void testGetFitness() {
        System.out.println("getFitness");
        Chromosome instance = null;
        double expResult = 0.0;
        double result = instance.getFitness();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFitness method, of class Chromosome.
     */
    @Test
    public void testSetFitness() {
        System.out.println("setFitness");
        double fitness = 0.0;
        Chromosome instance = null;
        instance.setFitness(fitness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGene method, of class Chromosome.
     */
    @Test
    public void testGetGene() {
        System.out.println("getGene");
        Chromosome instance = null;
        Gene expResult = null;
        Gene result = instance.getGene();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGene method, of class Chromosome.
     */
    @Test
    public void testSetGene() {
        System.out.println("setGene");
        Gene gene = null;
        Chromosome instance = null;
        instance.setGene(gene);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Chromosome.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Chromosome instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Chromosome.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Chromosome c = null;
        Chromosome instance = null;
        int expResult = 0;
        int result = instance.compareTo(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
