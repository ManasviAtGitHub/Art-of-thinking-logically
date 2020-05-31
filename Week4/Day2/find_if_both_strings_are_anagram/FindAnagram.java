/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find_if_both_strings_are_anagram;

import java.util.HashMap;

/**
 *
 * @author Manasvi
 */
public class FindAnagram {

    public static void checkAnagram(String s1, String s2){

        if(s1.length()!=s2.length()){
            System.out.println(s1+" and "+s2+" are not anagrams");
            return;
        }
        
        
        HashMap<Character,Integer> map = new HashMap();
        for(Character c : s1.toCharArray()){
            
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, ++count);
            }else{
                map.put(c,1);
            }             
        }
        
        // m = 1, a = 0, l=-1, y=0 => m=0,a=0,l=0,y=0
        // s2 = "l-a-y-a-l-a-m-a-l-";
        
        for(Character c : s2.toCharArray()){
            
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, --count);
            }
            
            else{
                System.out.println(s1+" and "+s2+" are not anagrams");
                return;
            }
            
        }
        
        
        
        for(int i:map.values()){
            if(i!=0){
                System.out.println(s1+" and "+s2+" are not anagrams");
                return;
            }
        }
        
        
        
        
        System.out.println(s1+" and "+s2+" are anagrams");
        
        
    }
    
    
    
    
    public static void main(String []args){
    
        String str1 = "cat";
        // m = 2, a = 4, l=2, y=1
        String str2 = "act";
        checkAnagram(str1,str2);
        
        
    }
    
}
