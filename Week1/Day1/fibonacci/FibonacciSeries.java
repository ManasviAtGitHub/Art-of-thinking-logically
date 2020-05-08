/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Manasvi
 */
public class FibonacciSeries {
    
    //fibonacci with overlapping sub_problems(recursive)
    
    static int counter=0;
    private static int fib(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        
        //count number of recursive calls
        counter+=1;
        
        return fib(n-1)+fib(n-2);    
    }

    
    //fibonacci with dynamic programming approach(Memoization)
    static int arr[];
    
    private static int fib_dp(int n){
        
        if(n<0){
            return 0;
        }
        if (n==0 || n==1) 
            return arr[n]=1; 

        if (arr[n]!=0){
            return arr[n];
        }
        
        
        //count number of recursive calls
        counter+=1;
        
        return arr[n]=fib_dp(n-1)+fib_dp(n-2);
    
    
    }
    
    
    
    
    public static void main(String args[]){
        
        int f=30;
        System.out.println(fib(f));
        System.out.println(
          "Number of recursive calls : "+counter);
        
        counter=0;

        arr=new int[f+1];
        System.out.println(fib_dp(f));
        System.out.println(
          "Number of recursive calls : "+counter);
        
//        for (int i = 0; i<arr.length;i++){
//            System.out.println("Array : "+arr[i]);
//        }
        
    }
}
