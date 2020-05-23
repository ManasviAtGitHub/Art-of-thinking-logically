/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure_from_scratch;

/**
 *
 * @author Manasvi
 */
public class ScratchStack {
    
    Alphabet []letters;
    
    
    public boolean isEmpty(){
        
        //this means queue is not empty
        
        if(this.letters[letters.length-1]!=null){            
            return false;
        }
    
        return true;
    }
    
    
    public Alphabet peek(){
        
        if(isEmpty() == false){            
            return letters[letters.length-1];
        }
    
        return null;
    }
    
    public Alphabet pop(){
        
        if(!isEmpty()){            
            
            Alphabet copy = letters[letters.length-1];
            Alphabet []newArray = new Alphabet[letters.length-1];
            
            for(int i=0; i<letters.length-1; i++){                
                newArray[i] = letters[i];
            }            
            
            letters = newArray;
            return copy;
        }
        
        return null;
    }
    
    public void printStack(){
        if(!isEmpty()){
            System.out.println("Showing stack");
            for(int i=letters.length-1; i>-1;i--){
                System.out.print(" "+letters[i].letterName);    
            }
            System.out.println(" ");
        }
    }
    
    public boolean push(Alphabet element){
        
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
