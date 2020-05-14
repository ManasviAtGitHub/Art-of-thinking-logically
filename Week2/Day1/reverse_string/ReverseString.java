/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse_string;

/**
 *
 * @author Manasvi
 */
public class ReverseString {
    private static void printReverse(char [] str) {
        reverseString(0, str);
    }
    
    static String rev="";
    private static void reverseString(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        reverseString(index + 1, str);
        System.out.print(str[index]);
        
        rev+=str[index];
        
    }
    
    
    
    
    private static void printReverseWithTwoPointer(char [] str) {
        movePointers(0 , str.length-1, str);
    }
    
    private static void movePointers(int pointer1 , int pointer2, char [] str){
        
            
            if (pointer1==pointer2){
                return;
            }else if(pointer2<pointer1){
                return;
            }
                  
            else{
//                System.out.println("pointer1 "+pointer1+" pointer2 "+pointer2);
                char swap = str[pointer2];
                str[pointer2] = str[pointer1];
                str[pointer1] = swap;
                
                pointer1+=1;
                pointer2-=1;
                
                movePointers(pointer1, pointer2, str);                 
            }
    }
    
    public static void main (String arg[]){
//        printReverse("Google".toCharArray());
//        System.out.println();
//        
//        System.out.println(rev);
        
        char rev[]= {'G','R','A','P','E','S'};
        printReverseWithTwoPointer(rev);        
        System.out.println(rev);
        
    
    }
}
