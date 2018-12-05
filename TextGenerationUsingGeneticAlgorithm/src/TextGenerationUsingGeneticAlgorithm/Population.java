/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    Random r = new Random();
    private int generationCount = 0;
    private double perfectScore = 1.01;
    private boolean finished = false;
    private Chromosome best;
    private Gene gene;

    public Population() {
    }
/*******************************************************************************
    When instance of this class is created, a population of chromosomes equal to 
    the passed population size will be created using createPopulation(). The 
    chromosome size will be decided based on the target string passed.
    *****************************************************************************/
    public Population(int populationSize, String target, float mutationRate) {
        this.populationSize = populationSize;
        this.target = target;
        this.mutationRate = mutationRate;
        createPopulation(generation);
    }

    public void createPopulation(ArrayList<Chromosome> generation) {
        while (!(generation.size() == populationSize)) {
            generation.add(new Chromosome(target));
        }
        Collections.sort(generation);
    }

/*******************************************************************************
    The purpose of NaturalSelection() is to create a mating pool that will 
    consist of the fittest 80% population of the generation, pick 2 partners
    from the pool at random and product an offspring.
    This is done using below steps:
    1. clear the mating pool
    2. (The population in the 1st generation is already sorted according to the 
    chromosome fitness in descending order). Population size*0.8 number of chromosomes
    from the top are added in the mating pool.
    3. Two random partners are selected and passed to crossover()
    4. the offspring so created is then passed to mutate()
    5. Replaces the least fir 20% generation with the new children.
    *****************************************************************************/ 

    public void NaturalSelection() {
        generationCount++;
        matingPool.clear();
        for (int i = 0; i < generation.size() * 0.8; i++) {
            matingPool.add(generation.get(i));
        }
        Collections.sort(generation);
        for (int j = 0; j < generation.size() * 0.2; j++) {
            int a = (r.nextInt(matingPool.size()));
            int b = (r.nextInt(matingPool.size()));
            Chromosome partnerA = matingPool.get(a);
            //System.out.println("Partner A: "+partnerA.getCandidateString());
            Chromosome partnerB = matingPool.get(b);
            //System.out.println("Partner B: "+partnerB.getCandidateString());

            Chromosome child = crossover(partnerA, partnerB, target);
            mutate(child, mutationRate);
            generation.set(generation.size() - (j + 1), child);
            
        }
        evaluate(generation);
    }
    
    /*******************************************************************************
    crossover() accepts 2 partner chromosomes, selects a random index and creates a 
    new child by merging the two partners. For example,
    PartnerA = "mobiles"
    PartnerB = "popcorn"
    random index = 4
    So child = mobi(from partnerA) + orn(from partnerB) = mobiorn
    *****************************************************************************/

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
        child.setFitness(child.calculateFitness(str));
        return child;
    }

    /*******************************************************************************
    mutate() is fed with a chromosome and a mutation rate. A number between 0.0 to 1
    is generated at random and compared with the entered mutation rate. If the number is
    less than the mutation rate, a random gene of the entered chromosome is 
    mutated (or replaced) with a randomly generated new gene.
    *****************************************************************************/
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
/*******************************************************************************
    evaluate() returns the best chromosome from a given generation by identifying
    the highest value of fitness and the chromosome with that fitness
    *****************************************************************************/
    public double evaluate(ArrayList<Chromosome> generation) {
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
    return worldrecord;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getGenerations() {
        return generationCount;
    }

    public String getBest() {
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
