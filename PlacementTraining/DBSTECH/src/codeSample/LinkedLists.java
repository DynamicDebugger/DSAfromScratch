package codeSample;

public class LinkedLists {
	
	Node head;
	int size;
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
	}
	
	public void insertAtEnd(int data) {
		
		Node node = new Node(data);
		size++;
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public void display() {
		
		if(head == null) {
			System.out.println("Empty Linked List");
		}else {
			Node temp = head;
			
			while(temp != null) {
				System.out.print("->"+temp.data);
				temp = temp.next;
			}
			System.out.println("\nSize: "+size);
		}
	}
	
	public void findNthNodeFromEnd(int n) {
		
		int index = size - n;
		
		Node temp = head;
		for(int i = 0; i < index ;i++) {
			temp = temp.next;
		}
		System.out.println("The element is "+temp.data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedLists l1 = new LinkedLists();
		l1.insertAtEnd(35);
		l1.insertAtEnd(15);
		l1.insertAtEnd(4);
		l1.insertAtEnd(20);
		
		l1.display();
		
		l1.findNthNodeFromEnd(4);
	}

}
