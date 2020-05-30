/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Manasvi
 */
public class Dynamic_data_structure {

    public static class Building<T,S>{
        
        T name;
        
        S sector;
        
        T area;
    
    
    }

    


    
    public static void main(String [] args){
        
            ArrayList al= new ArrayList();
            al.add("Shravan");
            al.add(21);
            al.add(true);
            
            ArrayList<Integer> int_al = new ArrayList();
            int_al.add(1234);
            int_al.add(3214);
            
            Building<String,Integer> a = new Building();
            a.area="kamothe";
            a.sector=18;
            a.name="Shree Ganga";
            Building<String,Integer> b = new Building();
            b.area="kamothe";
            b.sector=21;
            b.name="Shree";
            
            
            
            ArrayList<Building<String,Integer>> bldg_al1= new ArrayList();
            bldg_al1.add(a);
            bldg_al1.add(b);
            
            ArrayList<Building<String,Integer>> bldg_al2= new ArrayList();
            bldg_al2.add(a);
            bldg_al2.add(b);
            
            
            
            
            ArrayList<ArrayList<Building<String,Integer>>> list_of_bldg =
                    new ArrayList();
            
            list_of_bldg.add(bldg_al1);
            list_of_bldg.add(bldg_al2);        
                    
            System.out.println(bldg_al1.get(0).name);
            System.out.println(list_of_bldg.get(0).get(0).area);
            System.out.println(list_of_bldg.get(0).get(0).sector);
                    
                    
                    
                    
                    
                    
                    
                    
            
            
            
        
    }
    

    
}
