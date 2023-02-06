package org.learnersacademy.lms.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl.Act;
import org.learnersacademy.lms.dao.SubjectDaoImpl.Status;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Student;

public class StudentDaoImpl implements StudentDao{

	Status studentUpdateStatus=null;
	public void performTransaction(Student student,Act task) throws ConstraintViolationException
	{
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			if(task.equals(Act.delete))
			{
			session.delete(student);
			}
			else if(task.equals(Act.insert))
			{
				session.save(student);
			}
			else if(task.equals(Act.update))
			{
				session.update(student);
			}
			tx.commit();
			session.clear();
			session.close();
			//tx.commit();
		}
		catch (ConstraintViolationException e) {
			tx.rollback();
			if(session.isOpen())
			{
				session.clear();
				session.close();
			}
			studentUpdateStatus=Status.CONSTAINTDUPLICATE;	
			
			//e.printStackTrace();
		}
	}

	@Override
	public int insert(Student student) throws ConstraintViolationException {
	 performTransaction(student, Act.insert);
	 if(studentUpdateStatus==Status.CONSTAINTDUPLICATE)
	 {
		 return -1;
	 }
	 else
	 {
		 return 0;
	 }
		
	}

	@Override
	public List<Student> getAll() {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		//TypedQuery<Student> query=session.createQuery("select s.studentId,s.firstName from org.learnersacademy.lms.entities.Student s");
		Query<Student> query=session.createQuery("select s from org.learnersacademy.lms.entities.Student s");
		List<Student> stu=query.list();
		session.close();
		return stu;
	}

	@Override
	public void update(Student student) {
		performTransaction(student, Act.update);
		
	}

	@Override
	public void delete(Student student) {
		performTransaction(student, Act.delete);
		
	}

	@Override
	public Student findByStudentId(int studentId) {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Student> query=session.createQuery("select s from org.learnersacademy.lms.entities.Student s where s.studentId="+studentId,Student.class);
		//query.setParameter(1, cId);
		Student stu=query.getSingleResult();
		//session.close();
		return stu;
		
	}

}
