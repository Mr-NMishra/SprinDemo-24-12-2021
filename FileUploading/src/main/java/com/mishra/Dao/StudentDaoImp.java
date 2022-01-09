package com.mishra.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mishra.entity.Student;
import com.mishra.services.StudentDAO;

@Repository
public class StudentDaoImp implements StudentDAO {
	@Autowired
	private SessionFactory factoryBean;

	@Override
	public Student addorUpdateStudent(Student student) {
		Session session = factoryBean.openSession();
		Transaction transaction = session.beginTransaction();
		Student savedStudent = findStudent(student.getRno());
		if (savedStudent == null) {
			session.save(student);
			System.out.println("Student " + student.getName() + " saved");
		} else {
			System.out.println("This roll no Already avilable");
			session.update(student);
			System.out.println("Student updated");
		}
		transaction.commit();
		return student;
	}

	@Override
	public Student findStudent(String rno) {
		Session session = factoryBean.openSession();
		Student student = session.get(Student.class, rno);
		session.close();
		return student;
	}

	@Override
	public boolean deleteStudent(String rno) {
		// TODO checck the student if found delete else retun message
		 Student savedStudent=findStudent(rno);
		 if(savedStudent!=null) {
			 Session session=factoryBean.openSession();
			 session.delete(savedStudent);
			 session.beginTransaction().commit();
			 return true;
		 }else {
			 System.out.println(" No Student found with this roll no ");
		 }
		 
		return false;
	}

	@Override
	public List<Object> getStudents() {
		// TODO Auto-generated method stub
		Session session=factoryBean.openSession();
		Query query= session.createQuery("From Student");
		List<Object> studentList= query.getResultList();
		return studentList;
	}
	

}
