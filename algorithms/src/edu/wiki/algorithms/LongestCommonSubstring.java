package edu.wiki.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		list1.add("4");
		list1.add("1");
		list1.add("6");
		list1.add("4");
		list1.add("6");
		
		list2.add("6");
		/*list2.add("6");
		list2.add("4");
		list2.add("6");
		list2.add("6");
		*/
		System.out.println(longestCommonSubstring(list1, list1));

	}
	
	
	/*
	 * O(n) < x < O(n*m)
	 */
	public static  List<String> longestCommonSubstring(List<String> list1, List<String> list2){
		List<String> result = new ArrayList<>();
		if(list1 == null || list2 == null) return result;
		if(list1.isEmpty() || list2.isEmpty()) return result;
		int[] longestPath = new int[]{0,0,0};
		
		// O(n)
		HashMap<String, List<Integer>> urlMap = new HashMap<>();
		for(int i = 0; i < list2.size(); i++){
			String str = list2.get(i);
			if(urlMap.containsKey(str)){
				urlMap.get(str).add(i);
			}else{
				List<Integer> positions = new ArrayList<>();
				positions.add(i);
				urlMap.put(str, positions);
			}
		}
		
		// O(n * m) worst case but average is n complexity
		int[] curResult;
		for(int i = 0; i < list1.size(); i++){
			if(list1.size() - i < longestPath[0]) break;
			curResult = getLongestPathFromPosition(list1, list2, urlMap, i);
			
			if(curResult[0] > longestPath[0]){
				longestPath = curResult;
			}
		}
		
		for(int j = longestPath[1]; j < longestPath[0] + longestPath[1]; j++){
			result.add(list1.get(j));
		}
		
		return result;
	}
	
	public static int[] getLongestPathFromPosition(List<String> list1, List<String> list2,
			HashMap<String, List<Integer>> urlMap, int pos){
		List<Integer> positions = urlMap.get(list1.get(pos));
		if(positions == null) return new int[]{0,0,0};
		
		int longestPath = 0;
		int startPosMax = -1;
		
		int curList1 = pos;
		int curList2 = 0;
		for(int curPos : positions){
			curList1 = pos;
			curList2 = curPos;
			while(curList1 < list1.size() && curList2 < list2.size()){
				if(list1.get(curList1).equals(list2.get(curList2))){
					curList1++;
					curList2++;
				} else {
					break;
				}
			}
			
			if(longestPath < curList1 - pos){
				longestPath = curList1 - pos;
				startPosMax = curPos;
			}
			
		}
		
		return new int[]{longestPath, pos, startPosMax};
	}

}
