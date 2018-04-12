package edu.wiki.algorithms.tree;

public class HasPathSums {


 // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        return hasPathSumRecursive(root, sum, 0);
    }
    
    public boolean hasPathSumRecursive(TreeNode root, int sum, int prevSum){
        if(root == null){
            return false;
        }
        
        int curSum = root.val + prevSum;
        if(root.left == null && root.right == null){
            return  curSum == sum;
        }
        
        boolean curLeftSum = root.left == null ? false : hasPathSumRecursive(root.left, sum, curSum);
        boolean curRightSum = root.right == null ? false : hasPathSumRecursive(root.right, sum, curSum);
        
        return curLeftSum || curRightSum;
    }
}