package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.entities.AcademicClass;

public interface AcademicClassService {

	int insert(AcademicClass studyClass);
	void update(AcademicClass studyClass);
	List<AcademicClass> getAll();
	AcademicClass getAcademicClass(int id);
	void delete(AcademicClass studyClass);
	AcademicClass findByClassId(int cId);
}
