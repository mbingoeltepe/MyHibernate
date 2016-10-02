package com.logging.connection;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author berard
 * 
 *         Baut eine JDBC-Verbindung zur Datenbank.
 */
public class HibernateUtil{

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;

	public HibernateUtil() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot load driver: " + DRIVER, e);
		}
	}

	/**
	 * Versuche, die aktuelle Verbindung zu schließen und eine neue mit den
	 * gleichen Parametern erstellen.
	 *
	 * @return der neu eingerichtete Verbindung
	 * @throws SQLException
	 *             wenn eine Datenbank-Zugriffsfehler auftritt
	 * @see #disconnect()
	 * @see #connect()
	 */
	public static SessionFactory getConnection() throws SQLException {
		try {
			disconnect();
		} catch (Exception e) {
		}
		connect();
		return sessionFactory;
	}

	/**
	 * Baut eine neue Datenbankverbindung.
	 *
	 * @throws SQLException
	 *             wenn eine Datenbank-Zugriffsfehler auftritt
	 */
	private static void connect() throws SQLException {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			logger.info("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			logger.info("Hibernate serviceRegistry created");

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			logger.info("Connecting to the database");
		} catch (Throwable ex) {
			logger.error("Initial SessionFactory creation failed." + ex);
			logger.info("Connection failure");
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Wenn eine Datenbankvebinddung existiert, tut sie schlissen.
	 *
	 * @throws SQLException
	 *             wenn eine Datenbank-Zugriffsfehler auftritt
	 */
	public static void disconnect() throws SQLException {
		if (sessionFactory != null) {
			logger.info("Disconnect from the Database");
			sessionFactory.close();
			sessionFactory = null;
		}
	}

}