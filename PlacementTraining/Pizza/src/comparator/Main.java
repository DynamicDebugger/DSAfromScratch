package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
	public static void main(String[] args) {
		
		List<Student> ls = new ArrayList<>();
		
		ls.add( new Student(163,"Bala",19));
		ls.add(new Student(346,"Dris",19));
		ls.add(new Student(130,"Arun Deva",20));
		
		for(Student o : ls) {
			System.out.println(o.toString());
		}
		
		//Comparator<Student> cmp = new Student(); 
		//Collections.sort(ls,cmp );
		/*Collections.sort(ls);
		for(Student o : ls) {
			System.out.println(o.toString());
		}*/
		Comparator<Student> ob = new Comparator<>()
				{
			public int compare(Student o1,Student o2) {
				//return o1.getName().compareTo(o2.getName());
				if(o1.getRoll() < o2.getRoll())
					return 1;
				
				
				return -1;
			}
				};
				
		Collections.sort(ls,ob);
		
		for(Student o : ls) {
			System.out.println(o.toString());
		
		}			
	}
}
