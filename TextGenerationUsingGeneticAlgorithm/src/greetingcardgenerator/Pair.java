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
class Pair implements Comparable{
    String key;
    Double value;

    public Pair(){
    }
    
    
    public Pair(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
//   
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Pair p = (Pair)o;   
return this.value.compareTo(p.value);

    }
    
}
