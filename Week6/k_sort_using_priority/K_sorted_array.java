/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k_sort_using_priority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Manasvi
 */
public class K_sorted_array {
    
    public static void sortArray(List<Integer> list, int k){
        
	PriorityQueue<Integer> pq = new PriorityQueue<>();
        //adding all possible index sublist for first element, i.e k+1
        pq.addAll(list.subList(0, k+1));
	int index = 0;
	// do for remaining elements of the array
	for (int i =k+1; i < list.size(); i++){
            // poll from priority_queue (min_heap here)
            list.set(index++, pq.poll());            
            // adding to priority_queue (min_heap)
            pq.add(list.get(i));
	}
	//remain last k+1 elements from priority_queue
	while (!pq.isEmpty()) {
            list.set(index++, pq.poll());
	}	
    }    
    
    public static void main(String []args){
//    
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);               
	int k = 2;
        
        sortArray(list, k);
	
        System.out.println(list);

        
        List<Integer> list_arr = Arrays.asList(70,86,50,20,10,100,200);
//      Using Min and Max HEAPS...         
        PriorityQueue<Integer> min_heap = new PriorityQueue();
        min_heap.addAll(list_arr);
        System.out.println(Arrays.asList(min_heap.toArray()));
        
        PriorityQueue<Integer> max_heap = new PriorityQueue(Collections.reverseOrder());
        max_heap.addAll(list);
        System.out.println(Arrays.asList(max_heap.toArray()));
                
    }
}
