import AVLtree.AVL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    BinaryTree(){

    }
    private static class Node {

        private int data;
        private Node left;
        private Node right;
        Node(int data){
            this.data = data;
        }
    }
    private Node root;

    public Node getRoot(){
        return root;
    }
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner,root);
    }

    private void populate(Scanner scanner, Node node) {

        System.out.println("Do you want to enter the left of "+ node.data);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of "+node.data);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner,node.left);
        }

        //do for right child
        System.out.println("Do you want to entre the right of "+node.data);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.data);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if (node == null){
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }
    //Pre-order NLR
    public void preOrder(Node root){
        if(root == null)  return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //In-order LNR
    public void inOrder(Node root){
        if(root == null)  return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    //Post-order LRN
    public void postOrder(Node root){
        if(root == null)  return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }
    //Breadth-First search / level order traversal
    public void BFS(Node root){

        if (root == null)   return;
        //we need queue ds to keep track of left and right child
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null)   queue.add(temp.left);
            if(temp.right != null)    queue.add(temp.right);
        }
    }
}
