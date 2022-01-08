package com.mishra.services;

import java.util.List;

import com.mishra.entity.Student;

public interface StudentService {
	public abstract Student addStudent(Student student);
	public abstract Student updateStudent(Student student);
	public abstract boolean deleteStudent(String rno);
	public abstract Student findStudent(String rno);
	public abstract List<Object> studentList();
}
