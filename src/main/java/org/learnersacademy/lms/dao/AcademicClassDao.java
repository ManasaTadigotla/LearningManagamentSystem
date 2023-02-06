package org.learnersacademy.lms.dao;

import java.util.List;

import org.learnersacademy.lms.entities.AcademicClass;

public interface AcademicClassDao {

	void insert(AcademicClass studyClass);
	List<AcademicClass> getAll();
	void delete(AcademicClass studyClass);
	void update(AcademicClass studyClass);
	//public AcademicClass findByClassId(int cId);
	//void update(AcademicClass studClass,int cId);
	AcademicClass findByClassId(int cId);
	List<AcademicClass> getClassesDetails(int cId);
	
	
	
}
