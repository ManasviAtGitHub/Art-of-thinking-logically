/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ice_cream_parlour_problem;

import java.util.Arrays;

/**
 *
 * @author Manasvi
 */
public class IceCreamParlour {

    public static int indexOf(int[] menu, int value, int excludeThis){
        
        
        for(int i =0; i< menu.length; i++){            
            if(menu[i]==value && i != excludeThis){        
                return i;                
            }        
        }       //O(n)
        return -1;        
    }
    
    
    
    
    public static int[] getIndicesFromValues(int []menu, int value1, int value2){
        
        //finding index of element
        //make sure we don't find the same twice,
        //if two icecreams have same price.
        //therefore a marker is used -1
        //and in next the index1 is used
        int index1 = indexOf(menu, value1, -1);//O(n)
        int index2 = indexOf(menu, value2, index1);//O(n)
        
        //just to put in increasing order
        // min and max functions are used.
        int []indices = {Math.min(index1, index2),Math.max(index1, index2) }; //O(1)
        
        return indices;
    }
    
    public static int[] findChoices(int []menu, int money){
        
        //creates a new copy but "NOT" a reference to original
        int []sortedMenu = menu.clone();
        
        //sort the cloned copy
        Arrays.sort(sortedMenu);  // O(n)+
        
        //iterate through every element
        for (int i=0;i<sortedMenu.length;i++){//n
            
            
            int complement = money - sortedMenu[i];  //O(1)
            
//            if(complement <=0)
//                continue;
            

            //searching only through above part            
            int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length,complement); ///O(log n)
            
            
            //just making sure the random locations doesn't passes..
            if(location>=0 && location<sortedMenu.length && sortedMenu[location] == complement){
                
                //collect indexes of the two values
                int []indices = getIndicesFromValues(menu,sortedMenu[i], complement); //O(n+n)=2n
                return indices;
            }
            
            
        }
        // O(n) + O(n)* O(logn) * O(n)
        //O(n) + n^2 logn
        //O(n^2 logn)
        return null;
    }

    public static void main(String args[]){
    
        int []menu = {5,10,5,9,6,7,8};
//        int []menu = {7,3,9,1,6,4};
        int money=10;
        int []arr= findChoices(menu, money);
        for(int val : arr)
            System.out.println("Index is "+val+" price is "+menu[val]);
        
        
    }
    
}
