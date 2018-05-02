package edu.wiki.algorithms.incomplete;

import java.util.ArrayList;
import java.util.List;

public class MaxPointsStraightLine {


/**
 * Definition for a point.
 */
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
 
    /*
    Questions are stragh line is also column or row?
    Straigth means that the point are followed or can be separated
    
    Assuming it can be separated
    approach 1 is to have on structure to keep the repetitions for rows, one for columns and one for diagonal
    then have 3 max values, 1 per structure and at the end just get the biggest one
    complexity is O(4n)
    
    
    The other one is to compare translate each point and translate to the correspondad column/row/diagonal/inverseDiag
    
    The other approach is to take each piing and try to do a bfs alghorithm with the rest of the points ->
    Take one point -> add neighbours to the queue only adjacents are in the queue -> per node just do a dfs if exists wiht the condition that there is an straigh line. return the number. After processing all the queue return the max. Do the same with the rest of the lines
    
    */
    
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        
        int max = 1;
        List<Point> neighbours;
        
        for(Point cur: points){
            neighbours = getNeighbours(cur, points);
            
            for(Point neighbour : neighbours){
                
            }
        }
        
        
        return 0;
    }
    
    public List<Point> getNeighbours(Point point, Point[] points){
        ArrayList<Point> neighbours = new ArrayList<Point>();
        
        for(Point cur : points){
            if(cur.x != point.x || cur.y != point.y){
                if(Math.abs(cur.x - point.x) <= 1 && Math.abs(cur.y - point.y) <= 1){
                    neighbours.add(cur);
                }
            }
        }
        
        return neighbours;
        
    }
}