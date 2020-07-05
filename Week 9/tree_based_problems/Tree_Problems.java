/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_based_problems;

import binary_tree.BinaryTree;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Manasvi
 */
public class Tree_Problems {

    public static class Node{
        Node left, right;
        int key;
        
        public Node(int key){
            this.key = key;
        }
        
        public void insert(int value){        
            if(value<=key){
                if(left == null){
                    left = new Node(value);                    
                }else{
                    left.insert(value);
                }
            }else{
            
                if(right == null){
                    right = new Node(value);                    
                }else{
                    right.insert(value);
                }             
            }            
        }        
    }
          
    
    
    
    
    public static Node LCA(Node root, int x, int y){
	if (root == null) {
            return null;
	}
	
        // if both x and y is smaller than root, LCA exists in left subtree
        //40 > 70 X
        
	if (root.key > Integer.max(x, y)) {
            return LCA(root.left, x, y);
	}
        
	// if both x and y is greater than root, LCA exists in right subtree
        else if (root.key < Integer.min(x, y)) {
            return LCA(root.right, x, y);
	}	
            return root;
    }
    
    
    
    public static int getHeight(Node root){
        if(root!=null){
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        return 0;
    }
    public static int getDiameter(Node root){
        if(root!=null){
            //get the left and right subtree height
            int left_height = getHeight(root.left);
            int right_height = getHeight(root.right);
            
            int left_diameter = getDiameter(root.left);
            int right_diameter = getDiameter(root.right);
            
            int path_through_root = left_height+right_height+1;
            
            int diameter = Math.max(left_diameter, right_diameter);
            
            return Math.max(path_through_root , diameter);
            
        }
        return 0;
    }


    


    
    public static void main(String []args){       
        Node tree = new Node(40);//root
        int arr[] ={20,10,30,60,50,45,55,70};
        for(int t:arr){
            tree.insert(t);
        }
        System.out.println(LCA(tree,45,70).key); 
        System.out.println(LCA(tree,50,55).key);
//        System.out.println(LCA(tree,45,70).key);
//        System.out.println(LCA(tree,45,50).key);
        
        
        System.out.println(getDiameter(tree));


    
}
