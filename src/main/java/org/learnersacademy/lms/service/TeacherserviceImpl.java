package org.learnersacademy.lms.service;

import java.util.List;

import org.learnersacademy.lms.dao.TeacherDaoImpl;
import org.learnersacademy.lms.dao.TeacherDao;
import org.learnersacademy.lms.entities.Teacher;

public class TeacherserviceImpl implements TeacherService {

	@Override
	public void insert(Teacher teacher) {
		TeacherDaoImpl teacherdao=new TeacherDaoImpl();
		teacherdao.insert(teacher);
			
	}

	@Override
	public List<Teacher> getAll() {
		TeacherDaoImpl teacherdao=new TeacherDaoImpl();
		return teacherdao.getAll();
	}

	@Override
	public Teacher getTeacher(int teachId) {
		TeacherDaoImpl teacherdao=new TeacherDaoImpl();
	  return teacherdao.getTeacher(teachId);

	}

	@Override
	public void delete(Teacher teacher) {
		TeacherDaoImpl teacherdao=new TeacherDaoImpl();
		teacherdao.delete(teacher);		
	}

	@Override
	public void update(Teacher teacher) {
		TeacherDaoImpl teacherdao=new TeacherDaoImpl();
		teacherdao.update(teacher);

		
	}

}
