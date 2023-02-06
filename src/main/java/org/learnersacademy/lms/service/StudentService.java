package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.entities.Student;

public interface StudentService {
	
	int insert(Student student);
	List<Student> getAll();
	void update(Student student);
	void deltete(Student student);
	Student findByStudentId(int studentId);
}
