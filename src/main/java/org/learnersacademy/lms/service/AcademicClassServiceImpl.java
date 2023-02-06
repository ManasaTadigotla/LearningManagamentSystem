package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.dao.AcademicClassDao;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl;
import org.learnersacademy.lms.entities.AcademicClass;

public class AcademicClassServiceImpl implements AcademicClassService {

	@Override
	public int insert(AcademicClass studyClass) {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		return classDao.insert(studyClass);
		
	}

	@Override
	public void update(AcademicClass studyClass) {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		classDao.update(studyClass);
		
	}

	@Override
	public List<AcademicClass> getAll() {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		return classDao.getAll();
	}

	@Override
	public AcademicClass getAcademicClass(int id) {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		return null;
	}

	@Override
	public void delete(AcademicClass studyClass) {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		classDao.delete(studyClass);
		
	}

	@Override
	public AcademicClass findByClassId(int cId) {
		AcademicClassDao classDao=new AcademicClassDaoImpl();
		return classDao.findByClassId(cId);
	}

}
