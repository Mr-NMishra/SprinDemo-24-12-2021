package com.mishra.services;

import java.util.List;

import com.mishra.entity.Student;

public interface StudentDAO {
	
	//Updating Student or add if not present
	public abstract Student addorUpdateStudent(Student student);
	
	//Find Single Student
	public abstract Student findStudent(String rno);
	
	//Delete any student 
	public abstract boolean deleteStudent(String rno);
	
	//list of Students
	public abstract List<Object> getStudents();
}
