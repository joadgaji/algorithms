package edu.wiki.algorithms;

import java.util.List;

public class ShortestWordDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = {"7", "2", "6", "3", "4", "1", "5", "3", "7"};
		
		System.out.println(shortestWordDisctance(words, "1", "7"));

	}
	
	public static int shortestWordDisctance(String[] words, String word1, String word2){
		if(words == null || word1 == null || word2 == null) return -1;
		if(word1.length() == 0 || word2.length() == 0) return -1;
		if(word1.equals(word2)) return 0;
		
		int shortestDistance = Integer.MAX_VALUE;
		int lastW1 = 0;
		int lastW2 = 0;
		
		int i = 0;
		boolean found1 = false, found2 = false;
		while(i < words.length){
			if(words[i].equals(word1)){
				lastW1 = i;
				found1 = true;
			}
			
			if(words[i].equals(word2)) {
				lastW2 = i;
				found2 = true;
			}
			
			if(found1 && found2){
				shortestDistance = Math.min(shortestDistance, Math.abs(lastW1 - lastW2));
			}
			
			i++;
		}
		
		return found1 && found2 ? shortestDistance : -1;
	}

}
