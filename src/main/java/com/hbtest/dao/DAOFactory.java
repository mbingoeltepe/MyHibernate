package com.hbtest.dao;

import org.apache.log4j.Logger;

import com.hbtest.dao.interfaces.IUserDAO;




public abstract class DAOFactory {
    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */

	private static Logger logger = Logger.getLogger(DAOFactory.class);
	
	@SuppressWarnings("rawtypes")
	public static final Class HIBERNATE = DAOHibernateFactory.class;
	
	/**
	 * Factory method for instantiation of concrete factories.
	 */
	
	@SuppressWarnings("rawtypes")
	public static DAOFactory instance(Class factory) {
		try {
			return (DAOFactory)factory.newInstance();
		} catch (Exception ex) {
			logger.error("Couldn't create DAOFactory: " + factory);
			throw new RuntimeException();
		}
	}
	
	// To do DAO Interfaces
	public abstract IUserDAO getUserDAO();
}
