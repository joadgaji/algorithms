package edu.wiki.algorithms;

import java.io.UnsupportedEncodingException;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */

public class LengthOfLongestSubstring {

   
    /* 
    Questions:
    What if the input is null? how long? empty? 
    What is the return value when the input is null?
    
    Is is possible that input is 255 character
    If the string has UTF-8 charancter support I need to get the bytes array (That is another history)
    
    Approach
    1) create buffer to keep the flag of letters, have the first and last index of the longest substring
    have runner index for the current substring. 
    Instead of index of the longest we can keep the substring but we need to generate the substring anytime.
    Buffer is an array of 255 size or can be a map 
    var i and j are the current substring
    
    time O(n)
    space O(n)
    
    Approach
    2) use a queue in combination of the hashmap
    
    aabcbacba
    
    */
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        
        boolean[] characters = new boolean[255];
        int maxim = 0;
        
        int i = 0;
        int j = 1;
        char[] arr = s.toCharArray();
        characters[arr[0]] = true;
        
        while(j < arr.length){
            char letterFinish = arr[j];
            char letterStart = arr[i];
            
            if(characters[letterFinish]){
                characters[letterStart] = false;
                i++;
            } else {
                characters[letterFinish] = true;
                j++;
                maxim = Math.max(maxim, Math.min(j, arr.length) - i);
            }
        }
        
        return maxim;
        
    }
}

