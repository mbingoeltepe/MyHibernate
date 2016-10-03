package com.hbtest.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hbtest.dao.GenericDAO;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private static Logger logger = Logger.getLogger(DAOHibernateFactory.class);

	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	
	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null) {
			logger.info("Session has not been set on DAO before usage");
			throw new IllegalStateException();
		}
		return session;
	}



	public void makePersistent(T entity) {
		Transaction trans = getSession().getTransaction();
		trans.begin();
		getSession().saveOrUpdate(entity);
		trans.commit();
	}


}
