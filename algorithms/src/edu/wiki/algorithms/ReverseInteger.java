package edu.wiki.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

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
    
    
    public static void main(String[] args) {
    	LinkedList<String> strArr = new LinkedList<>();
        strArr.add("one");
        strArr.add("two");
        System.out.println(strArr.remove());
        // poll is like remove
        // getFirst() getLast(), 
        
        ArrayList<String> strArr2 = new ArrayList<>();
        strArr2.add("one");
        strArr2.add("two");
        System.out.println(strArr2.remove(0));
        strArr2.toArray();
        
        
        ArrayDeque<String> strQueue = new ArrayDeque<>();
        strQueue.push("one"); // offer
        strQueue.push("two");
        System.out.println(strQueue.pop()); //poll
        
        Stack<String> stack = new Stack<>();
        stack.add("one");
        stack.add("two");
        stack.add("three");
        System.out.println("stack pop "+ stack.pop());
        
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("one");
        priorityQueue.offer("two");
        priorityQueue.offer("four");
        System.out.println(priorityQueue.poll());
        
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.offer(2);
        priorityQueue2.offer(1);
        priorityQueue2.offer(3);
        System.out.println("pq2 " + priorityQueue2.poll());
        
        
        String str = "abc";
        Arrays.sort(str.toCharArray());
        
        TreeSet<Integer> hash = new TreeSet<>();
        hash.add(4);
        hash.add(14);
        hash.add(3);
        hash.add(8);
        hash.subSet(0, 1);
       
        System.out.println("hash iteratori first: " + hash.iterator().next());

        StringBuilder builder = new StringBuilder();
        
        System.out.println("hola".substring(1));
        
        HashMap<Integer, Integer> mapa= new HashMap<>();
        mapa.entrySet();
        mapa.get("");
        
	}
}