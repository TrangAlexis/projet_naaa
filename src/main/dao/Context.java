package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {
	//get Drivers
		static{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	// link PatientDao DAO to my context
		private static ClientDao clientDao = new ClientDaoImpl();
		public static ClientDao getClientDao() {
			return clientDao;
		}
		
		private static ExercicesDao exercicesDao = new ExercicesDaoImpl();
		public static ExercicesDao getExercicesDao() {
			return exercicesDao;
		}
		
		private static ProgrammesDao programmesDao = new ProgrammesDaoImpl();
		public static ProgrammesDao getProgrammesDao() {
			return programmesDao;
		}
		
		private static SuccesDao succesDao = new SuccesDaoImpl();
		public static SuccesDao getSuccesDao() {
			return succesDao;
		}

		
	//create a singleton of my context	
		private static Context singleton = null;
		public static Context getContext() {
			if (singleton==null) {
				singleton = new Context();
			}
			return singleton;
		}

	//create a connection to my sql server using the constructor
		private static Connection connection;
		private Context() {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_naaa","root","root123@");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//getter for my connection
		public Connection getConnection() {
			return connection;
		}
		//closes the connection
		private void close() {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//closes the connection and deletes the Context
		public static void destroy() {
			if(singleton!=null) {
				singleton.close();
				singleton=null;
			}
		}
		
}
