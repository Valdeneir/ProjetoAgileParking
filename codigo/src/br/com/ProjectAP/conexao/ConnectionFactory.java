package br.com.ProjectAP.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {

			Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/projectap","root","");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
