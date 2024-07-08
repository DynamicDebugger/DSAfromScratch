package basics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a1 = "Bala";
		String b1 = "Bala";
		
		String a2 = new String("s");
		String b2 = new String("s");
		
		System.out.println(a1 == b1);
		System.out.println(a2.equals(b2));
		
		//pretty printing
		System.out.printf("PI: %.2f", Math.PI);
		System.out.printf("\nHello my name is %s and I am %s\n","Bala","Mathematician");
		System.out.println('a'+'b'+'c'+'d');
		System.out.println("A"+"B");
		System.out.println("Bala"+ new ArrayList<>());
		
//		System.out.println(new Integer(50)+ new ArrayList<>()); it won't work it is expression
		
		String series = "";
		for(int i = 0 ; i < 26 ; i++) {
			char ch = (char)('a' + i);
			System.out.println(ch);
			series += ch;
		}
		
		System.out.println(series);
		
		a1 = a1 + a2;
		System.out.println(Arrays.toString(a1.trim().split(" ")));
		
	
	
	}

}
