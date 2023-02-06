package org.learnersacademy.lms.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.SubjectDaoImpl.Status;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Subject;

import com.mysql.cj.Query;

public class AcademicClassDaoImpl implements AcademicClassDao {
	enum Act{
		delete,
		insert,
		update
	}
	Status subjectUpdateStatus=null;
	public void performTransaction(AcademicClass studyClass,Act task)
	{
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			if(task.equals(Act.delete))
			{
			session.delete(studyClass);
			}
			else if(task.equals(Act.insert))
			{
				session.save(studyClass);
			}
			else if(task.equals(Act.update))
			{
				session.update(studyClass);
				//sessionFactory.getCurrentSession().update(studyClass);
			}
			tx.commit();
			subjectUpdateStatus=Status.SUCCESS;
			//session.clear();
			//session.close();
		}
		catch (ConstraintViolationException ex) {
			tx.rollback();			
			subjectUpdateStatus=Status.CONSTAINTDUPLICATE;
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
				session.clear();
				session.close();
			}
		}
	}

	@Override
	public int insert(AcademicClass studyClass) {
		performTransaction(studyClass, Act.insert);
		if(subjectUpdateStatus==Status.CONSTAINTDUPLICATE)
			return -1;
		else if(subjectUpdateStatus==Status.SUCCESS)
			return 1;
			else
			return -2;
		
		
	}

	@Override
	public List<AcademicClass> getAll() {
		
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		org.hibernate.Query<AcademicClass> query=session.createQuery("select a from org.learnersacademy.lms.entities.AcademicClass a");
		//TypedQuery<AcademicClass> query=session.createQuery("select a.cId,a.name from org.learnersacademy.entities.AcademicClass a",AcademicClass.class);
		List<AcademicClass> classes=query.list();
		return classes;
	}

	@Override
	public void delete(AcademicClass studyClass) {
		
		performTransaction(studyClass, Act.delete);
		/*
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.delete(studyClass);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		*/
		
	}

	@Override
	public void update(AcademicClass studyClass) {
		
		performTransaction(studyClass, Act.update);
		/*
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(studyClass);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		*/
		
	}

	/*
	@Override
	public void update(AcademicClass studClass, int cId) {
		
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(studClass);
	}
	*/
	
	public AcademicClass findByClassId(int cId)
	{
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session1=sessionFactory.openSession();
		TypedQuery<AcademicClass> query=session1.createQuery("select s from org.learnersacademy.lms.entities.AcademicClass s where s.cId="+cId,AcademicClass.class);
		//query.setParameter(1, cId);
		AcademicClass acadClass=query.getSingleResult();
		session1.clear();
		session1.close();
		return acadClass;
		
	}

	@Override
	public List<AcademicClass> getClassesDetails(int cId) {
		SessionFactory sessionFactory=HibConfig.getSessionFactory();
		Session session1=sessionFactory.openSession();
		TypedQuery<AcademicClass> query=session1.createQuery("select c.name from org.learnersacademy.lms.entities.AcademicClass c" ,AcademicClass.class);
		//query.setParameter(1, cId);
		List<AcademicClass> result=query.getResultList();
		
		return result;
	}

}
