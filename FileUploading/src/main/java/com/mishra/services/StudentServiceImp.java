package com.mishra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mishra.entity.Student;

@Service
public class StudentServiceImp implements StudentService {
@Autowired
private StudentDAO studentDAO;
	
	@Override
	public Student addStudent(Student student) {
		studentDAO.addorUpdateStudent(student);
		return student;
	}
	public boolean deleteStudent(String rno){
		return studentDAO.deleteStudent(rno);
	}

	public Student updateStudent(Student student) {
		return studentDAO.addorUpdateStudent(student);
	}
	
	public Student findStudent(String rno) {
		return studentDAO.findStudent(rno);
	}
	
	public List<Object> studentList(){
		return studentDAO.getStudents();
	}
}
