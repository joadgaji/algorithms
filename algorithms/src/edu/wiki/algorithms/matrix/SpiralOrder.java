package edu.wiki.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        
        if(matrix == null) return null;
        if(matrix.length == 0 || matrix[0].length == 0) return order;
        
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns
        
        int msize = matrix.length; // rows
        int nsize = matrix[0].length; // columns
        
        int row = 0;
        int column = 0;
        int layer = 1;
        while(m > 0 && n > 0){
            if(m >= 2 && n >= 2){
                // complete spiral
                while(column < nsize - layer){
                    order.add(matrix[row][column]);
                    column++;
                }
                
                while(row < msize - layer){
                    order.add(matrix[row][column]);
                    row++;
                }
                
                while(column >= layer){
                    order.add(matrix[row][column]);
                    column--;
                }
                
                while(row >= layer){
                    order.add(matrix[row][column]);
                    row--;
                }
                
                column++;
                row++;
                m = m - 2;
                n = n - 2;
                layer++;
                
            }else if(n == 1){
                // complete row
                while(row <= msize - layer){
                    order.add(matrix[row][column]);
                    row++;
                }
                break;
                
            } else {
                // complete column
                 while(column <= nsize - layer){
                    order.add(matrix[row][column]);
                    column++;
                }
                break;
            }
        }
        
        return order;
    }
}