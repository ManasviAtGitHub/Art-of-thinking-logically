/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_no_between_1_to_n;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Manasvi
 */

/****************

*   Given a positive number N, 
*   efficiently generate binary numbers between 1 to N
*   
*   Example N = 11
*   1 ,
* 
*   10 , 11 ,
* 
*   100 , 101,  110 , 111 , 
* 
*   1000 , 1001 , 1010 , 1011
* 
* 
* 
* 

*****************/



public class GenerateBinaryNumbers {
    
    private static void generate(int n){
        
        Queue<String> q = new LinkedList<>();
        q.add("1");
        
        int i = 1;
        
        while(i++<=n){ //post increment
            
            // 1 --- 10 => 1 -- 10--
            
            q.add(q.peek()+"0");
            // 1 -- 10-- 11
            q.add(q.peek()+"1");
            // 10--11
            System.out.println(q.poll()+ " ");
            
        }
        
        
        
    }
    
    
    public static void main(String []args){
        
        int n =11;
        generate(n);
        
    }
    
    
}

































