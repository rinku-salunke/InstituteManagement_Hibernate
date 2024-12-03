package client.com;
import Servicei.com.*;
import Serviceimpl.com.*;
import java.util.Scanner;

import Exception.com.BatchNotFoundException;
import Exception.com.CourseNotFoundException;
import Exception.com.FacultyNotFoundException;
import Exception.com.InvalidCourseForFacultyException;
import Exception.com.StudentNotFoundException;

public class Test {
public static void main(String[] args) throws CourseNotFoundException, FacultyNotFoundException, InvalidCourseForFacultyException {
Cjc c=new Karvenagar();
try (Scanner sc = new Scanner(System.in)) {
	while(true) {
	System.out.println("Enter Your choice to call method");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
	{
		try
		{
	    c.addCourse();
		}
		catch(CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
	  break;
	}
	case 2:
	{
		c.viewCourse();
		break;
	   	
	}
	case 3:
	{  
		try
		{
		c.addFaculty();
		}
		catch( FacultyNotFoundException t) {
			System.out.println(t.getMessage());
		}
		catch(InvalidCourseForFacultyException s) {
			System.out.println(s.getMessage());
		}
		break;
	}
	
	case 4:
	{
		c.viewFaculty();
		break;
	}
	
	
	case 5:
	{
		try {
			c.addBatch();
		} catch (BatchNotFoundException e) {
			System.out.println(e.getMessage());
		}
		break;
	}
	
	
	case 6:
	{
		c.viewBatch();
		break;
	}
	
	
	case 7:
	{
		try {
			c.addStudent();
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());	}
		break;
	}
	
	case 8:
	{
		c.viewStudent();
		break;
	}
	
	default:
	{
		System.out.println("Invalid Method ");
	}
	}
	}
}
}
}

