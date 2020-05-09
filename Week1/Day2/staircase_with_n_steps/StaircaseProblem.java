/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staircase_with_n_steps;

/**
 *
 * @author Manasvi
 */
public class StaircaseProblem {
    
    static int m=100;
    static int arr[]=new int[m];

    private static int fib_dp(int n){        
        if(n<0){
            return 0;
        }
        
        if (n==0 || n==1) 
            return arr[n]=1;
        
        if (arr[n]!=0){
            return arr[n];
        }
        

        return arr[n]=fib_dp(n-1)+fib_dp(n-2);
//        return arr[n]=fib_dp(n-1)+fib_dp(n-2)+fib_dp(n-3);
//        return arr[n]=fib_dp(n-1)+fib_dp(n-2)+fib_dp(n-3)+fib_dp(n-4);
    }
    
    
    public static int staircaseProblem(int stairs, int steps[]){

        int ways = 0;
        
        for (int w : steps){   
            ways = ways + fib_dp(stairs - w);
            System.out.println("Ways : "+ways);
        }
        
        return ways;   
    }
    
    
    public static void main(String args[]){
        
        int stairs=5;
        int steps[]={1,2};
        
//        int steps[]={1,2,3};
//        int steps[]={1,2,3,4};

        
        System.out.println(staircaseProblem(stairs,steps));
        
    
    }
    
}
