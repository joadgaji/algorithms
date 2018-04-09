package edu.wiki.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();       
        LinkedList<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        map.put(beginWord, 1);
        int minLength = 1;
        
        while(!queue.isEmpty()){
            String curStr = queue.remove(0);
            
            if(curStr.equals(endWord)){
                return map.get(curStr);
            }
            
            char[] curArr = curStr.toCharArray();
            for(int i = 0; i < curArr.length; i++){
                for(int letter = 'a'; letter <= 'z'; letter++){
                    char temp = curArr[i];
                    if(temp != letter){
                        curArr[i] = (char)letter;
                        
                        String lookupStr = new String(curArr);
                        if(wordList.contains(lookupStr)){
                            queue.add(lookupStr);
                            map.put(lookupStr, map.get(curStr) + 1);
                            wordList.remove(lookupStr);
                        }
                        curArr[i] = temp;
                    }
                    
                }
                        
            }
          /*  
            for(String str: wordList){
                
                if(!map.containsKey(str)){
                    
                    
                    char[] curNeighbor = str.toCharArray();
                    int diff = 0;
                    
                    for(int i = 0; i < curArr.length; i++){
                        diff += (curArr[i] == curNeighbor[i]) ? 0 : 1;                
                    }

                    if(diff == 1){
                        queue.add(str);
                        map.put(str, map.get(curStr) + 1);
                    }
                }
            }*/
        }
        
        return 0;
        
        
    }
}