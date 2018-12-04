/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcardgenerator;

/**
 *
 * @author Vaishali Tripathi
 */
public class GreetingCardGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int populationSize = 10;
        float mutationRate = (float) 0.001;
        String target = "to be or";
        
        Population c = new Population(populationSize,target, mutationRate);

    }

}
