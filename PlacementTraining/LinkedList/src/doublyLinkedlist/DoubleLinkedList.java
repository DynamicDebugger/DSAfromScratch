package doublyLinkedlist;

public class DoubleLinkedList {
	int size;
	Node head;
	
	
	public class Node{
		
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	//Insertion at the beginning of the LinkedList
	public void insertAtStart(int data) {
		
		Node newNode = new Node(data);//Node is created
		
		if(head == null) {
			head = newNode;
			size++;
			display();
			return;
		}
		
		//If there are already elements present at the LinkedList
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		size++;
		display();
		return;	
	}
	
	//Insertion at the end of the List
	public void insertAtEnd(int data) {
		
		Node newNode = new Node(data);//Node is Created
		
		Node temp = head;
		
		if(temp == null) {
			head = newNode;
			size++;
			display();
			return;
		}
		
		//If  not then traverse to current last node to insert the element
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		newNode.prev = temp;
		size++;
		display();
		return;
		
	}
	
	//To insert at a particular position of LinkedList
	public void insertAtpos(int data,int pos) {
		
		Node temp = head;
		
		Node newNode = new Node(data);//New node is created
		
		if(pos == 1) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			size++;
			display();
			return;
		}else {
			
			for(int i = 1 ; i < pos - 1 ; i++) {
				if(temp != null) {
					temp = temp.next;
				}
			}
			
			if(temp != null) {
				newNode.prev = temp;
				newNode.next = temp.next;
				temp.next = newNode;
				size++;
			}
			else {
				System.out.println("The previous node is null");
			}
			
			display();
		}
	}
	
	//To display all the element present at DoublyLinkedList
	public void display() {
		
		Node temp = head;
		
		if(temp == null) {
			System.out.println("Their is nothing to Print");
		}else {
			System.out.print("\nLinked List :");
			while(temp != null) {
				System.out.print(" -> "+temp.data);
				temp = temp.next;
			}
		
		}
	}
	
	//To delete by element
	public int[] delete(int k){
		
		Node temp = head;
		int[] arr = new int[2];
		int pos = 1 ;
		
		while(temp != null) {
			
			if(temp.data == k) {
				
				if(temp.next == null) {
					temp.prev.next = null;
					arr[0] = pos;
					arr[1] = temp.data;
					size--;
					display();
					return arr;
				}
				if(temp.prev == null) {
					head = temp.next;
					temp.next = null;
					
					arr[0] = pos;
					arr[1] = temp.data;
					size--;
					display();
					return arr;
				}
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				
				arr[0] = pos;
				arr[1] = temp.data;
				size--;
				return arr;
			}
			pos++;
			temp = temp.next;
		}
		
		
		return arr;
	}
	
	//Reverse the printing order without changing its address
	public void reverse() {
		
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		while(last != null) {
			System.out.print(" -> "+last.data);
			last = last.prev;
		}
		
	}
}
