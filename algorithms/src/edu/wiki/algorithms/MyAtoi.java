package edu.wiki.algorithms;

public class MyAtoi {
    
    /*
    Inputs:
    empty string
    negative string
    with special characters that are not numbers
    posible double
    a long int that can't be an integer
    spaces
    parentesis, commas or dots
    
    
    */
    
    public int myAtoi(String str) {
        String numberStr = str.trim();
        if(numberStr.length() < 1) return 0;
        
        char[] numberArr = numberStr.toCharArray();
        
        int i = 0;
        
        // hold the sign if there is sign
        int isNegative = 1;
        char optionalSign =  numberArr[i];
        if(optionalSign == '-' ){
            isNegative = -1;
            i++;
        } else if(optionalSign == '+' ){
            i++;
        }
        
        String numbers = "0123456789";
        
        long sum = 0;
        boolean continueNumber = true;
        for(; i < numberArr.length; i++){
            int curNumber = numbers.indexOf(numberArr[i]);
            if(curNumber >= 0 && continueNumber){
                sum = sum * 10 + curNumber;
                if(isNegative == 1 && sum > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(isNegative == -1 && sum > Integer.MAX_VALUE + 1.0){
                    return Integer.MIN_VALUE;
                }

            } else {
                continueNumber = false;
            }
            
        }

        
        return isNegative == -1 ? 0 - (int)sum : (int)sum;
        
    }

}