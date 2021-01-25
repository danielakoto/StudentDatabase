package studentDatabase;

import java.util.Scanner;

//port java.util.*;
public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		
		// Ask how many new users want to add
		System.out.print("Enter the number of new students to enroll: ");
		int size = getInt();
		Student[] students = new Student[size];
		
		
		//Create n number of new students
		for(int i = 0; i < size; i++) {
			students[i] = new Student();
		    students[i].enroll();
		    students[i].payTuition();
		}
		
		for(int i = 0; i < size; i++) {
		    students[i].info();
		}
	}
	public static int getInt() {
		Scanner kb = new Scanner (System.in);
		while(!kb.hasNextInt()) {
			System.out.print("Please enter an valid integer: ");
			kb.next();
		}
		return kb.nextInt();
	}

}
