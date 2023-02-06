package org.learnersacademy.lms.service;

import org.learnersacademy.lms.dao.UserDao;
import org.learnersacademy.lms.dao.UserDaoImpl;
import org.learnersacademy.lms.entities.User;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		UserDao userDao=new UserDaoImpl();
		userDao.add(user);		
	}

	@Override
	public void delete(User user) {
		UserDao userDao=new UserDaoImpl();
		userDao.delete(user);		
	}

	@Override
	public User getUser(String userName, String password) {
		UserDao userDao=new UserDaoImpl();
		return userDao.getUser(userName,password);
	}

	@Override
	public int updatePassword(String uName, String oldPwd, String newPwd) {
		UserDao userDao=new UserDaoImpl();
		return userDao.updatePassword(uName, oldPwd, newPwd);
	}

	@Override
	public int findUserByUserName(String userName) {
		UserDao userDao=new UserDaoImpl();
		return userDao.findUserByUserName(userName);
	}

}
