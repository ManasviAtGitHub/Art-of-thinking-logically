/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_tree_2;

/**
 *
 * @author Manasvi
 */
public class AVLTree {
    public class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
               break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }



    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        
        int balance = getBalance(z);
        System.out.println("in here for "+z.key+" bal "+balance);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node in) {
        Node out = in.left;
        Node temp = out.right;
        out.right = in;
        in.left = temp;
        updateHeight(in);
        updateHeight(out);
        return out;
    }

    private Node rotateLeft(Node in) {
        Node out = in.right;
        Node temp = out.left;
        out.left = in;
        in.right = temp;
        updateHeight(in);
        updateHeight(out);
        return out;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
    
    public void printInOrder(Node root){
        
        if(root.left!=null){
            printInOrder(root.left);
        }            
        System.out.print(" "+root.key+" ");            
        if(root.right!=null){
            printInOrder(root.right);
        }    
        
    }
  
    
    public static void main(String args[]){
    
        AVLTree tree = new AVLTree();
        tree.insert(43);
        tree.insert(18);
       
        tree.insert(22);
          
        tree.insert(9);
        tree.insert(21);
        tree.insert(6);
        tree.insert(63);
        tree.insert(67);
        tree.printInOrder(tree.root);
//        tree.printInOrder(tree.root);
        
    }
}
