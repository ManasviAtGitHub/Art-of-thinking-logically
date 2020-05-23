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
public class Alphabet {

    public Alphabet(){}
    
    public Alphabet(int position, char letterName, Alphabet nextLetter) {
        this.position = position;
        this.letterName = letterName;
        this.nextLetter = nextLetter;
    }
    
    int position;
    char letterName;
    Alphabet nextLetter;
    
    
}
