package com.hbtest.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hbtest.connection.HibernateUtil;
import com.hbtest.dao.impl.UserHibernateDAO;
import com.hbtest.dao.interfaces.IUserDAO;



public class DAOHibernateFactory extends DAOFactory {

	private static Logger logger = Logger.getLogger(DAOHibernateFactory.class);
	
	@SuppressWarnings({ "rawtypes" })
	private GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO  dao = (GenericHibernateDAO)daoClass.newInstance();
			dao.setSession(getCurrentSession());
			return dao;
		} catch (Exception ex) {
			logger.error("Can not instantiate DAO: " + daoClass, ex );
			throw new RuntimeException();
		}
	}
	// You could override this if you don't want HibernateUtil for lookup
	protected Session getCurrentSession() throws HibernateException, SQLException {
		return  HibernateUtil.getConnection().getCurrentSession();
	}
	
	// Add your DAO here
	@Override
	public IUserDAO getUserDAO() {
		return (IUserDAO)instantiateDAO(UserHibernateDAO.class);
	}

	
}
