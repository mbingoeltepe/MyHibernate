package com.logging.dao.interfaces;

import com.logging.dao.GenericDAO;
import com.logging.entity.User;



public interface IUserDAO extends GenericDAO<User, Long> {
	
	public void insertUser(User user);
	
	public void deleteUser(User user);

}
