package com.logging.dao.impl;

import com.logging.dao.DAOFactory;
import com.logging.dao.GenericHibernateDAO;
import com.logging.dao.interfaces.IUserDAO;
import com.logging.entity.User;

public class UserHibernateDAO extends GenericHibernateDAO<User, Long> implements IUserDAO {
	private IUserDAO userDAO = null;
	private DAOFactory factory = null;

	public void insertUser(User user) {
		factory = DAOFactory.instance(DAOFactory.HIBERNATE);
		userDAO = factory.getUserDAO();
		userDAO.makePersistent(user);

	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
