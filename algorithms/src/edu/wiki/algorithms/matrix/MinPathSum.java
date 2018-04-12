package edu.wiki.algorithms.matrix;

public class MinPathSum {

   
    /*
    only integers,
    grid is complete
    case when null
    
    approach
    1) recursive 0((m*n)^2)
    
    2) iterative 0(m*n)
    
    */
    public int minPathSum(int[][] grid) {
        if(grid == null) return 0;
        
        int m = grid.length; // column
        int n = grid[0].length; // row
        
        int i = 0;
        int j = 0;
        while(i < m){
            while(j < n){
                // get value and sum the min  from up and left
                int newVal = grid[i][j] + getMinNeighbor(grid, i, j);
                grid[i][j] = newVal;
                j++;
            }
            j = 0;
            i++;
        }
        
        return grid[m - 1][n - 1];
        
    }
    
    public int getMinNeighbor(int[][] grid, int i, int j){
        if(j == 0 && i == 0) return 0;
        
        if(i == 0) return grid[i][j-1];
        if(j == 0) return grid[i-1][j];
        
        return Math.min(grid[i][j-1], grid[i-1][j]);
    }
}