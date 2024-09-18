package AVLtree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    public class Node{

        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }

        public int getVal(){
            return val;
        }
    }

    private Node root;

    public boolean isEmpty(){
        return root == null;
    }

    public AVL(){

    }
    public int height() {
        return height(root);
    }
    public int height(Node node){
        if (node == null)  return -1;

        return node.height;
    }

    public Node getRoot(){
        return root;
    }
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {

        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.val){
            node.left = insert(value,node.left);
        }

        if(value > node.val){
            node.right = insert(value,node.right);
        }

        node.height = (Math.max(height(node.left), height(node.right)) + 1);

        return rotate(node);
    }

    private Node rotate(Node node) {

        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1){
            //right heavy
            if (height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    //AVL ROTATION
    //LEFT ROTATE
    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left) , height(c.right)+ 1);

        return p;
    }

    //Right Rotate
    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }
    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {

        if(node == null){
            return;
        }

        System.out.println(details+node.val);
        display(node.left,"Left child of " + node.val + ": ");
        display(node.right,"Right child of " + node.val + ": ");
    }

    //populate
    public void populate(int[] nums){
        for (int num : nums) {
            this.insert(num);
        }
    }

    //Pre-order NLR
    public void preOrder(Node root){
        if(root == null)  return;
        System.out.print(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //In-order LNR
    public void inOrder(Node root){
        if(root == null)  return;
        preOrder(root.left);
        System.out.print(root.val+ " ");
        preOrder(root.right);
    }
    //Post-order LRN
    public void postOrder(Node root){
        if(root == null)  return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val+ " ");
    }

    //Breadth-First search / level order traversal
    public void BFS(Node root){
        if (root == null)   return;

        //we need queue ds to keep track of left and right child
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.val);
            if(temp.left != null)    queue.add(temp.left);
            if(temp.right != null)  queue.add(temp.right);
        }
    }
}

