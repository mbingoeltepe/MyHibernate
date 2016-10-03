package com.logging;


import com.logging.dao.DAOFactory;
import com.logging.dao.interfaces.IUserDAO;
import com.logging.entity.User;

public class App {

	//private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {

		IUserDAO userDAO = null;
		DAOFactory factory = null;


		factory = DAOFactory.instance(DAOFactory.HIBERNATE);
		userDAO = factory.getUserDAO();

		User user = new User();
		user.setuserName("Murat");
		user.setuserPassword("123");
		
		userDAO.insertUser(user);

	}
}