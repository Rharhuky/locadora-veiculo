package com.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DAO {


	protected static Connection connection;
	private static String URL = "jdbc:postgresql://localhost:5432/locadora-veiculo";
	private static String USER = "postgres";
	private static String password = "pst21";


	private DAO(Class classe) {
		
	}
	
	public DAO(String u){
		getInstance();
	}
	
	
	protected DAO getInstance() {

		try {
			if(connection == null) {
				connection = DriverManager.getConnection(URL, USER, password);
				connection.setAutoCommit(false);
			}
				return this;
		}			
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Connection error " + e.getMessage());
		}


	}

	protected void salvar(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.execute();
		connection.commit();
		System.out.println("Save with Sucess !");
		
		
	}
	

}
