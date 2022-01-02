package com.mishra.StudentDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mishra.entity.Student;

@Repository
public class StudentDAO {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	public boolean checkStudent(Student student) {
		Session session= sessionFactory.openSession();
		Student receivedStudent= session.get(Student.class, student.getName());
		if(receivedStudent!=null) {
			return true;
		}
		return false;
	}
}
