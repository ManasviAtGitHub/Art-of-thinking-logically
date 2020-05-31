/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count_duplicates_in_string;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Manasvi
 */
public class CountDuplicates {
 
    public static void count_duplicates(String str){
    
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i =0; i< str.length();i++){
            
            char chr = str.charAt(i);
            
            if(map.containsKey(chr)){
                int count = map.get(chr); //key =e => 1
                
                map.put(chr, ++count); // e => 4
            }
            
            else{
                map.put(chr, 1);
            }
        
        }
        
        
        
        
        Set<Character> set = map.keySet();
        
        for(Character chr : set){
            
            int count = map.get(chr);
            if(count>1){
                System.out.println(chr+" : "+count);
            }
        
        }
        
        
    
    }
    
    public static void main(String []args){
        
        String str= "the selfish gene";
        count_duplicates(str);
        
    }
    
    
}
