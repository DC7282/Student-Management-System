package com.dhiraj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhiraj.entity.Student;
import com.dhiraj.repository.StudentRepository;

@Service("StudService")
public class StudentService implements StudentServiceInterface {

//	place of @Autowired we are create constructor base dependency injection because when spring been have only one constructor then we avoid use of Autowired annotation
	private StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll(); //return all the list
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

}
