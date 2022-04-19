package com.edu.student;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		//Menu from user
		
				Scanner sc=new Scanner(System.in);
				while(true) {
				System.out.println("Database operations");
				System.out.println("Enter your choice");
				System.out.println("1.To display Student information");
				System.out.println("2.Insert Student record");
				System.out.println("3.Update Student information based on id");
				System.out.println("4.Delete Student information based on id");
				System.out.println("5.Select Student based on ID");
				int ch=sc.nextInt();
				
				switch(ch) {
				case 1: StudentDataOperation.displayStudentInfo();
				        break;
				case 2: StudentDataOperation.insertStudentInfo();
				        break;
				case 3: StudentDataOperation.updateStudentInfo(); 
				         break;
				case 4:StudentDataOperation.deleteStudentInfo();
				         break;
				case 5: StudentDataOperation.selectStudentInfo();
				         break;
				 default:System.out.println("Invalid choice");
				}
				System.out.println("do u want to continue yes/no");
				String input=sc.next();  
				if(input.equalsIgnoreCase("no"))
				{
					
					break;
					
				}//if end

				}//while end
				System.out.println("end the process!");
	}//main end

}//mainapp end
