/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Manasvi
 */
public class K_Closest_Points {
    
    public static class MapCoordinates<T,S> implements Comparable<MapCoordinates>{
        
               
        T x;
        S y;
        double distance;
        

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(MapCoordinates o) {
            
            double dist = (double) o.getDistance();
            
            double distance = this.distance - dist;
            
            System.out.println(distance +" "+o.x+" "+o.y+" this "+this.x+" "+this.y);
            
            
            return (int)distance;
        } 
        

        
        
        
           


    }
    
    
    public static void main(String []args){
        
        Integer []x1 = {0, 2, -2, -1}; 
        Integer []y1= {3, 2, -2, -3};
        
        Integer x2 = 0;
        Integer y2 = 0;        
        
        int k = 2;
        
//     
        
        MapCoordinates<Integer, Integer> []coordinates = new MapCoordinates[x1.length];
        
        
        
        for (int i=0; i< x1.length;i++){
            coordinates[i] = new MapCoordinates();
            coordinates[i].x = x1[i]; 
            coordinates[i].y = y1[i];
            
            double x1_ = coordinates[i].x ;
            double sub1 = (x2 - x1_);
            
            double y1_ = coordinates[i].y;
            double sub2 = (y2 - y1_);
            
            double add = Math.pow(sub1, 2) + Math.pow(sub2, 2);
            
            coordinates[i].distance = Math.sqrt(add);
            
            System.out.println("For i = "+i+" x1 = "+x1[i]+" y1 = "+y1[i]+
                    " distance = "+coordinates[i].distance);
            
            
        }
        
        
        
        Arrays.sort(coordinates);
        

        int i = 0;
        while(i++<k)
            System.out.println(coordinates[i].x+" "+coordinates[i].y);
        
        
        
        
    }
    
}
