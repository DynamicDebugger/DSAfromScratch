package doublyLinkedlist;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		DoubleLinkedList dl = new DoubleLinkedList();
		
		dl.insertAtStart(42);
		dl.insertAtStart(41);
		dl.insertAtEnd(43);
		dl.insertAtEnd(45);
		
		System.out.println("\nThe Size of the List is "+ dl.size);
		//dl.display();
		/*
		System.out.print("\nEnter the element to be inserted: ");
		int val = in.nextInt();
		System.out.print("\nEnter its position to be inserted: ");
		int pos = in.nextInt();
		if(pos < 1 || pos > dl.size)
			System.out.println("Invalid positon");
		else
			dl.insertAtpos(val, pos);
		*/
		dl.reverse();
		
		System.out.println("\n"+Arrays.toString(dl.delete(41)));
		
		in.close();
	}
}
