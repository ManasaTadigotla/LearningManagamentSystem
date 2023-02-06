package org.learnersacademy.lms.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.lms.dao.StudentDao;
import org.learnersacademy.lms.dao.StudentDaoImpl;
import org.learnersacademy.lms.entities.Student;

public class StudentServiceImpl implements StudentService{

	@Override
	public int insert(Student student) throws ConstraintViolationException {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		return studentDao.insert(student);
		
	}

	@Override
	public List<Student> getAll() {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		return	studentDao.getAll();		
	}

	@Override
	public void update(Student student) {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		studentDao.update(student);
		
	}

	@Override
	public void deltete(Student student) {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		studentDao.delete(student);
		
	}

	@Override
	public Student findByStudentId(int studentId) {
		StudentDao studentDao=new StudentDaoImpl();
		studentDao.findByStudentId(studentId);
		return null;
	}

}
