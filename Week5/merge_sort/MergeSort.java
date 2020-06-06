/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge_sort;

import java.util.Arrays;

/**
 *
 * @author Manasvi
 */
public class MergeSort {
    
    private static void mergeSort(int [] a, int n){
    
        if (n<2){
            return;
        }
        int mid = n/2;
        int [] l = new int[mid];
        int [] r = new int[n-mid];
        
        for(int i = 0; i < mid; i++){
            l[i] = a[i];
        }
        
        for(int i = mid; i < n; i++){
            r[i-mid] = a[i];
        }
        mergeSort(l,mid);
        mergeSort(r,n-mid);
        merge(a,l,r,mid,n-mid);
        
    }
    
    private static void merge(int []a, int []l, int []r, int left, int right){
        int i=0, j=0, k=0;
        while(i<left && j<right){
            if(l[i] <= r[j] ){
                a[k++]=l[i++];
            }else{
                a[k++]=r[j++];
            }
        }
        
        while(i<left){
            a[k++] = l[i++];
        }
        while(j<right){
            a[k++] = r[j++];
        }
    
    }
    
    
    
    public static void main(String []args){
        
        int []array = {5, 1 ,6 ,2 ,3 ,4};
        mergeSort(array, array.length);
        for(int a : array){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
