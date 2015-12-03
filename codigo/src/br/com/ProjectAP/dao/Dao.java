package br.com.ProjectAP.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjectAP.conexao.Connect;
import br.com.ProjectAP.model.Cliente;
import br.com.ProjectAP.model.Estacionamento;
import br.com.ProjectAP.model.Reserva;

public class Dao {
		
	public Dao(){
				    
	}
		
	public void insertCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into cliente(nome, cpf, placa, username, senha) values(?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				
				preparedStatement.setString(1, cliente.getNome());
				preparedStatement.setString(2, cliente.getCpf());
				preparedStatement.setString(3, cliente.getPlaca());
				preparedStatement.setString(4, cliente.getUsername());
				preparedStatement.setString(5, cliente.getSenha());
				preparedStatement.execute();
				preparedStatement.close();
				
				
			}
	 
	public void registrarReserva(Reserva res) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into reserva(cnpj, tipoReserva, nomeUsu, email, placa, data) values(?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, res.getCnpj());
				preparedStatement.setString(2, res.getTipoReserva());
				preparedStatement.setString(3, res.getNomeUsu());
				preparedStatement.setString(4, res.getEmail());
				preparedStatement.setString(5, res.getPlaca());
				preparedStatement.setString(6, res.getData());
				preparedStatement.execute();
				preparedStatement.close();
				
				
			}
	 
	public void insertEst(Estacionamento est) throws ClassNotFoundException, SQLException {
			
			
		System.out.println("aqui 2");
			String sql = "insert into estacionamento(cnpj, nomeEstacionamento, cidade, rua, numero, complemento, telefone, valorVaga, latitude, longitude) values(?,?,?,?,?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, est.getCnpj());
				preparedStatement.setString(2, est.getNomeEstacionamento());
				preparedStatement.setString(3, est.getCidade());
				preparedStatement.setString(4, est.getRua());
				preparedStatement.setInt(5, est.getNumero());
				preparedStatement.setString(6, est.getComplemento());
				preparedStatement.setString(7, est.getTelefone());
				preparedStatement.setDouble(8, est.getValorVaga());
				preparedStatement.setFloat(9, est.getLatitude());
				preparedStatement.setFloat(10, est.getLongitude());
				preparedStatement.execute();
				preparedStatement.close();
					
				
			}

	public boolean buscaEstacionamentoC(String cnpjR) throws SQLException{
		 
		 String sql =  "SELECT * FROM estacionamento";
		 
			PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				  String cnpj = rs.getString("cnpj");

				  if (cnpjR.equals(cnpj)) {

						return true;
						 			
					}}
			return false;

				}
			
	public List<Estacionamento> buscaEstacionamento() throws SQLException{
				 
			ArrayList<Estacionamento> est = new ArrayList<Estacionamento>();
			String sql =  "SELECT * FROM estacionamento";
				 
					PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

					
					ResultSet rs = pst.executeQuery();
					

					while (rs.next()) {
						
						Estacionamento estacionamento = new Estacionamento();
						 estacionamento.setId( rs.getInt("id"));
						 estacionamento.setCnpj( rs.getString("cnpj"));
						 estacionamento.setNomeEstacionamento( rs.getString("nomeEstacionamento"));
						 estacionamento.setCidade(rs.getString("cidade"));
						 estacionamento.setRua(rs.getString("rua"));
						 estacionamento.setNumero(rs.getInt("numero"));
						 estacionamento.setComplemento(rs.getString("complemento"));
						 estacionamento.setTelefone(rs.getString("telefone"));
						 estacionamento.setValorVaga(rs.getDouble("valorVaga"));
						 estacionamento.setLatitude(rs.getFloat("latitude"));
						 estacionamento.setLongitude(rs.getFloat("longitude"));
						 est.add(estacionamento);
						 
						
					}
					return est;
			
	 }
	
	public List<Cliente> buscaCliente() throws SQLException{
		 
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		String sql =  "SELECT * FROM cliente";
			 
				PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

				
				ResultSet rs = pst.executeQuery();
				

				while (rs.next()) {
					
					Cliente cliente= new Cliente();
					 cliente.setId( rs.getLong("id"));
					 cliente.setCpf( rs.getString("cpf"));
					 cliente.setNome( rs.getString("nome"));
					 cliente.setPlaca(rs.getString("placa"));
					 cliente.setUsername(rs.getString("username"));
					 cliente.setSenha(rs.getString("senha"));
					 
					 cli.add(cliente);
					 
					
				}
				return cli;
		
 }
	
	public void alteraCliente(Cliente cliente) {
	     String sql = "update cliente set cpf=?, nome=?, placa=?, username=?," +
	             "senha=? where id=?";
	     try {
	    	 
	    	 
	    	 PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				
	    	 	preparedStatement.setString(1, cliente.getCpf());
				preparedStatement.setString(2, cliente.getNome());
				preparedStatement.setString(3, cliente.getPlaca());
				preparedStatement.setString(4, cliente.getUsername());
				preparedStatement.setString(5, cliente.getSenha());
				preparedStatement.setLong(6, cliente.getId());
				preparedStatement.execute();
				preparedStatement.close();
	    	
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void removeCli(Cliente cliente) {
		 try {
	         PreparedStatement stmt = Connect.getConnection()
	                 .prepareStatement("delete from cliente where id=?");
	         stmt.setLong(1, cliente.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public double buscaValor(String cnpjR) throws SQLException{
		System.out.println("chegou aqui" + cnpjR );

		 String sql =  "SELECT * FROM estacionamento";
		 
			PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				  String cnpj = rs.getString("cnpj");
				  double valorV = rs.getDouble("valorVaga");
				  
					System.out.println("chegou aqui" + cnpj + valorV );

				  if (cnpj.equals(cnpjR)) {

						return valorV;
						 			
					}

				}
			return 0;
					
			
	 }
	
	public boolean verificacpf(String cpf) throws SQLException{
		 
		 String sql =  "SELECT * FROM cliente";
		 
		 PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				  String c = rs.getString("cpf");

				  if (cpf.equals(c)) {

						return true;
						 			
					}}
		return false;	
		
		}
	
	public boolean verifica(String user, String sen) throws SQLException{
		 
		 String sql =  "SELECT * FROM cliente";

		 System.out.println(user + sen);
		 
		 
		 PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				  String username = rs.getString("username");
				  String senha = rs.getString("senha");

				  if (username.equals(user) && senha.equals(sen)) {

						return true;
						 			
					}}
		return false;	
		
		}
		
	public boolean verificaUSU(String tipo, String user, String sen) throws SQLException{
		 
		 System.out.println(tipo+ user + sen);

		 System.out.println(user + sen);
		 
			

				
			
		 
			if(tipo.equals("Funcionario")){
				
				String sql =  "SELECT * FROM funcionario";
				
					 PreparedStatement pst = Connect.getConnection().prepareStatement(sql);
						ResultSet rs = pst.executeQuery();

					
				while (rs.next()) {
					  String username = rs.getString("username");
					  String senha = rs.getString("senha");

					  if (username.equals(user) && senha.equals(sen)) {

							return true;
							 			
						}}
					
				
			}
			
			if(tipo.equals("Cliente")){
				String sql =  "SELECT * FROM cliente";
				 PreparedStatement pst = Connect.getConnection().prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

						
			while (rs.next()) {
				  String username = rs.getString("username");
				  String senha = rs.getString("senha");

				  if (username.equals(user) && senha.equals(sen)) {

						return true;
						 			
					}}
			
			}
	
		return false;
			 }

	public List<Reserva> buscaReserva() throws SQLException{
		 
		ArrayList<Reserva> res = new ArrayList<Reserva>();
		String sql =  "SELECT * FROM reserva";
			 
				PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

				
				ResultSet rs = pst.executeQuery();
				

				while (rs.next()) {
					
					Reserva reserva= new Reserva();
					 reserva.setId( rs.getInt("id"));
					 reserva.setCnpj( rs.getString("cnpj"));
					 reserva.setEmail( rs.getString("email"));
					 reserva.setNomeUsu(rs.getString("nomeUsu"));
					 reserva.setPlaca(rs.getString("placa"));
					 reserva.setTipoReserva(rs.getString("tipoReserva"));
					 reserva.setData(rs.getString("data"));

					
					 res.add(reserva);
					 				
				}
				return res;
		
 }

}
	
	

