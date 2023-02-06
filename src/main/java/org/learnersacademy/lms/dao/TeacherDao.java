package org.learnersacademy.lms.dao;

import java.util.List;

import org.learnersacademy.lms.entities.Teacher;

public interface TeacherDao {
	public	void insert(Teacher teacher);
	 public	List<Teacher> getAll();
	 public Teacher getTeacher(int teachId);
	 public void delete(Teacher teacher);
	 public void update(Teacher teacher);

}
