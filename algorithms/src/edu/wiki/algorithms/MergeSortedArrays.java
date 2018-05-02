package edu.wiki.algorithms;

public class MergeSortedArrays {

    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        
        int i = m - 1;
        int j = n - 1;
        int lastIndex = m + n - 1;
        
        while(j >= 0 && i >= 0){
            if(nums1[i] <= nums2[j]){
                nums1[lastIndex] = nums2[j];
                j--;
            } else {
                nums1[lastIndex] = nums1[i];
                i--;
            }
            
            lastIndex--;
        }
        
        while(j >= 0){
            nums1[lastIndex] = nums2[j];
            j--;
            lastIndex--;
        }
    }
}