package edu.wiki.algorithms;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));

	}
	
	public static String shortestPalindrome(String s) {
	    int i=0; 
	    int j=s.length()-1;
	 
	    while(j>=0){
	        if(s.charAt(i)==s.charAt(j)){
	            i++;
	        }
	        j--;
	    }
	 
	    if(i==s.length())
	        return s;
	 
	    String suffix = s.substring(i);
	    System.out.println(suffix);
	    String prefix = new StringBuilder(suffix).reverse().toString();
	    System.out.println(prefix);
	    String mid = shortestPalindrome(s.substring(0, i));
	    System.out.println(mid);
	    return prefix+mid+suffix;
	}

}
