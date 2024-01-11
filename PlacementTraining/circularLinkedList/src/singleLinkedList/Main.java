package singleLinkedList;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularSingleLinkedList ob = new CircularSingleLinkedList();
		
		ob.insertAtStart(8);
		ob.insertAtStart(4);
		ob.insertAtStart(10);
		ob.insertAtStart(20);
		ob.insertAtEnd(50);
		ob.insertAtEnd(30);
		
		ob.insertAtPos(32, 1);
		ob.display();
		System.out.println("\nThe size is "+ob.size);
		
		System.out.println("Element deleted "+ ob.deleteAtStart());
		ob.display();
		System.out.println("\nThe size is "+ob.size);
		
		System.out.println("Element deleted "+ ob.deleteAtEnd());
		ob.display();
		System.out.println("\nThe size is "+ob.size);
		
		System.out.println("\nElement deleted: "+ob.delete(50));
		ob.display();
		System.out.println("\nThe size is "+ob.size);
		
		int pos = 4;
		
		if(pos < 1 || pos < ob.size)
			System.out.println("Invalid position");
		else
		System.out.println("\nElement deleted: "+ob.deleteByPos(pos));
		
		ob.display();
		System.out.println("\nThe size is "+ob.size);
		System.out.println("Tail is "+ ob.tail.data);
		
	}
}
