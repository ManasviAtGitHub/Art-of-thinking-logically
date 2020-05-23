/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure_from_scratch;

import java.util.Arrays;

/**
 *
 * @author Manasvi
 */
public class ScratchQueue {
    
    Alphabet []letters;
    
    
    public boolean isEmpty(){
        
        //this means queue is not empty
        if(this.letters[0]!=null){            
            return false;
        }
    
        return true;
    }
    
    
    public Alphabet peek(){
        
        if(isEmpty() == false){            
            return letters[0];
        }
    
        return null;
    }
    
    public Alphabet poll(){
        
        if(!isEmpty()){            
            Alphabet copy = letters[0];
            Alphabet []newArray = new Alphabet[letters.length-1];
            newArray = Arrays.copyOfRange(letters, 1, letters.length);                        
            letters = newArray;
            return copy;
        }
        
        return null;
    }
    
    public void printQueue(){
        if(!isEmpty()){
            System.out.println("Showing queue");
            for(Alphabet name:letters){
                System.out.print(" "+name.letterName);    
            }
            System.out.println(" ");
        }
    }
    
    public boolean add(Alphabet element){
        
        if(isEmpty() == false){ 
            
            // letters => 4 newArray 4+1
            Alphabet []newArray = new Alphabet[letters.length+1];
            
            for(int i=0; i<letters.length;i++){
                newArray[i] = letters[i];
            }
            //newArray => 5 , 5-1 = 4
            newArray[newArray.length-1] = element;
            
            letters = newArray;
            return true;
        }
        
        return false;
    
    }
    
    
    
    
}
