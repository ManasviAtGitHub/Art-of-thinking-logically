/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search;

import java.util.Arrays;

/**
 *
 * @author Manasvi
 */
public class BinarySearch {
    
private static int binarySearch(int[] array, int start, int end, int target) {
    int middle = (start + end) / 2; 
    //1->>0+6/2=3
    //2->> 0+2/2 =1
    if (end < start) {
        return -1;
    }
    
    //1->> 15 == a[3]=36
    //2->> 15 == a[1]=15
    if (target == array[middle]) {
        return middle; 
    }
    
    //1->> 15 < 36
    //
    else if (target < array[middle]) {
        //1->> middle-1= 2
        return binarySearch(array, start, middle - 1, target); 
    } 
    else { 
        return binarySearch(array, middle + 1, end, target); 
    } 
}

    public static void main(String []args){
        
        int arr[] = {10,15,20,36,45,50,49};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,0, arr.length-1,39));
        
    
    }
    
}
