package SingleLinkedList;

public class LinkedList {
	
	//Head points towards the First Element & size denotes the no. of elements in LinkedList
	Node head;
	int size;
	
	//Node is a class with two properties namely data(val) and address of next node (next) if any
	static class Node{
		int val;
		Node next;
		Node(int data){
			this.val = data;
			next = null;
		}
	}
	
	//insertionAtStart Method is used to add element at the beginning of the List
	public void insertionAtStart(int data) {
		
		Node new_node = new Node(data);//A node is created with data and address part
		
		size++;//Incrementing the size 
		
		new_node.next = head;
		head = new_node;//make the head points first element of list
		
		System.out.println("After Insertion: ");
		display();//call the display function so that you can show the List after inserted
	}
	
	//insertionAtEnd method is used to add element at the end of List
	public void insertionAtEnd(int data) {
		
		Node new_node = new Node(data);//A node is created with data and address part
		
		size++;//Incrementing the size
		
		//if head is null their are no element in the List so the element to be added is the first
		if(head == null) {
			head = new_node;
			System.out.println("After Insertion: ");
			display();//call the display function so that you can show the List after inserted

			return;
		}
		
		//If not traverse the list to the last element then connect the LinkedList with new Node
		Node temp;
		temp = head;
		
		while(temp.next != null) 
			temp = temp.next;
		
		temp.next = new_node;
		System.out.println("After Insertion: ");
		display();//call the display function so that you can show the List after inserted

		return;
		
		
	}
	
	//Insert at Position
	public void insertAtPos(int data,int pos) {
		Node temp = head;
		
		Node newNode = new Node(data);
		if(pos == 1) {
			newNode.next = head;
			size++;
		}
		else {
			
			for(int i = 1 ; i < pos-1 ;i++) {
				if(temp != null) {
					temp = temp.next;
				}
			}
			
			if(temp != null) {
				newNode.next = temp.next;
				temp.next = newNode;
				size++;
			}else {
				System.out.print("The previous Node is null");
			}
		}
		
		display();
	}
	
	
	//display method is used to Display the Linked List element
	public void display() {
		
		Node temp;
		
		temp = head;
		
		if(temp == null)
			System.out.print("\nNothing to Print");
		else {
			System.out.print("\nLinked List: ");
			
			while(temp != null) {
			System.out.print(" -> "+temp.val  );
			temp = temp.next;
			}
		System.out.println();
		}
	}
	
	
	//Search method is used to search the element
	public String search(int k) {
		
		int pos = 1 ;
		
		Node temp = head;
		
		while(temp != null) {
			if(temp.val == k)
				return k+" Found at positon "+pos;
			
			pos++;
			temp = temp.next;
		}
		
		
		return "Not Found ";
	}
	
	//Delete at start
	public int deleteAtStart() {
		
		Node temp = head;
		if(head.next == null) {
			head =null;
			display();
			size--;
			
			return temp.val;
		}
		
		head = temp.next;
		temp.next = null;
		size--;
		display();
		
		return temp.val;
	}
	
	//delete at end
	public int deleteAtEnd() {
		
		Node temp = head;
		Node prev = null;
		if(head.next == null) {
			head = null;
			size--;
			display();
			return temp.val;
		}
		
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		size--;
		display();
		
		return temp.val;
	}
	
	//delete by element
	public int[] delete(int k) {
		
		int[] arr = new int [2];
		int pos = 1;
		
		Node temp = head;
		Node prev = head;
		
		if(temp.next == null) {
			if(temp.val == k)
				head = null;
		}
		if(temp.val == k) {
			head = temp.next;
			arr[0] = temp.val;
			arr[1] = pos;
			return arr;
		}
		while(temp != null) {
			
			if(temp.val == k) {
				prev.next = temp.next;
				arr[0] = temp.val;
				arr[1] = pos;
				
				return arr;
			}
			pos++;
			prev = temp;
			temp = temp.next;
		}
		
		return arr;
	}
	
	
	//delete by position
	public int deletePos(int pos) {
		
		int index = 1;
		
		Node temp = head;
		Node prev = null;
		
		if(pos == 1) {
			head = head.next;
			return temp.val;
		}
		
		if(temp.next == null) {
			head = null;
			return temp.val;
		}
		while(temp != null) {
			
			if(pos == index) {
				prev.next = temp.next;
				return temp.val;
			}
			
			index++;
			prev = temp;
			temp = temp.next;
		}
		
		
		return -1;
	}
	
	
	//Rotate the List by one element
	public void rotationOfList() {
		Node temp = head;
		Node prev = head;
		
		while(temp.next != null) {
			prev = temp;
			temp =temp.next;
			
		}
		 temp.next = head;
		 prev.next = null;
		 head = temp;
		// display();
	}
	
	//Reversing the List without changing its address
	public void printReverse() {
		
		Node curNode = head;
		Node prev = null;
		Node next = null;
		
		while(curNode != null) {
			next = curNode.next;
			curNode.next = prev;
			prev = curNode;
			curNode = next;
		}
		head = prev;
		display();
	}
	
	//Find the max Among the given LinkedList
	public int maxOfList() {
		
		Node temp = head;
		
		int max = 0;
		
		//Traverse through the list and update the max in each iteration
		if(head == null) {
			return -1;
		}
		
		
		while(temp != null) {
			int dt = temp.val;
			
			if(dt > max)
				max =dt;
			
			temp = temp.next;//updatition
		}
		
		return max;
	}
	
	
	//sort method is used to sort the list in ascending order
	public void sortList() {
	    Node curNode = head;

	    while (curNode != null) {
	        Node temp = curNode.next;

	        while (temp != null) {
	            if (curNode.val > temp.val) {
	                // Swap values
	                int tempValue = curNode.val;
	                curNode.val = temp.val;
	                temp.val = tempValue;
	            }
	            temp = temp.next;
	        }
	        curNode = curNode.next;
	    }

	    display();
	}
}
	
     

