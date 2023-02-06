package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.entities.Teacher;

public interface TeacherService {
	public	void insert(Teacher teacher);
	 public	List<Teacher> getAll();
	 public Teacher getTeacher(int teachId);
	 public void delete(Teacher teacher);
	 public void update(Teacher teacher);
}
