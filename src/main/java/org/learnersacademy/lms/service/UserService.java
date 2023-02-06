package org.learnersacademy.lms.service;

import org.learnersacademy.lms.entities.User;

public interface UserService {
	void add(User user);
	void delete(User user);
	//void changePassword(User user,String newPassword);
	User getUser(String userName,String password);
	int updatePassword(String uName, String oldPwd, String newPwd );
	public int findUserByUserName(String userName);
	//boolean validateUser(String userName,String password);

}
