package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.entities.Subject;

public interface SubjectService {

	void insert(Subject subject);
	List<Subject> getAll();
	Subject getSubject(int sId);
	void delete(Subject subject);
	int update(Subject subject);
}
