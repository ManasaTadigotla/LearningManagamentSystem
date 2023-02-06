package org.learnersacademy.lms.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.lms.dao.SubjectDaoImpl;
import org.learnersacademy.lms.entities.Subject;


public class SubjectServiceImpl implements SubjectService {

	@Override
	public int insert(Subject subject) {
		SubjectDaoImpl subjectdao=new SubjectDaoImpl();
		return subjectdao.insert(subject);
		
	}

	@Override
	public List<Subject> getAll() {
		SubjectDaoImpl subjectdao=new SubjectDaoImpl();
		return subjectdao.getAll();
		
	}

	@Override
	public int update(Subject subject)  {
		SubjectDaoImpl subjectdao=new SubjectDaoImpl();
		return subjectdao.update(subject);
		
	}

	@Override
	public void delete(Subject subject) {
		SubjectDaoImpl subjectdao=new SubjectDaoImpl();
		subjectdao.delete(subject);
		
	}

	@Override
	public Subject getSubject(int sId) {
		SubjectDaoImpl subjectdao=new SubjectDaoImpl();
		return subjectdao.getSubject(sId);
		
	}

}
