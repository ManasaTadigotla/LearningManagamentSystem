package org.learnersacademy.lms.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl.Act;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.entities.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	public void performTransaction(Teacher teacher,Act task) 
	{
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			if(task.equals(Act.delete))
			{
			session.delete(teacher);
			}
			else if(task.equals(Act.insert))
			{
				session.save(teacher);
			}
			else if(task.equals(Act.update))
			{
				session.update(teacher);
			}
			//session.clear();
			//session.close();
			tx.commit();
			session.close();
		}
		catch (ConstraintViolationException ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			tx.rollback();
			if(session.isOpen())
			{
				//session.clear();
				session.close();
			}
			//tx.rollback();
			//e.printStackTrace();
		}
	}

	@Override
	public void insert(Teacher teacher) {
		performTransaction(teacher, Act.insert);
		
	}

	@Override
	public List<Teacher> getAll() {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Teacher> query=session.createQuery("select t from org.learnersacademy.lms.entities.Teacher t",Teacher.class);
		List<Teacher> teachers=query.getResultList();
		session.close();
		return teachers;
	}

	@Override
	public void delete(Teacher teacher) {
		performTransaction(teacher, Act.delete);		
	}

	@Override
	public void update(Teacher teacher) {
		performTransaction(teacher, Act.update);
		
	}

	@Override
	public Teacher getTeacher(int teachId) {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Teacher> query=session.createQuery("select t from org.learnersacademy.lms.entities.Teacher t where tId="+teachId,Teacher.class);
		Teacher teacher=query.getSingleResult();
		session.close();
		return teacher;
	}

}
