/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package return_if_max_of_right;

import java.util.Stack;

/**
 *
 * @author Manasvi
 */
public class MaxFromRight {
    
                

            




    



            
            
    
    
    
    
    
    private static void findMax(int []arr){
        Stack<Integer> stack = new Stack();
        
        for (int value : arr){
            //1st ==> value =10
            //2nd ==> value = 4   
            //stack 10 < 4
            //3rd ==> value = 6
            //stack 4 < 6
            // pop
            //stack 10 < 6
            //4th ==> value = 3
            // 6 < 10, 
            //5th ==> value = 5
            //stack 3 < 5
            // pop
            //stack 6 < 5
    
            while(stack.isEmpty()==false && stack.peek() < value){
                
                stack.pop();
            }

            //1st       | 10
            //2nd     4 | 10
            //3rd     6 | 10
            //4th   3| 6 | 10
            //5th   5| 6 | 10 
            
            stack.push(value);
        
        }
        
        
        
        
        while(!stack.isEmpty()){
            
            System.out.print(stack.pop()+" ");
        }
    
    }
    
    
    public static void main(String []args){
        
        int []arr = {10, 4, 6, 3, 5};
        findMax(arr);
        
    }
    
}
