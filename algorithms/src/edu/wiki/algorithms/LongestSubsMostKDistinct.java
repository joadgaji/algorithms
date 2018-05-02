package edu.wiki.algorithms;

import java.util.HashMap;

public class LongestSubsMostKDistinct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestSubsMostKDistinct("abcbbbbcccbdddadacb", 2));

		System.out.println(longestSubsMostKDistinct("abcde", 2));

	}
	
	public static int longestSubsMostKDistinct(String str, int k){
		/*
		 * Cases str null
		 * str length is less that k 
		 * k is 0
		 * 
		 * map to keep the k character and last pos
		 * int to have the max value
		 * int to have the start point on the cur substring
		 */
		
		if(str == null || str.length() <= k || k < 0) return 0;
		
		HashMap<Character, Integer> chars = new HashMap<>();
		int max = 0;
		int start = 0;
		
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			int counts = 0;
			if(chars.containsKey(c)){
				counts = chars.get(c);
			}
			
			counts++;
			chars.put(c, counts);
			
			while(chars.size() > k){
				char startChar = str.charAt(start);
				if(chars.get(startChar) == 1){
					chars.remove(startChar);
				} else {
					chars.put(startChar, chars.get(startChar)-1);
				}
				start++;
			}
			
			
			max = Math.max(max, i - start + 1);
			
		}
		
		return max;
	}

}
