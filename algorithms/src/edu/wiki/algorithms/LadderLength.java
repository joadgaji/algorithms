package edu.wiki.algorithms;

import java.util.LinkedList;
import java.util.List;

public class LadderLength {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Node> queue = new LinkedList<>();
        
        Node startNode = new Node(beginWord, 1);        
        queue.add(startNode);
        
        while(!queue.isEmpty()){
            Node curNode = queue.remove(0);
            
            if(endWord.equals(curNode.value)){
                return curNode.step;
            }
            
            char[] curArr = curNode.value.toCharArray();
            for(int i = 0; i < curArr.length; i++){
                for(char letter = 'a'; letter <= 'z'; letter++){
                    char temp = curArr[i];
                    if(curArr[i] != letter){
                        curArr[i] = letter;
                        
                        String lookupStr = new String(curArr);
                        if(wordList.contains(lookupStr)){
                            Node  newNode = new Node(lookupStr, curNode.step + 1);
                            
                            queue.add(newNode);
                            wordList.remove(lookupStr);
                        }
                        curArr[i] = temp;
                    }
                    
                }
                        
            }
        }
        return 0;
    }
    
    class Node{
        String value;
        int step;
        
        public Node(String value, int step){
            this.value = value;
            this.step = step;
        }
    }
}