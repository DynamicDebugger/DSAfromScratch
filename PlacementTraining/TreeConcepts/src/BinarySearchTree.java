public class BinarySearchTree {

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

    public BinarySearchTree(){

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

        return node;
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
}
