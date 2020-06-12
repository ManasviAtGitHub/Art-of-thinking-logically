/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package building_heaps;

import java.util.Vector;

/**
 *
 * @author Manasvi
 */
public class Heap {
    
    public static class MaxHeap{
        private Vector<Integer> heap;

        public MaxHeap() {
            this.heap = new Vector();
        }
        
        private int parent(int child){
            
            if(child == 0)
                return Integer.MAX_VALUE;
            
            return (child - 1)/2;
        }
        
        private int leftChild(int parent){
            return (2 * parent)+1;
        }
        private int rightChild(int parent){
            return (2 * parent)+2;
        }
        private void swap(int index1, int index2){
            int element = heap.get(index1);
            heap.setElementAt(heap.get(index2), index1);
            heap.setElementAt(element, index2);
        }
        
        private void heapify_up(int child){       
            //parent < child           
            if(child>0 && heap.get(parent(child)) < heap.get(child) ){
                
                swap(child, parent(child)); //   <==== indexes
                heapify_up(parent(child));
            
            }
            
        
        }
        
        public void add(Integer element){
            heap.add(element);
            int leaf = heap.size()-1;
            heapify_up(leaf);  
        }
        public void addAll(Integer arr[]){
            for(Integer e: arr){
                add(e);
            }
            
        }
        
        public void printHeap(){
            System.out.println();
            for(Integer e : heap){
                System.out.print(" " + e);
            }
            System.out.println();
        }
        
        private void heapify_down(int parent){
            
            int left_i =leftChild(parent);
            int right_i =rightChild(parent);
            int large = parent;
            
            if(left_i<heap.size() && heap.get(left_i)>heap.get(parent)){
                large = left_i;
            }
            if(right_i<heap.size() && heap.get(right_i)>heap.get(parent)){
                large = right_i;
            }
            
            if(large != parent){
                swap(large, parent);
                heapify_down(large);
            }
            
            
        }
        
        public Integer poll(){
            
            if(heap.size()==0){
                return Integer.MIN_VALUE;
            }
            
            int root = heap.firstElement();
            heap.setElementAt(heap.lastElement(), 0);
            heap.remove(heap.size()-1);
            heapify_down(0);
            
            return root;
        }
        
        
    }
    
    
    
    
    public static void main(String args[]){
        
        MaxHeap m_h = new MaxHeap();
        
        Integer arr[] ={20,30,10,40,50,60,70};
        m_h.addAll(arr);
        m_h.printHeap();
        
        m_h.poll();
        
        m_h.printHeap();
    
    }
    
}
