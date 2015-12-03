package br.com.ProjectAP.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
  public static Connection getConnection() {
     
	  try {
		  
		  DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 

	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost/projectap","root","wendell15");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
       
    }
		
	}


