package edu.wiki.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	class Pair {
		int num;
		int count;

		public Pair(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		TopKFrequent top= new TopKFrequent();
		System.out.println(top.topKFrequent(new int[]{4,5,7,8,5,3,4,6,7,8,5,5,4,2,2,4,5,6,7,8,4,5,6},2));
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		// create a min heap
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(
				new Comparator<Pair>() {
					public int compare(Pair a, Pair b) {
						return Integer.compare(a.count, b.count);
					}
				});
		// maintain a heap of size k.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Pair p = new Pair(entry.getKey(), entry.getValue());
			queue.offer(p);
			System.out.println(p.num);
			if (queue.size() > k) {
				Pair p1 = queue.poll();
				System.out.println("sale" + p1.num + " count:" + p1.count);
				
			}
		}
		// get all elements from the heap
		List<Integer> result = new ArrayList<Integer>();
		while (queue.size() > 0) {
			result.add(queue.poll().num);
		}
		// reverse the order
		Collections.reverse(result);
		return result;
	}
}