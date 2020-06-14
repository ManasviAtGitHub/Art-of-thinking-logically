/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k_th_largest_element;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Manasvi
 */
public class Find_K_Largest {


    	public static int FindKthLargest(List<Integer> arr, int k)
	{
          
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
									
            pq.addAll(arr);

		// pop from max-heap exactly (k-1) times
		while (--k > 0) {
			pq.poll();
		}

		// return the root of max-heap
		return pq.peek();
	}


	public static void main(String[] args)
	{
		List<Integer> arr = Arrays.asList(7, 4, 6, 3, 9, 1);
		int k = 2;

		System.out.println(FindKthLargest(arr, k));
	}
    
    
    
    
    
    

    
}
