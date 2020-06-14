/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package more_sorting_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Manasvi
 */
public class Sort {

    
    public static void printArray(String str, Object arr[]){
    
        System.out.println("Output of "+str+" sort"); 
        System.out.println("----------------------------------------------------");
        for(Object i:arr){
            System.out.print(" "+i);            
        }
        System.out.println("\n----------------------------------------------------");
    }
    
    public static void shellSort(Integer arr[], int n){
    
        int interval =n/2;
        
        while(interval >0){
        
            
            for(int i = interval; i<n; i++){
                int temp_key = arr[i];
                int j;
                for(j=i; j>=interval 
                    && arr[j - interval]> temp_key;    
                    j-=interval)
                
                {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp_key;
            }
        
            interval = interval/2; 
            
            
        }
        
    
            
//        int len = arr.length;
//        int key, i, j;
//        for(i=1; i<len;i++){
//            
//            key = arr[i];
//            j = i-1;
//            while (j>=0 && arr[j]>key){
//                arr[j+1] = arr[j];
//                j = j-1;
//            }
//            arr[j+1]= key;
//            
//            
//        }
        
        
        
    }

    public static int bucketHash(int value){
        return value/10;        
    }
    
    public static void bucketSort(Integer list[]){
        
        List<Integer> result = new ArrayList<>();
        
        
        List<List<Integer>> buckets = new ArrayList<>(10);
        
        for(int i=0;i<10;i++){
            buckets.add(new ArrayList<>());
        }
        
        
        for(int value: list){
            
            int key = bucketHash(value);
            
            
            buckets.get(key).add(value);
        }
        for(int i=0;i<buckets.size();i++){
            if(buckets.get(i)!=null){
                Collections.sort(buckets.get(i));
                result.addAll(buckets.get(i));
            }
        }
        
        
       printArray("Bucket",result.toArray());
        
    }

    public static void countingSort(Integer arr[], int n){
        
        Integer []output = new Integer[n];
        // Find the largest element of array
        int max = arr[0];
        
        for(int i = 1; i<n; i++){            
            if(arr[i]>max)
                max = arr[i];            
        }
        
        Integer []count = new Integer[max+1];
        
        // Initialize count array with all zeros
        Arrays.fill(count, 0);               
        
        
        // Store the count of each element
        for(int i=0;i<n;i++){           
            int val = arr[i];           
            count[val]++;
        }
        
        // Store the cummulative count of each array
        for(int i = 1; i<=max; i++){
           count[i] = count[i] + count[i-1];
        }
        
        // Find the index of each element
        // of the original array in count array,
        // place the elements in output array        
        for(int i = n-1; i>=0; i--){            
            int index = arr[i]; 
            
           
            int get_count=count[index] - 1;            
            
            
            output[get_count] = arr[i];
            count[index]--;
        }        
        
        //Copy the sorted elements into original array
        for(int i=0; i<n; i++){
            arr[i] = output[i];
        }
        
        printArray("Counting", arr);
        
        
    }
  
    public static int findmax(Integer arr[]){
        int max = arr[0];
        
        for(int i=1; i< arr.length; i++){
            if(arr[i]> max)
                max = arr[i];
        }
        return max;
    
    }
    
    public static void countSort(Integer arr[], int n, int place){
        int []output = new int[n];
        int max = findmax(arr);
        
        int []count = new int[10];
        
        Arrays.fill(count, 0);
//        for (int i = 0; i < max; ++i)
//            count[i] = 0;
        
        for(int i=0;i<n;i++){
            //15/10=1%10 ==1
            int index = (arr[i]/place)%10;
            count[index]++;
        }
        for(int i = 1; i<10; i++){
            count[i] = count[i] + count[i-1];
        }
        for(int i = n-1; i>=0; i--){
            int f=(arr[i]/place)%10;
            int index = count[f] - 1;
            output[index] = arr[i];
            count[f]--;
        }
        for(int i=0; i<n; i++){
            arr[i] = output[i];
        }
        
        
    
    }
    
    public static void radixSort(Integer arr[], int n){
        
        int max = findmax(arr);
      
        //1...
        //210/1>0 
        //1 * 10 =10
        //10
        //210/10>0
        //10 * 10 =100
        //100
        //210/100>0
        //100 *10 =1000
        //1000 ....
        //210/1000 >0
        //exit
        for (int place = 1; max/place>0; place = place *10)
            countSort(arr,n,place);
        
        printArray("Radix", arr);
    }
    
    public static void main(String args[]){
        
       Integer arr[]={15,16,1,1,1,9,170,210};
//       shellSort(arr, arr.length);
//       printArray("Shell", arr);
//       countingSort(arr, arr.length);
//       bucketSort(arr); 
        radixSort(arr,arr.length);
        
       
    
    }
    

    
}
