package com.mishra.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.mishra.entity.Student;
@Repository
public class StudentDAO {
	public boolean saveStudent(Student student) {
		Configuration configuration= new Configuration().configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		 Student receivedStudent= session.get(Student.class, student.getName());
		 if(receivedStudent!=null) {
			 session.close();
			 return false;
			 
		 }
			 session.save(student);
			 transaction.commit();
			 System.out.println("Student saved");
			 session.close();
			 return true;
		
	}
}
