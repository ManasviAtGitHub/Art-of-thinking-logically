/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops_recursion;

/**
 *
 * @author Manasvi
 */
public class LoopsAndRecursion {
    static int max=-1;
    
    public static int recurseArray(int index, int findmax[]){
        
        if (index<0){
            return 0;
        }
        else{
        
            if (max<findmax[index]){
                max = findmax[index];
            }
            
            return recurseArray(index-1,findmax);
        }
        
    }

    public static void loopArray(int findmax[]){
                       
        for(int i =0; i<findmax.length;i++){
        
            if (max<findmax[i]){
                max = findmax[i];
            }
        }       
    }
    
    public static void main(String args[]){
        
        int findmax[] = {10,20,35,15,64,89,72};
//        
//        loopArray(findmax);
//        System.out.println(max);
        
        
//        max=-1;
        
        
        recurseArray(findmax.length-1,findmax); 
        System.out.println(max);
        
    }
    
    
    
}
