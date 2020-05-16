/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Manasvi
 */
public class NoOfIslandsBFS {
    
    public static int numIslands(int[][] islandGrid){
        int count = 0;
        int row = islandGrid.length;
        int column = islandGrid[0].length;
        
        for (int r = 0; r<row; r++){
            for (int c = 0; c<column; c++){
                if (islandGrid[r][c] == 1){
                    count+=1;
                    BFS(islandGrid, r, c);
                }
            }
        }
        
        return count;
    
    }
    
    
    
    public static void BFS(int[][] islandGrid, int r, int c){
        if (r<0 || c<0 || r>=islandGrid.length || c>=islandGrid[0].length || islandGrid[r][c]==0){
            return;
        }
        
        
        islandGrid[r][c]=0;
        
        BFS(islandGrid,r+1,c);
        BFS(islandGrid,r-1,c);
        BFS(islandGrid,r,c+1);
        BFS(islandGrid,r,c-1);
        
    
    }
    
    
    
    public static void main(String []args){
    
        int [][] islandGrid = {        
            {1 ,1 ,1 ,1 ,0},
            {1 ,1 ,0 ,1 ,0},
            {1 ,1 ,0 ,1 ,0},
            {1 ,1 ,0 ,0 ,0},
            {0 ,0 ,0 ,0 ,0},        
        };
       
//        System.out.println(islandGrid.length);
//        System.out.println(islandGrid[0].length);
        
        System.out.println("No of Islands : "+numIslands(islandGrid));
        
        islandGrid = new int[][] {        
            {1,1,1,1,0},
            {1,1,0,0,0},
            {1,1,0,1,0},
            {0,0,0,1,0},
            {1,0,0,1,0},        
        };
        
        System.out.println("No of Islands : "+numIslands(islandGrid));
        
        



        
    }
}
