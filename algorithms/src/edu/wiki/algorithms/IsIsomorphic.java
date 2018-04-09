package edu.wiki.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic {
    /*
    use cases
    s or t ot both are nulls
    one is shorter that the other
    valid characters or only a-zA-Z0-9 values?
    range of 255 character?
    aaabb  bbbbb
    
    aproach
    1) use a map to track with character in s is mapped to the character of t
    for any character on the s and t compare if there is a co relation 
    if there is not return false.
    
    we need to keep the order so we can't scrumble 
    
    improve performance we can create an array of intergers instead map if we have only valid characters
    
    time O(n)
    space O(n)
    
    */
    
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] myS = s.toCharArray();
        char[] myT = t.toCharArray();
        
        // extra space to help with time
        char[] forward = new char[256];
        char[] backward = new char[256];
        
        if (myS.length != myT.length) {
            return false; 
        } 
        
        for (int i = 0; i < myS.length; i++) {
            if (forward[myS[i]] != 0) {
                if (forward[myS[i]] != myT[i]) {
                    return false;
                }
            } else if (backward[myT[i]] != 0) {
                // value been booked by other keys
                return false;
            
            } else {
                forward[myS[i]] = myT[i];
                backward[myT[i]] = myS[i];
            }
        }
        return true;
    }
    
    public boolean isIsomorphic3(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }
        return true;
    }
    
    public boolean isIsomorphic2(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        Map<Integer, Integer> charMap = new HashMap<>();
        Set<Integer> usedChar = new HashSet<>();
        
                
        for(int i = 0; i < s.length(); i++){
            int cur = s.charAt(i);
            int tCur = t.charAt(i);
            if(charMap.containsKey(cur)){
                if(charMap.get(cur) != tCur){
                    return false;
                }
            } else {
                if(!usedChar.contains(tCur)){
                    charMap.put(cur, tCur);
                    usedChar.add(tCur);
                }else {
                    return false;
                }
                
            }
        }
        
        return true;
    }
}