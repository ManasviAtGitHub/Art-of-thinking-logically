/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

/**
 *
 * @author Manasvi
 */
public class BinaryTree {
 
    public static class Node{
        Node left, right;
        int data;
        
        public Node(int data){
            this.data = data;
        }
        public void insert(int value){        
            if(value<=data){
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
        public boolean contains(int value){
            if(value==data){
                return true;
            }
            else if(value<=data){
                if(left==null){
                    return false;
                }else{
                    return left.contains(value);
                }
            }
            else{
                if(right == null){
                    return false;
                }
                else{
                    return right.contains(value);
                }
            }
                    
        }
        
        public void printInOrder(){
            if(left!=null){
                left.printInOrder();
            }
            System.out.print(" "+data);
            if(right!=null){
                right.printInOrder();
            }
        }
        
        public void printPostOrder(){
            
            if(left!=null){
                left.printPostOrder();
            }
            if(right!=null){
                right.printPostOrder();
            }
            System.out.print(" "+data);
        }
        
        public void printPreOrder(){
            System.out.print(" "+data);
            if(left!=null){
                left.printPreOrder();
            }           
            if(right!=null){
                right.printPreOrder();
            }
        }
        
        public void drawTree(Node tree){
            System.out.println("\t\t"+tree.data);
            
            System.out.print("\t"+tree.left.data);
            System.out.print("\t\t"+tree.right.data);
            System.out.println();
            System.out.print(tree.left.left.data);
            System.out.print("\t\t"+tree.left.right.data);
            System.out.print("  "+tree.right.left.data);
            System.out.print("\t\t"+tree.right.right.data);
            System.out.println();
        
        }
    
        public boolean isBST(Node tree){
            return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        public boolean isBST(Node tree, int min, int max){
            if (tree==null){
                return true;
            }
            if(tree.data<min || tree.data>max){
                return false;
            }
            return isBST(tree.left, min,tree.data) && isBST(tree.right,tree.data+1,max);
        }
        

    
    }
    
    
    
    public static void main(String []args){
        
        Node tree = new Node(40);//root
        int arr[] ={20,10,30,60,50,70};
        for(int t:arr){
            tree.insert(t);
        }
        System.out.println();
        tree.printInOrder();
        System.out.println();
        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
//        tree.left.data=35;
        System.out.println(tree.isBST(tree));

          
    }
}
