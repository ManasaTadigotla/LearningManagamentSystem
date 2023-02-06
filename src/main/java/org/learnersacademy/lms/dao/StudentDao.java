package org.learnersacademy.lms.dao;

import java.util.List;

import org.learnersacademy.lms.dao.SubjectDaoImpl.Status;
import org.learnersacademy.lms.entities.Student;

public interface StudentDao {
	
	int insert(Student student);
	List<Student> getAll();
	void update(Student student);
	void delete(Student student);
	Student findByStudentId(int studentId);
}
