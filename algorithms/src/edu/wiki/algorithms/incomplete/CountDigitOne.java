package edu.wiki.algorithms.incomplete;

public class CountDigitOne {

    
    /*
    This problem can be solved with bucket sort that if we have the list or array of integers, generate all the list and generate the buckets
    
    I can iterate and analyze each number, and do the same procedure are bucket sort but only identifying if number 1 exists until the number is 0
    the algorithm is O(n). keep track of the 1's
    
    
    0-9 = 1
    10 - 19 = 11
    10 - 99 = 10 (11,21,31) + 10 (10,11,12,13)
    100 - 999 = 100 (111,121,221,341) + 100 (second digit) + 100 (100-199 range)
    
    calculate number of digits and apply formula  10^(digits-1)*(digits-1)
    
    */
    public int countDigitOne(int n) {
        if(n < 1) return 0;
        
        Double count = 0.0;
        
        int digits = 0;
        int temp = n;
        int previous = n*10;
        int lastdigit = 0;
        while(temp != 0){
            
            
            // this is the total number on 1's for that number of digits
            Double countFordigits = Math.pow(10,digits-1) * (digits);
            
            System.out.println("countFordigits " + countFordigits);
            
            int currentDigit = temp % 10;
            
            double rest = Math.pow(10,digits);
            
            double mostimportant = (countFordigits * currentDigit) + rest ;
            
            
            double totalIteration = mostimportant;
            
            System.out.println("currentDigit " + currentDigit);
            System.out.println("rest " +  Math.pow(10,digits));
            System.out.println("totalIteration " + totalIteration);
            
            count += totalIteration;
            
            digits++;
            previous = temp;
            temp = temp/10; 
            
            
        }
        
        // System.out.println("digits " + digits);
        
        
        
       // System.out.println("count2 " + count2);
        
        //Double rest = Math.pow(10, digits - 1);
        
       // System.out.println("rest " + rest);
       /* for(int i = rest.intValue(); i <= n; i++){
            
            int number = i;
            do{
                count += number % 10 == 1 ? 1 : 0;
                number = number / 10;
            }while(number > 0);
            
            1
10
459
824883294
        }*/
        
        return count.intValue();
    }
}