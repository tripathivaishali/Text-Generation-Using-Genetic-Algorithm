/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithm;

/**
 *
 * @author Vaishali Tripathi
 */
public class TextGenerationUsingGeneticAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int populationSize = 10000;
        float mutationRate = (float) 10;
        String target = "to be or not to be";
        
        Population c = new Population(populationSize,target, mutationRate);
        while (!(c.isFinished())) {
            
            c.NaturalSelection();
            c.evaluate();
            System.out.println(c.getBest());
        }   
            
        }

    }


