/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithmTest;

import TextGenerationUsingGeneticAlgorithm.Gene;
import TextGenerationUsingGeneticAlgorithm.Chromosome;
import TextGenerationUsingGeneticAlgorithm.Population;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
public class TextGenerationUsingGeneticAlgorithmTest {

    public TextGenerationUsingGeneticAlgorithmTest() {
    }

    /**
     * Test of generateChromosome method, of class Chromosome.
     */
    @Test
    public void testGenerateChromosome() {
        System.out.println("generateChromosome");
        int chromozomeLength = 6;
        Chromosome instance = new Chromosome("target");
        instance.generateChromosome(chromozomeLength);
        assertEquals(chromozomeLength, instance.getCandidateString().length());
    }

    /**
     * Test of calculateFitness method, of class Chromosome.
     */
    @Test
   public void testCalculateFitness() {
       System.out.println("calculateFitness");
       String candidateString = " ";
       Chromosome instance = new Chromosome(candidateString);
       double expResult = 1.01;
       double result = instance.calculateFitness(instance.getCandidateString());
       if(expResult>=result)
       assertEquals(expResult, result,1.01);
       else
           fail("Not passed");
   }


    @Test
    public void testGenerateGene() {
        System.out.println("generateGene");
        Gene instance = new Gene();
        char expResult = ' ';
        Set<Character> a = new HashSet<>(Arrays.asList(',',':', '.', '!', '-', '{', '}', '&', '*', ';', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        char result = instance.generateGene();
        // assertEquals(expResult, result);

        assertTrue(a.contains(result));
    }

    public void testCreatePopulation() {
        System.out.println("createPopulation");

        String target = ";";
        int populationSize = 10;
        float mutationRate = (float) 0.01;
        Population instance = new Population(populationSize, target, mutationRate);
        ArrayList<Chromosome> test = new ArrayList<Chromosome>();
        instance.createPopulation(test);

    }

    /**
     * Test of NaturalSelection method, of class Population.
     */
    @Test
    public void testNaturalSelection() {
        System.out.println("NaturalSelection");
        String target = ";";
        int populationSize = 10;
        float mutationRate = (float) 0.01;

        Population instance = new Population(populationSize, target, mutationRate);
        instance.NaturalSelection();

    }

    /**
     * Test of crossover method, of class Population.
     */
    @Test
    public void testCrossover() {
        System.out.println("crossover");
        String target = "ab";
        Set<String> ExpectedResult = new HashSet<>(Arrays.asList("aa", "ab", "ac", "ad", "bb", "ba", "bc", "bd", "ca", "cb", "cc", "cd", "da", "db", "dc", "dd"));
        Chromosome partnerA = new Chromosome(target);
        partnerA.setCandidateString("ab");
        Chromosome partnerB = new Chromosome(target);
        partnerB.setCandidateString("cd");

        Population instance = new Population();
        Chromosome result = instance.crossover(partnerA, partnerB, target);
        assertTrue(ExpectedResult.contains(result.getCandidateString()));
    }

    /**
     * Test of mutate method, of class Population.
     */
    @Test
    public void testMutate() {
        System.out.println("mutate");
        Chromosome child = new Chromosome();
        child.setCandidateString("a!");
        double mutationRate = 0.01;
        Population instance = new Population();
        Set<String> a = new HashSet<>(Arrays.asList("a,", "a.", "a!", "a-", "a{", "a}", "a&", "a*", "a;", "a1",
                "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0", "a ", "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap",
                "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az", "ba", "ca", "da", "ea", "fa", "ga", "ha", "ia", "ja", "ka", "la", "ma", "na", "oa", "pa",
                "qa", "ra", "sa", "ta", "ua", "va", "wa", "xa", "ya", "za", ",a", ".a", "!a", "-a", "{a", "}a", "&a", "*a", ";a", "1a",
                "2a", "3a", "4a", "5a", "6a", "7a", "8a", "9a", "0a", " a"));
        Chromosome expResult = new Chromosome();
        expResult.setCandidateString("a;");
        instance.mutate(child, mutationRate);
        assertTrue(a.contains(child.getCandidateString()));

    }

    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Population instance = new Population();
        boolean expResult = false;
        boolean result = instance.isFinished();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetAverageFitness() {
        System.out.println("getAverageFitness");
        String target = ";";
        int populationSize = 10;
        float mutationRate = (float) 0.01;
        Population instance = new Population(populationSize, target, mutationRate);
        double expResult = 0.11;
        double result = instance.getAverageFitness();
        assertEquals(expResult, result, 0.11);

    }

}
