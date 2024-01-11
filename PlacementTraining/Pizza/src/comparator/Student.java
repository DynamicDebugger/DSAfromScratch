package comparator;

import java.util.Comparator;

public class Student implements Comparator<Student> {
	int roll;
	String name;
	int age;
	
	Student(int roll,String name,int age){
		super();
		this.roll = roll;
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	//Setters => set from user it shouldn't be static
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//getters => get from class it shouldn't be static
	public int getRoll() {
		return roll;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//own method for class
	public String toString() {
		return "Student [ Name => "+ name + " Roll-No => "+ roll+ " Age => "+age+"]";
	}

	/*@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}*/
	/*@Override
	public int compareTo(Student o1) {
		
		return this.getName().compareTo(o1.getName());
	}*/

	
	 
}
