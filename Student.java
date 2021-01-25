package studentDatabase;

import java.util.Scanner;

public class Student {
	
	private int studentCount;
	private String year; 
	private String firstName;
	private String lastName;
	private String studentId;
	private int gradeLevel = 0;
	private String courses;
	private static int courseCost = 600;
	private int balance = 0;
	private static int id = 1000;
	
	public Student() {
		Scanner kb = new Scanner (System.in);
		System.out.print("Enter the first name of the student: ");
		this.firstName = kb.nextLine();
		System.out.print("Enter the last name of the student: ");
		this.lastName = kb.nextLine();
		
		System.out.print("1 : Freshman\n2 : Sophmore\n3 : Junior\n4 : Senior \nEnter the year of the student: ");
		while(this.gradeLevel < 1 || this.gradeLevel > 4) { this.gradeLevel = getInt(); }
		
		setStudentId();
	}
	
	private String setStudentId() {
		//Grade level + id
		this.studentId = (String) (gradeLevel + "" + id);
		id++;
		return studentId;
	}
	
	public void enroll() {
		//
		System.out.print("Enter the corse to enroll (0 to quit): ");
		Scanner kb = new Scanner (System.in);
		String course = kb.nextLine();
		while(!course.equals("0")) {
			if(courses == null)
				courses = course;
			else
			    courses = courses + "\n                 " + course;
			balance = balance + courseCost;
			System.out.print("Enter the corse to enroll (0 to quit): ");
			course = kb.nextLine();
		}
	}
	public void viewBalance() {
		System.out.println("Your balance is: $" + balance);
	}
	
	public void payTuition() {
		viewBalance();
		System.out.print("Please enter the payment amount $");
		int payment = getInt();
		balance = balance - payment;
		System.out.println("Thank you for your payment of $" + payment + ".");
		viewBalance();
	}
	
	public void info() {
		System.out.println("\nName:            " + firstName + " " + lastName +
				"\nGrade Level:     " + gradeLevel + 
				"\nStudent ID:      " + studentId +
				"\nCourse Enrolled: " + courses +
				"\nBalance:         " + balance);
	}
	//Integer validation
	private int getInt() {
		Scanner kb = new Scanner (System.in);
		while(!kb.hasNextInt()) {
			System.out.println("Please enter an valid integer: ");
			kb.next();
		}
		return kb.nextInt();
	}
}
