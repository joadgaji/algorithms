package edu.wiki.algorithms;

public class ReverseString {
    
    /*
    valid string 
    null, or spaces
    length = 1 return s;
    
    Aproach
    
    1) create an array of that size and fill it in inverse order.
    time O(n)
    space O(n)
    
    2) swap the array and reverse the order of pos (i, n-1-i) where n is the size of the array
    time O(n)
    space O(1)
    
    */
    
    public String reverseString(String s) {
        if(s == null) return null;
        if(s.length() <= 1) return s;
        
        char[] chars = s.toCharArray();
        int size = chars.length;
        int j = size - 1;
        char charTemp;
        for(int i = 0; i < size / 2; i++){
            charTemp = chars[i];
            chars[i] = chars[j];
            chars[j--] = charTemp;
        }
        
        return new String(chars);
        
    }
}