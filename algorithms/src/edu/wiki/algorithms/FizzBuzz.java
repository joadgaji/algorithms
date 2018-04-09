package edu.wiki.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /*
    int is > 0
    
    Approach 
    1) crate the array and for each location divide by 3 and by 5 or defaul the number
    
    
    */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();

        for(int curValue = 1; curValue <= n; curValue++){
            if(curValue % 3 == 0 && curValue % 5 == 0) {
                result.add("FizzBuzz");
            } else if(curValue % 3 == 0) {
                result.add("Fizz");
            } else if(curValue % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(curValue));
            }
        }
        
        return result;
        
    }
}