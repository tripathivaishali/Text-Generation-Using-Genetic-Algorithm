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
        float mutationRate =  (float) 0.01;
        String target = "To be or not to be, that is the question.";
        
        Population c = new Population(populationSize,target, mutationRate);
        while (!(c.isFinished())) {
            
            c.NaturalSelection();
            c.evaluate();
            System.out.println(c.getBest());
        }   
            
        }

    }


