import java.sql.Connection;
import java.sql.SQLException;

import br.com.ProjectAP.conexao.Connect;

public class testeCon {

	public static void main(String[] args) {
		
		new Connect();
		Connection connection = Connect.getConnection();
		System.out.println("Conexão aberta!");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
