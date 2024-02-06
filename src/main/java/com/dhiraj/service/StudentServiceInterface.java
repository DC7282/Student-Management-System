package com.dhiraj.service;

import java.util.List;

import com.dhiraj.entity.Student;

public interface StudentServiceInterface {
	List<Student> getAllStudents();

	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
