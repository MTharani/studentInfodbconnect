package com.edu.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDataOperation {
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;

	static Scanner sc=new Scanner(System.in);
	static int sid;
	static String sname;
	static String scourse;
    static int choice;

	public static void displayStudentInfo() 
	{
		//get the connection
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("my connection"+scon);
			String sql="select * from edustudent";
			rs=st.executeQuery(sql);
			System.out.println("ID/t/tNAME/t/tCOURSE/t/t");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
			}
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}//catch end
		
	}//display student end

	public static void insertStudentInfo() 
	{
		//get the connection
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);

			//Input data from user
			System.out.println("Enter id of student");
			sid=sc.nextInt();
			//Check id exists
			String sql="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			if(!rs.next()) {
				System.out.println("Enter student name");
				sname=sc.next();
				System.out.println("Enter student Course name");
				scourse=sc.next();

				String ins="insert into edustudent values("+sid+",'"+sname+"','"+scourse+"')";
				int  i =st.executeUpdate(ins);
				if(i>0) {
					System.out.println("Student information is registered");
				}//2.if end
			}//1.if end 
			else {
				System.out.println("Id already exists Choose another id");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}//insert end

	public static void updateStudentInfo() 
	{
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("1.update only name");
			System.out.println("2.update only course");
			System.out.println("3.update name and course");
			System.out.println("enter the choices:");
		    choice=sc.nextInt();
		    System.out.println("enter the student id:");
		    sid=sc.nextInt();
		    String sql="select * from edustudent where sid="+sid;
		    rs=st.executeQuery(sql);
		    switch(choice)
		    {
		    case 1:if(rs.next())
		    {
		    	System.out.println("Enter the changing name:");
		    	sname=sc.next();
		    	String upn="update edustudent set sname='"+sname+"' where sid="+sid;
		    	int i=st.executeUpdate(upn);
		    	if(i>0)
		    	{
		    		System.out.println("Record update");
		    	}//2.if end
		    }//1.if end
		    else
		    {
		    	System.out.println("record not exist");
		    }//else end
		    break;
		    //case 2
		    case 2: if(rs.next())
		    {
		    	System.out.println("enter the chnaging course:");
		    	scourse=sc.next();
		    	String upc="update edustudent set scourse='"+scourse+"'where sid="+sid;
		    	int i=st.executeUpdate(upc);
		    	if(i>0)
		    	{
		    		System.out.println("record update");
		    	}//2.if end
		    }//1.if end
		    else {
		    	System.out.println("record not found!");
		    }//else end
		    break;
		    //case 3
		    case 3:if(rs.next())
		    {
		    	System.out.println("Enter the changing name:");
		    	sname=sc.next();
		    	System.out.println("enter the changing course");
		    	scourse=sc.next();
		    	String upn="update edustudent set sname='"+sname+"', scourse='"+scourse+"' where sid="+sid;
		    	int i=st.executeUpdate(upn);
		    	if(i>0)
		    	{
		    		System.out.println("Record update");
		    	}//2.if end
		    }//1.if end
		    else
		    {
		    	System.out.println("record not exist");
		    }//else end
		    break;
		    //default
		    default: System.out.println("Invaild number!");
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}//update end

	public static void deleteStudentInfo()
	{
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("1.delect all record");
			System.out.println("2. delect partticular record");
			System.out.println("enter the choices:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				String sql="delete from edustudent";
				int i=st.executeUpdate(sql);
				if(i>0)
				{
					System.out.println("record all deleted");
				}else {
					System.out.println("recored is not delected");
				}
				break;
			case 2:
			System.out.println("enter the student id:");
			sid=sc.nextInt();
			String sqld="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sqld);
			if(rs.next())
			{
				String del="delete from edustudent where sid="+sid;
				int j=st.executeUpdate(del);
			if(j>0)
			{
				System.out.println("record is dellected");
			}//2.if end
			}//1.if end
			else
			{
				System.out.println("record is not found");
			}
			break;
			default:System.out.println("invalid number!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// delete end

	public static void selectStudentInfo()
	{
      
      try {
    	  scon=DbConnect.getConnection();
		st=scon.createStatement();
		System.out.println("Enter the student display the information:");
		sid=sc.nextInt();
		String sql="select * from edustudent where sid="+sid;
		rs=st.executeQuery(sql);
		System.out.println("ID\tNAME\tCOURSE");
		if(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		else
		{
			System.out.println("ID is not found!");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
      
         
	}

}
