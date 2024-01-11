package singleLinkedList;

public class CircularSingleLinkedList {
	
	int size;//size part
	Node head;//points first element
	Node tail;//points last element
	
	class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
	}
	
	
	public void insertAtStart(int data) {
		
		
		//insertion at start only need to update the head
		Node newNode = new Node(data);
		
		if(head == null){
			tail = newNode;
			newNode.next = tail;//points that node itself
			
		}else {
			newNode.next = tail.next;
			tail.next = newNode;
		}	
		
		head = newNode;
		size++;
	}
	
	public void insertAtEnd(int data) {
		
		//insert at last 
		Node newNode = new Node(data);//Node is created
		
		if(head == null) {
			head = newNode;
			newNode.next = head;
		}else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}
	
	public void display() {
		
		Node temp = head;
		if(head == null) {
			System.out.println("Their is nothing to print");
			
		}
		else {
			System.out.print("Linked List: ");
			
			do {
				System.out.print(" -> "+temp.data);
				temp = temp.next;
			}while(temp.next != head.next);
		}
	}
	
	public void insertAtPos(int data,int pos) {
		
		Node newNode = new Node(data);
		Node temp = head;
		
		if(pos == 1) {
			
			newNode.next = head;
			tail.next = newNode;
			head = newNode;
			size++;
		
		}else {
			
			for(int i = 1 ; i < pos - 1 ; i++) {
				while(temp != null){
					temp = temp.next;
				}
			}
			
			if(temp != null) {
				newNode.next = temp.next;
				temp.next = newNode;
				size++;
			}else {
				System.out.println("The previous Node is null");
			}
		}
	}
	
	public int deleteAtStart() {
		
		Node temp = head;
		
		head = temp.next;
		tail.next = head;
		
		size--;
		
		return temp.data;
	}
	
	public int deleteAtEnd() {
		
		Node temp = head;
		
		int val = tail.data;
		
		if(head == tail) {
			head = null;
			tail = null;
		}else {
		while(temp.next != tail) {
			temp = temp.next;
		}
		
		temp.next = tail.next;
		tail = temp;
		}
		size--;
		
		return val;
	}
	
	//delete by element
	public int delete(int key){
		
		Node temp = head;
		Node prev = head;
		
		if(head == tail) {
			if(temp.data == key) {
			head = null;
			tail = null;
			
			size--;
			return temp.data;
			}
		}
		
		if(head.data == key) {
			
			head = head.next;
			tail.next = head;
			size --;
			
			return temp.data;
			
		}else {
		
		do {
			
			if(temp.data == key) {
				
				if(temp == tail) {
					
					prev.next = temp.next;
					//temp.next = null;
					tail = prev;
				
				}else {
					
					prev.next = temp.next;//address point changes
					//temp.next = null;

				}
				size--;
				return temp.data;
			}	
			
			prev = temp;
			temp = temp.next;
			
		}while(temp.next != head.next);
		}
		
		return -1;
	}
	
	//delete by pos
	public int deleteByPos(int pos) {
		
		Node temp = head;
		if(pos == 1) {
			return deleteAtStart();
		}else {
			
			for(int i = 1 ; i < pos - 1 && temp != null ; i++) {
				
					temp = temp.next;
				
			}
			
			int nd = temp.next.data;
			
			if(tail.data == nd) {
				tail = temp;
			}
			
			temp.next = temp.next.next;
			size--;
			
			return nd;
		}
	}
}
