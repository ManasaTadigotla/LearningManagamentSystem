package org.learnersacademy.lms.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learnersacademy.config.HibConfig;
import org.learnersacademy.lms.dao.AcademicClassDaoImpl.Act;
import org.learnersacademy.lms.entities.Teacher;
import org.learnersacademy.lms.entities.User;

public class UserDaoImpl implements UserDao {

	public void performTransaction(User user, Act task) {
		SessionFactory sessionFactory = HibConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (task.equals(Act.delete)) {
				session.delete(user);
			} else if (task.equals(Act.insert)) {
				session.save(user);
			} else if (task.equals(Act.update)) {
				session.update(user);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void add(User user) {
		performTransaction(user, Act.insert);

	}

	@Override
	public void delete(User user) {
		performTransaction(user, Act.delete);

	}

	@Override
	public User getUser(String userName, String password) {
		SessionFactory sessionFactory = HibConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery(
				"select u from org.learnersacademy.lms.entities.User u where u.userName=?1 and u.password=?2",
				User.class);
		query.setParameter(1, userName);
		query.setParameter(2, password);
		try {
			User user = query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public int updatePassword(String uName, String oldPwd, String newPwd) {

		SessionFactory sessionFactory = HibConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User user = getUser(uName, oldPwd);
			if(user!=null)
			{
			user.setPassword(newPwd);
			performTransaction(user, Act.update);
			// session.update(user);
			return 1;
			// return query.executeUpdate();
			// return 1;
			}
			else
				return 2;
		} catch (NoResultException e) {
			return 0;
		}

	}

	@Override
	public int findUserByUserName(String userName) {
		SessionFactory sessionFactory = HibConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		TypedQuery<User> query = session.createQuery("select u from org.learnersacademy.lms.entities.User u where u.userName=?1", User.class);
		query.setParameter(1, userName);
		try {
			User user = query.getSingleResult();			
				return 1;
			} catch (NoResultException e) {
			e.printStackTrace();
			return 0;
		}
		catch (Exception e) {
			return -1;
		}
	}

}
