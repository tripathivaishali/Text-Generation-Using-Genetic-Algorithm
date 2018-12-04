/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Vaishali Tripathi
 */
public class Population<X extends Comparable<Chromosome>> {

    private ArrayList<Chromosome> generation = new ArrayList<Chromosome>();
    private ArrayList<Chromosome> matingPool = new ArrayList<Chromosome>();
    private int populationSize;
    private String target;
    private float mutationRate;
    private Chromosome c;
    Random r = new Random();
    private int generationCount = 0;
    private double perfectScore = 1.01;
    private boolean finished = false;
    private Chromosome best;
    private Gene gene;

    public Population(int populationSize, String target, float mutationRate) {
        this.populationSize = populationSize;
        this.target = target;
        this.mutationRate = mutationRate;
        createPopulation();
    }

    public Chromosome getC() {
        return c;
    }

    public void setC(Chromosome c) {
        this.c = c;
    }

    public void createPopulation() {
        while (!(generation.size() == populationSize)) {
            generation.add(new Chromosome(target));
        }
        Collections.sort(generation);
        
//        for (int i = 0; i < generation.size(); i++) {
//            System.out.println("sorted:" + generation.get(i).getFitness());
//        }
    }

    /*  @Override
    public String toString() {
        return c;
    }*/
    public void NaturalSelection() {
        matingPool.clear();
        for (int i = 0; i < generation.size() * 0.8; i++) {
            matingPool.add(generation.get(i));
        }
        Collections.sort(generation);
        for (int j = 0; j < generation.size() * 0.2; j++) {
            int a = (r.nextInt(matingPool.size()));
            int b = (r.nextInt(matingPool.size()));
            Chromosome partnerA = matingPool.get(a);
            Chromosome partnerB = matingPool.get(b);
            Chromosome child = new Chromosome(target);
            child = crossover(partnerA, partnerB, target);
            mutate(child, mutationRate);

            generation.set(generation.size() - (j + 1), child);
        }
    }

    public Chromosome crossover(Chromosome partnerA, Chromosome partnerB, String target) {
        Chromosome child = new Chromosome(target);
        int midpoint = (r.nextInt(target.length()));
        char[] str1 = new char[target.length()];
        // Half from one, half from the other
        for (int i = 0; i < target.length(); i++) {
            if (i > midpoint) {
                str1[i] = partnerA.getCandidateString().charAt(i);
            } else {
                str1[i] = partnerB.getCandidateString().charAt(i);
            }
        }
        String str = String.valueOf(str1);
        child.setCandidateString(str);
        return child;
    }

    public void mutate(Chromosome child, double mutationRate) {
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        double createdRanNum = 0;

        char[] childChars = child.getCandidateString().toCharArray();
        for (int i = 0; i < childChars.length; i++) {
            createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            if (createdRanNum < mutationRate) {
                gene = new Gene();
                childChars[i] = (char) gene.generateGene();
            }
        }
        child.setCandidateString(String.valueOf(childChars));
    }

    public void evaluate() {
        double worldrecord = 0.0;
        int index = 0;
        for (int i = 0; i < generation.size(); i++) {
//            System.out.println("Generation fitness of index ["+i+"]:["+generation.get(i).getCandidateString()+"]");
            if (generation.get(i).getFitness() > worldrecord) {
                index = i;
                worldrecord = generation.get(i).getFitness();
            }
        }

        if (worldrecord == perfectScore) {
            finished = true;
        }
        best = new Chromosome(target);
        best.setCandidateString(generation.get(index).getCandidateString());
    }

    public boolean isFinished() {
        return finished;
    }

    public int getGenerations() {
        return generationCount;
    }
    
    public String getBest(){
        return best.getCandidateString();
    }

    public double getAverageFitness() {
        double total = 0;
        for (int i = 0; i < generation.size(); i++) {
            total += generation.get(i).getFitness();
        }
//        System.out.println("Average fitness of the generation: "+ total / (pop.length));
        return total / (generation.size());
    }

}
