/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top_view_binary_tree;

/**
 *
 * @author Manasvi
 */
//public class TopViewBinaryTree {
//    
//}
import java.util.Map;
import java.util.TreeMap;


class Node
{
        int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}

}

// Pair class
class Pair<U, V>
{
	public final U data;   	// data field of a Pair
	public final V level;  	// level field of a Pair

	// Constructs a new Pair with specified values
	private Pair(U first, V second)
	{
		this.data = first;
		this.level = second;
	}

	// Factory method for creating a Typed Pair immutable instance
	public static <U, V> Pair <U, V>  of(U a, V b)
	{
		// calls private constructor
		return new Pair<>(a, b);
	}
}

public class TopViewBinaryTree
{


	public static void printTop(Node root, int dist, int level,Map<Integer, Pair<Integer, Integer>> map)
	{
		if (root == null) {
			return;
		}
		if (!map.containsKey(dist) || level < map.get(dist).level)
		{
                    map.put(dist, Pair.of(root.key, level));
		}
		TopViewBinaryTree.printTop(root.left, dist - 1, level + 1, map);
		TopViewBinaryTree.printTop(root.right, dist + 1, level + 1, map);
	}

	public static void printTop(Node root)
	{
		Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
		TopViewBinaryTree.printTop(root, 0, 0, map);
                
		for (Pair<Integer, Integer> it: map.values()) {
			System.out.print(it.data + " ");
		}
	}

	public static void main(String[] args)
	{
            Node root = new Node(40);
        
            root.left = new Node(20);
            root.right = new Node(60);
            
            root.left.left = new Node(10);	
            root.left.right = new Node(30);
            root.right.left = new Node(50);
            root.right.right = new Node(70);

            printTop(root);
	}
}