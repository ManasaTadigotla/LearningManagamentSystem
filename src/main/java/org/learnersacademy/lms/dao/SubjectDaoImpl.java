package org.learnersacademy.lms.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.config.HibConfig;
//import org.learnersacademy.config.HibConfig.Status;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl.Act;
import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;



public class SubjectDaoImpl implements SubjectDao{
	
	public enum Status
	{	
		CONSTAINTDUPLICATE,
		UNHANDLEDEXCP,
		SUCCESS

	}
	Status subjectUpdateStatus=null;
	public void performTransaction(Subject subject,Act task) 
	{
		
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			if(task.equals(Act.delete))
			{
			session.delete(subject);
			}
			else if(task.equals(Act.insert))
			{
				session.save(subject);
				
			}
			else if(task.equals(Act.update))
			{
				
				session.update(subject);
				//sessionFactory.getCurrentSession().update(subject);
			}
			
			tx.commit();
			subjectUpdateStatus=Status.SUCCESS;
			session.clear();
			session.close();
		}			
		catch(ConstraintViolationException ex)
		{
			
			//subjectUpdateStatus = Status.CONSTAINTDUPLICATE;
			tx.rollback();			
			subjectUpdateStatus=Status.CONSTAINTDUPLICATE;	
			//tx.rollback();
		}			
		catch( NonUniqueObjectException e) {
			tx.rollback();			
			e.printStackTrace();
			
		}
		catch (Exception e) {						
			tx.rollback();
			subjectUpdateStatus=Status.UNHANDLEDEXCP;
			e.printStackTrace();
			
		}
		finally
		{
			if(session.isOpen())
			{
				session.close();
			}
			
		}
		
	}

	@Override
	public void insert(Subject subject) {
		performTransaction(subject, Act.insert);
		
	}

	@Override
	public List<Subject> getAll() {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Query<Subject> query=session.createQuery("select s from org.learnersacademy.lms.entities.Subject s",Subject.class);
		List<Subject> subjects=query.list();
		session.close();
		return subjects;
		//session.close();
	}

	@Override
	public Subject getSubject(int sId) {
	SessionFactory sessionFactory=HibConfig.getSessionFactory();
	Session session=sessionFactory.openSession();
	TypedQuery<Subject> query=session.createQuery("select s from org.learnersacademy.lms.entities.Subject s where s.sId="+sId,Subject.class);
	Subject sub=query.getSingleResult();
	session.close();
	return sub;	
	
	}
	
	@Override
	public void delete(Subject subject) {
		performTransaction(subject, Act.delete);
		
	}

	@Override
	public int update(Subject subject) {
		performTransaction(subject, Act.update);
		if(subjectUpdateStatus==Status.CONSTAINTDUPLICATE)
			return -1;
		else if (subjectUpdateStatus==Status.UNHANDLEDEXCP)
			return -2;
			else if(subjectUpdateStatus==Status.SUCCESS)
				return 1;
			else
				return 0;
		
			
		
	}

}
