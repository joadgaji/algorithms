package edu.wiki.algorithms;

public class ReverseInteger {

    public int reverse(int x) {
        int sum = 0;
        boolean signed = x < 0;
        
        int val = x;
        
        if(signed) val = 0 - x;
        
        while(val > 0){
            int temp = (sum * 10) + (val % 10);
            if(sum != temp / 10)
                return 0;
            val /=  10;
            sum = temp;
        }
        
        
        return signed ? 0 - sum : sum;
    }
}