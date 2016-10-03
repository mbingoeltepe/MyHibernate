package com.hbtest.dao.impl;

import com.hbtest.dao.DAOFactory;
import com.hbtest.dao.GenericHibernateDAO;
import com.hbtest.dao.interfaces.IUserDAO;
import com.hbtest.entity.User;

public class UserHibernateDAO extends GenericHibernateDAO<User, Long> implements IUserDAO {
	
	private DAOFactory factory = null;
	private IUserDAO userDAO = null;
	
	public void insertUser(User user) {
		factory = DAOFactory.instance(DAOFactory.HIBERNATE);
		userDAO = factory.getUserDAO();
		userDAO.makePersistent(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}



}
