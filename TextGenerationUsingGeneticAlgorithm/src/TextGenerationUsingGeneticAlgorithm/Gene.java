/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextGenerationUsingGeneticAlgorithm;

import java.util.Random;

/**
 *
 * @author Vaishali Tripathi
 */
public class Gene {
    
    Random r = new Random();
   /*******************************************************************************
    generateGene() generates random characters. The characters may be lowercase 
    letters, uppercase letters, punctuation, spaces or numbers.
    *****************************************************************************/
    public char generateGene(){
        char[] punctuation = new char []{',', '.','!','-','{','}','&','*',';',':'};
        char[] numbers = new char[]{'1','2','3','4','5','6','7','8','9','0'};
        char[] space = new char[]{' '};
        
        if(r.nextBoolean())
            if(r.nextBoolean())
               return (char)(r.nextInt(26) + 'a');
            else
                if (r.nextBoolean())
                return punctuation[r.nextInt(punctuation.length)];
                else 
                return (char) (r.nextInt(26) + 'A');
        else 
            if(r.nextBoolean())
                return numbers[r.nextInt(numbers.length)];
            else
                return space[r.nextInt(space.length)];
    }
   
}
