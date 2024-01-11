package StackArray;

public class StackArray {

	int capacity;
	int top;
	int[] arr;
	
	StackArray(int size){
		arr= new int[size];
		capacity = size;
		top = -1;
	}
	
	public void push(int data) {
		
		if(isFull()) {
			System.out.println("Stack OverFlow");
			return;
		}
		
		arr[++top] = data;
		
	}
	public int pop() {
		
		if(isEmpty()) {
			System.out.println("Stack UnderFlow");
			return -1;
		}
		
		int element = arr[top--];
		
		return element;
	}
	public void printStack() {
		
		System.out.print("\nStack\t");
		for(int i = 0 ; i <= top ; i++) {
			System.out.print(" => "+arr[i]);
		}
	}
	public int peek() {
		return arr[top];
	}
	
	public boolean isFull() {
		return top == capacity;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	
	public static void main(String[] args) {
		
		StackArray stack = new StackArray(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.printStack();
		
		System.out.println("\nThe element popped is " +stack.pop());
		
		stack.printStack();
		
		System.out.println("\nThe peek is " +stack.peek());
		
		System.out.println(stack.isFull());
		
		System.out.println(stack.isEmpty());
	}
}
