package SingleLinkedList;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		
		
		String end = "y";
		do {
			System.out.println("\t\tChoose your Operation");
			
			System.out.println("1.InsertionAtStart"
					+ "\n2.InsertionAtEnd"
					+ "\n3.InsertAtPosition"
					+ "\n4.ToDisplay"
					+ "\n5.Search"
					+ "\n6.DeleteAtStart"
					+ "\n7.DeleteAtEnd"
					+ "\n8.DeleteByElement"
					+ "\n9.DeleteByPosition"
					+ "\n10.SortElements(AscendingOrder)"
					+ "\n11.RotationOfList"
					+ "\n12.MaxOfList"
					+ "\n13.PrintReverse");
			
			int ch = in.nextInt();
			
			int data,pos,key;
			
			switch(ch) {
			
			case 1:
				
				System.out.print("\nEnter the element to be Inserted: ");
				data = in.nextInt();
				
				l1.insertionAtStart(data);
			
				System.out.println("The Size of List is "+l1.size);
				
				break;
			
			case 2:

				System.out.print("\nEnter the element to be Inserted: ");
				data = in.nextInt();
				
				l1.insertionAtEnd(data);
			
				System.out.println("The Size of List is "+l1.size);
				
				break;
				
			case 3:
				
				System.out.println("The Size is "+l1.size);
				
				System.out.print("\nEnter the element to be Inserted: ");
				data = in.nextInt();
				
				System.out.print("\nEnter the position to be Inserted: ");
				pos = in.nextInt();
				
				
				if(pos < 1 || pos >l1.size) {
					System.out.println("Invalid Position");
				}else {
					l1.insertAtPos(data, pos);
				}
			
				System.out.println("The Size of List is "+l1.size);
				
				break;
				
			case 4:
				l1.display();
				break;
				
			case 5:
				
				System.out.print("\nEnter the element to be searched: ");
				key = in.nextInt();
				
				System.out.println(l1.search(key));
				
				break;
				
			case 6:
				
				System.out.println("\nElement deleted: " + l1.deleteAtStart());
				
				l1.display();
				break;
				
			case 7:
				
				System.out.println("\nElement deleted: "+l1.deleteAtEnd());
				
				l1.display();
				break;
				
			case 8:
				
				l1.display();
				
				System.out.print("\nEnter the Element to be deleted: ");
				key = in.nextInt();
				
				int[] arr = l1.delete(key);
				
				System.out.println("\nElement deleted : " + arr[0] + "\nAt Position:"+arr[1]);
				
				System.out.println("After deletion :");
				l1.display();
				
				break;
				
			case 9:
				
				l1.display();
				System.out.println("The Size of List is "+l1.size);
				
				System.out.print("Enter the position to be deleted: ");
				pos = in.nextInt();
				
				l1.display();
				
				if(pos < 1 || pos >= l1.size) {
					System.out.println("Invalid Position");
				}else {
					l1.deletePos(pos);
				}
				
				break;
				
			case 10:
				
				l1.sortList();
				
				break;
				
			case 11:
				
				System.out.print("\nHow many rotation needed to be performed: ");
				int rotate = in.nextInt();
				
				for(int i = 1 ; i <= rotate ; i++ )
					l1.rotationOfList();
				
				l1.display();
				
				break;
				
			case 12:
								
				System.out.println("\nThe Max of the List is"+ l1.maxOfList());
				
				break;
				
			case 13:
				
				l1.printReverse();
				break;
			
			default:
				
				System.out.println("Invalid choices");
				
			}
			
			
			System.out.print("Do you wanna continue(y/n)? ");
			end = in.next();
			
		}while(!end.equals("N") && !end.equals("n"));
		
		
		in.close();
	}

}
