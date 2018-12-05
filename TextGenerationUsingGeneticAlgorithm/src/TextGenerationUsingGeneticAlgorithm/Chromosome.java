/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Vaishali Tripathi
 */
public class Chromosome implements Comparable<Chromosome> {

    private String candidateString;
    private Double fitness=0.01;
    private int chromozomeLength;
    private String target;
    private Gene gene;
    Random r = new Random();

    public Chromosome() {

    }
/*******************************************************************************
    The accepts the target string as an argument and calls generateChromosome() 
    with chromosome length as argument which is equal to the length of the target string.
    *****************************************************************************/
    public Chromosome(String target) {

        this.target = target;
        this.chromozomeLength = target.length();
        generateChromosome(chromozomeLength);

    }

    public int range() {
        int minRange = 1;
        int maxRange = chromozomeLength;
        return (r.nextInt((maxRange - minRange) + 1) + minRange);
    }
/*******************************************************************************
    generateChromosome() accepts the chromosome length as argument and adds genes
    through generateWord() in a loop till the chromosome length is not reached.
    *****************************************************************************/
    public void generateChromosome(int chromozomeLength) {
        int minRange = 1;
        int maxRange = chromozomeLength;
        String str = generateRandomWord(range());
        while (!(str.length() == maxRange)) {
            str = str + " " + generateRandomWord(r.nextInt(maxRange - str.length()));
        }
        candidateString = str;
        setCandidateString(candidateString);
        setFitness(calculateFitness(candidateString));
    }

    public String generateRandomWord(int wordSize) {
        char[] randomChars = new char[wordSize];
        for (int i = 0; i < wordSize; i++) {
            randomChars[i] = new Gene().generateGene();
        }
        String randomWord = String.valueOf(randomChars);
        return randomWord;
    }
/*******************************************************************************
    calculateFitness() accepts a candidate string(or chromosome's string value)
    and calculate the fitness by comparing its genes with each character of the 
    target string.
    *****************************************************************************/
    public double calculateFitness(String candidateString) {
        double score = 0;
        for (int i = 0; i < candidateString.length(); i++) {
            if (candidateString.charAt(i) == target.charAt(i)) {
                score++;
            }
        }
        fitness = (score / target.length()) + 0.01;
        return fitness;
    }

    public String getCandidateString() {
        return candidateString;
    }

    public void setCandidateString(String candidateString) {
        this.candidateString = candidateString;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }

    @Override
    public String toString() {
        return candidateString;
    }

    @Override
    public int compareTo(Chromosome c) {
        return c.fitness.compareTo(this.fitness);
    }

}
