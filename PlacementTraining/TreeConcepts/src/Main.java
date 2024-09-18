import AVLtree.AVL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        BinaryTree bst = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
//         AVL tree = new AVL();
//         for (int i = 0; i < 1000 ; i++){
//             tree.insert(i);
//         }

//        System.out.println(tree.height());

        BinaryTree bst = new BinaryTree();

//        bst.populate(new int[]{
//                5,46,78,4,6,78,6,7
//        });
        bst.populate(scanner);
        bst.display();
        bst.preOrder(bst.getRoot());
        System.out.println();
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.postOrder(bst.getRoot());
        System.out.println();
        bst.BFS(bst.getRoot());
//        bt.populate(scanner);
//        bt.display();
//        System.out.println(fun(5));
//        System.out.println(sumOfN(5));
//        System.out.println(sumOfDigits(12321));
////        reverse(51234);
//        System.out.println(reverse(51234));
//        System.out.println(palin(123454321));
//        System.out.println(count(102130));
    }
    static int fun(int n){
        if(n < 2){
            return 1;
        }
        return n*fun(n-1);
    }

    static int sumOfN(int n){
        if(n < 2){
            return n;
        }
        return n + sumOfN(n-1);
    }

    static int sumOfDigits(int n){
        if(n <= 0){
            return 0;
        }
        return (n % 10) + sumOfDigits(n/10);
    }
    //1246 ==> 6421
    static int sum = 0;
    static int reverse(int n){
        int digits = (int)(Math.log10(n) + 1);
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if(n % 10 == n) return n;
        int rem = n % 10;
        return rem * (int)Math.pow(10, digits-1)+helper(n/10, digits - 1);
    }

    static int count(int n){
        return helper1(n,0);
    }

    private static int helper1(int n, int count) {
        if(n == 0)  return count;

        if((n % 10) == 0){
            return helper1(n/10,count+1);
        }else {
            return helper1(n/10,count);
        }
    }

    static boolean palin(int n){
     return n == reverse(n);
    }
}