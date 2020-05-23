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
public class EnglishLanguage {
    
    public static void main(String args[]){
        Alphabet E = new Alphabet(5, 'E', null);    
        Alphabet D = new Alphabet(4, 'D', E);
        Alphabet C = new Alphabet(3, 'C', D); 
        Alphabet B = new Alphabet(2, 'B', C);
        Alphabet A = new Alphabet(1, 'A', B);
        
        Alphabet array[] = {A,B,C,D,E};
        
        Alphabet F = new Alphabet();
        F.letterName = 'F';
        
        //calls relevant to queue (ScratchQueue)
        ScratchQueue queue = new ScratchQueue();        
        queue.letters = array;        
//        System.out.println("returns first element : "+queue.peek().letterName);
        
//        queue.printQueue();       
//        System.out.println("Polling first element : "+queue.poll().letterName);        
//        queue.printQueue();


//        queue.printQueue();       
//        System.out.println("Adding element in queue : "+queue.add(F));        
//        queue.printQueue();

        //calls relevant to stack (ScratchStack)
        ScratchStack stack = new ScratchStack();
        stack.letters = array;
        
//        stack.printStack();
        
//        System.out.println("returns first element : "+stack.peek().letterName);      
//        stack.printStack();       
//        System.out.println("PoPing first element : "+stack.pop().letterName);        
//        stack.printStack();
//        stack.printStack();       
//        System.out.println("Pushing element in stack : "+stack.push(F));        
//        stack.printStack(); ;

        
//        stack.push();
//        stack.pop();
//        stack.peek();
        
        
        
//        queue.peek(); // type of Alphabet Object
//        queue.poll(); // --" -- " --
//        queue.add();  // type of boolean
        
        
        
        
        
//        Alphabet move = A;
//        
//        System.out.println();
//        while(move!=null){
//            System.out.print(" "+move.letterName);
//            move = move.nextLetter;
//        }
//        System.out.println();
        
        
        
    }
    
}
