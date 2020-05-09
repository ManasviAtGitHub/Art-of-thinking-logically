/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower_of_hanoi;

/**
 *
 * @author Manasvi
 */
public class TowerOfHanoi {
    static int moves=0;
    private static void placeDisks(int n, char source, char destination, char middle)
    {
        if(n==1){
            moves+=1;
            System.out.println(
            "Move disk 1 from source "+source+
            " to destination "+destination);
            return;
        }
        //n=3
        // source = A destination =C middle =B
        //
        //
        
        System.out.println("Call 1 : Where n= "+n+ " Source " + source+" Middle "+ middle+" Destination "+destination);
        
        placeDisks(n-1,source,middle,destination);
        //n=2
        // source = A destination =B middle =C
        //
     
        moves+=1;
        System.out.println(
         "Move disk "+n+" from source "+source+
         " to destination "+destination);
        
        
        System.out.println("Call 2 : Where n= "+n+ " Source " + middle+" Destination "+ destination+" Middle "+source);
        
        placeDisks(n-1,middle,destination,source);
    }
    
    
    public static void main(String []args){
        
        int n = 3;
        
        placeDisks(n, 'A','C','B');
        
        
        System.out.println("Number of moves required : "+moves);
    }
}
