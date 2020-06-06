/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithims;

/**
 *
 * @author Manasvi
 */
public class Sorting {
    
    public static void printArray(String str, int arr[]){
    
        System.out.println("Output of "+str+" sort"); 
        System.out.println("----------------------------------------------------");
        for(int i:arr){
            System.out.print(" "+i);            
        }
        System.out.println("\n----------------------------------------------------");
    }
    
    private static void selectionSort(int arr[]){
    
        int len = arr.length;
 
        for (int i = 0; i < len-1; i++)
        {
           
            int min = i;
            for (int j = i+1; j < len; j++)
                if (arr[j] < arr[min])
                    min = j;
 
            /* 
             */
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    
        
        
    }
    private static void bubbleSort(int arr[]){
        int len = arr.length;
        for (int i = 0; i <len-1 ; i++) {
            for (int j = 0; j <len - i - 1; j++) {
                /*                
                */
                if (arr[j] > arr[j+1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    
        
        
    }
    private static void insertionSort(int arr[]){
    
        int len = arr.length;
        int key, i, j;
        for(i=1; i<len;i++){
            
            key = arr[i];
            j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1]= key;
            
            
        }
    
        
        
    }

    
    private static void mergesort(int arr[],int low, int high){
	if(low < high){
            int middle = low + (high - low) / 2;
            mergesort(arr, low, middle);
            mergesort(arr, middle + 1, high);
            merge(arr, low, middle, high);
	}
    }
    
    private static void merge(int arr[],int low, int middle, int high){
	
        int helper[] = new int[high+1];
        
	for(int i = low; i <= high; i++){
            helper[i] = arr[i];
	}
	
        int i = low;
	int j = middle + 1;
	int k = low;

	while(i <= middle && j <= high){
            if(helper[i] <= helper[j]){
		arr[k] = helper[i];
		i++;
            } 
            else {
                arr[k] = helper[j];
		j++;
            }
            
            k++;
	}

	while( i <= middle){
            arr[k] = helper[i];
            k++;
            i++;
	}
    }
        
    
    private static int partition(int arr[], int low,int high){
        
        //pivot element
        int pivot = arr[high];
        int pointer1 = (low - 1);
        //put in order where  left <= pivot < right
        
        for(int pointer2 = low; pointer2< high; pointer2++){
            if(arr[pointer2] <= pivot){
                pointer1++;
                int temp = arr[pointer1];
                arr[pointer1] = arr[pointer2];
                arr[pointer2] = temp;
            }
        }
        
        int temp = arr[pointer1+1];
        arr[pointer1+1] = arr[high];
        arr[high] = temp;
        
        return (pointer1+1);
    
    }
    
    
    private static void quickSort(int arr[],int low,int high){
    
        if(low<high){
            
            int pivot= partition(arr, low, high);
//            System.out.println("pivot value :"+pivot);
            
            quickSort(arr, low, pivot-1);// 
            
            quickSort(arr, pivot+1,high);// 
            
        }
        
        
    
            
    }
    
    
    
    public static void main(String args[]){
    
        int arr[]={15,16,1,2,-8,-9,-17,-21};
        mergesort(arr,0,arr.length-1);
        printArray("Merge",arr);
//        bubbleSort(arr);
//        printArray("Bubble",arr);
//        selectionSort(arr);
//        printArray("Selection",arr);
//        insertionSort(arr);
//        printArray("Insertion",arr);                
//        quickSort(arr,0, arr.length-1);
//        printArray("Quick",arr);                

    
    }
    
}
