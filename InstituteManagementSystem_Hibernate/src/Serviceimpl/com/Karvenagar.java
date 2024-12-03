package Serviceimpl.com;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Config.HibernateUtil;
import Exception.com.BatchNotFoundException;
import Exception.com.CourseNotFoundException;
import Exception.com.FacultyNotFoundException;
import Exception.com.InvalidCourseForFacultyException;
import Exception.com.StudentNotFoundException;
import Model.com.*;
import Servicei.com.*;

public class Karvenagar implements Cjc{
Course c;
Faculty f;
Batch b;
Scanner sc=new Scanner(System.in);



	@Override
	public void addCourse() throws CourseNotFoundException{
	Session s=HibernateUtil.getSessionFactory().openSession();
	org.hibernate.Transaction tr=s.beginTransaction();
		c=new Course();
		System.out.println("Enter The Course id");
		int id=sc.nextInt();
		int temp=id;
		int count=0;
		while(temp>0) {
			temp=temp/10;
			count++;
		}
		if(count==3) {
			c.setCid(id);
		}
		else
		{
			throw new CourseNotFoundException("Invalid Course id");
		}
		System.out.println("Enter The Course name");
		c.setCname(sc.next()+sc.nextLine());
		s.save(c);
		tr.commit();
		System.out.println("Table Created Successfully");
	}
	


	
	
	@Override
	public void viewCourse() {
     Session s=HibernateUtil.getSessionFactory().openSession();
     org.hibernate.Transaction tr=s.beginTransaction();
		String hql="from Course";
		Query<Course> query=s.createQuery(hql);
		List<Course> courses=query.getResultList();
		for(Course cc:courses) {
			System.out.println(cc.getCid());
			System.out.println(cc.getCname());
		}
       tr.commit();
	}
		
	
	
	
	
	@Override
	public void addFaculty() throws FacultyNotFoundException,  InvalidCourseForFacultyException {
		Session s=HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tr=s.beginTransaction();
		f=new Faculty();
		System.out.println("Enter Faculty id here");
		int id=sc.nextInt();
		int temp1=id;
		int count=0;
		while(temp1>0) {
			temp1=temp1/10;
			count++;
		}
		if(count==3) {
			f.setFid(id);
		}
		else
		{
			throw new  FacultyNotFoundException("Invalid faculty id");
		}
		System.out.println("Enter Faculty name here");
		f.setFname(sc.next()+sc.nextLine());
		System.out.println("Enter Course Id To Assign The Faculty");
		int cid=sc.nextInt();
		Course cr=s.get(Course.class, cid);
		f.setCourse(cr);
		s.save(f);
		tr.commit();
		System.out.println("Table Of Faculty Created Successfully...");
	}

	
	
	@Override
	public void viewFaculty() {
		Session s=HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tr=s.beginTransaction();
		String hql="from Faculty";
		Query<Faculty> q=s.createQuery(hql);
		List<Faculty> l=q.getResultList();
		for(Faculty fact:l) {
			System.out.println(fact.getFid());
			System.out.println(fact.getFname());
			System.out.println( f.getCourse().getCid());
			System.out.println( f.getCourse().getCname());
		}
	}

	
	@Override
	public void addBatch() throws BatchNotFoundException {
	Session s=HibernateUtil.getSessionFactory().openSession();
	org.hibernate.Transaction tr=s.beginTransaction();	
	b=new Batch();
	System.out.println("Enter the batch id");
	int id=sc.nextInt();
	int temp=id;
	int count=0;
	while(temp>0) {
		temp=temp/10;
		count++;
	}
	if(count==3) {
		b.setBid(id);
	}
	else
	{
		throw new BatchNotFoundException("invalid batch id");
	}
	System.out.println("Enter the batch name");
	b.setBname(sc.next()+sc.nextLine());	

	System.out.println("Enter Faculty ID to Assign the Batch");
	int Bid=sc.nextInt();
	Faculty f=s.get(Faculty.class, Bid);
	b.setFaculty(f);	
	s.save(b);	
	tr.commit();
	System.out.println("Table of batch Created Successfully...!");
	
}
	
	@Override
	public void viewBatch() {
	Session s=HibernateUtil.getSessionFactory().openSession();
	org.hibernate.Transaction tr=s.beginTransaction();
	String sql="from Batch";
	Query<Batch> query=s.createQuery(sql);
	List<Batch> list=query.getResultList();
	for(Batch batch:list) {
		System.out.println(batch.getBid());
		System.out.println(batch.getBname());
		System.out.println(batch.getFaculty().getFid());
		System.out.println(batch.getFaculty().getFname());
		System.out.println(batch.getFaculty().getCourse().getCid());
		System.out.println(batch.getFaculty().getCourse().getCname());
	}
}


	
	@Override
	public void addStudent() throws StudentNotFoundException {
	    
		Session session=HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tr=session.beginTransaction();
		Student s=new Student();
		System.out.println("Enter student id");
		int id=sc.nextInt();
		int temp=id;
		int count=0;
		while(temp>0) {
			temp=temp/10;
			count++;
		}
		if(count==3) {
          s.setSid(id);
		}
		else
		{
			throw new StudentNotFoundException("invalid student id");
		}
		System.out.println("Enter student name");
		s.setSname(sc.next()+sc.nextLine());
		System.out.println("Enter Batch Id To Assign The Student");
		int bid=sc.nextInt();
		Batch b=session.get(Batch.class, bid);
		s.setBatch(b);
		session.save(s);
		tr.commit();
		System.out.println("Table OF Faculty Created Successfully...");
		}
	
	@Override
	public void viewStudent(){
	Session s=HibernateUtil.getSessionFactory().openSession();
	org.hibernate.Transaction tr=s.beginTransaction();
	String sql="from  Student";
	Query<Student> q=s.createQuery(sql);
	List<Student> li=q.getResultList();
	for(Student stu: li) {
		System.out.println(stu.getSid());
		System.out.println(stu.getSname());
		System.out.println(stu.getBatch().getBid());
		System.out.println(stu.getBatch().getBname());
		System.out.println(stu.getBatch().getFaculty().getFid());
		System.out.println( stu.getBatch().getFaculty().getFname());
		System.out.println(stu.getBatch().getFaculty().getCourse().getCid());
		System.out.println(stu.getBatch().getFaculty().getCourse().getCname());
	}
	}
}

