package edu.wiki.algorithms;

/**
 * Definition for singly-linked list.
 */
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class RemoveNthFromEnd {
    
    /*
    validation if the head is not null
    int is a valid number not negative. 
    Do we know that n is less or equal as the size of the list?
    
    Approach
    1) Iterate the list to know the size then remove the size - n element if exist or if it's a valid removal
    time O(2n) = O(n)
    
    2) create two references i and j: one is at the begining (curNth) of the list and the other is n distance ahead (endRunner). increment both until reaches the key is to create a dummy at the beginning
       the end of the list, then remove the i.next element.  
    time O(n)
    space 
    
    3) recursion that returns the number of the tail elements
    Base case node == null -> return 0
    recursive case 
       the recursive case and return the n tail elements + 1
       verify if n == tail 
         yes -> remvove element and return null
    time O(n)
    
    
    1(cur) 2 3(end) 4 5 6 7
    
    1 2 3 4 5(cur) [6] 7(end) null
    
    
    x 1 2
    
    
    cases interesitings
    [1] remove 1
    [1,2] remove 2
    
    [1,2,3,4,5] remove 2
    
    
    */
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(n <= 0) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slowRun = dummy;
        ListNode endRunner = dummy;
        for(int i = 0; i < n; i++){
            endRunner = endRunner.next;
        }
        
        // iterate until the end of list
        while(endRunner.next != null){
            slowRun = slowRun.next;
            endRunner = endRunner.next;
        }
        
        // Remove curNth
        slowRun.next = slowRun.next.next;
        return dummy.next;
    }
}