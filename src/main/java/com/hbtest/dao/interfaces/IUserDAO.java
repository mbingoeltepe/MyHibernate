package com.hbtest.dao.interfaces;

import com.hbtest.dao.GenericDAO;
import com.hbtest.entity.User;



public interface IUserDAO extends GenericDAO<User, Long> {
	
	public void insertUser(User user);
	
	public void deleteUser(User user);

}
