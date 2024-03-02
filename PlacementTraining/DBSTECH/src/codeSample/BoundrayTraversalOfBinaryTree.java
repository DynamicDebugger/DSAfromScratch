package codeSample;

import java.util.ArrayList;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data =data;
		this.left = null;
		this.right = null;
	}
}
public class BoundrayTraversalOfBinaryTree {

	static boolean isLeaf(Node root) {
		return (root.left == null) && (root.right == null);
	}
	
	/*
	  1)check and add left boundary
	  2)add leaf in order traversal
	  3)check and add right boundary in reverse
	 */
	
	static void addLeftBoundary(Node root,ArrayList<Integer> ans) {
		Node cur = root.left;
		
		while(cur != null) {
			
			if(isLeaf(cur) == false)  ans.add(cur.data);
			
			if(cur.left != null) cur = cur.left;
			else  cur = cur.right;
		}
	}
	
	static void addRightBoundary(Node root,ArrayList<Integer> ans) {
		
		Node cur = root.right;
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		while(cur != null) {
			
			if(isLeaf(cur) == false)  temp.add(cur.data);
			
			if(cur.right != null)  cur = cur.right;
			else  cur = cur.left;
		}
		int i ;
		for(i= temp.size() - 1 ; i >=0 ;--i) {
			ans.add(temp.get(i));
		}
		//System.out.println("During right"+temp.toString());
	}
	
	static void addLeafs(Node root,ArrayList<Integer> ans) {
		
		if(isLeaf(root)) {
			ans.add(root.data);
			return;
		}
		
		if(root.left != null)  addLeafs(root.left , ans);
		if(root.right != null)  addLeafs(root.right, ans);
	}
	
	static ArrayList<Integer> printBoundary(Node node){
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		if(isLeaf(node) == false)  ans.add(node.data);
		//System.out.println("Before left "+ans.toString());
		addLeftBoundary(node,ans);
		//System.out.println("After left "+ans.toString());
		addLeafs(node,ans);
		//System.out.println("After leaf "+ans.toString());
		addRightBoundary(node,ans);
		//System.out.println("After right "+ans.toString());
		
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Node root = new Node(1);
        root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        
        ArrayList<Integer> printBoundary = printBoundary(root);
        
        for(int data : printBoundary) {
        	System.out.print(" ->"+data);
        }
        
	}

}
