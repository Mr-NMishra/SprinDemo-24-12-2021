package com.mishra.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mishra.StudentDAO.StudentDAO;
import com.mishra.entity.Student;

@Repository
public class StudentService {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Autowired(required=true)
	private StudentDAO studentDao;
	public boolean addStudent(Student student) {
		
		boolean flag=studentDao.checkStudent(student);
		if(flag) {
			return false;
		}else {
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			 session.save(student);
			 transaction.commit();
			 System.out.println("Student saved");
			 session.close();
			 return true;
		}

//		
//		 Student receivedStudent= session.get(Student.class, student.getName());
//		 if(receivedStudent!=null) {
//			 session.close();
//			 return false;
//			 
//		 }
//			
	}
}
