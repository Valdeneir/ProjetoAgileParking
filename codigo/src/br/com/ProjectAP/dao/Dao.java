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
			
			
			String sql = "insert into cliente(cpf, nome, placaVeiculo, username, senha) values(?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, cliente.getCpf());
				preparedStatement.setString(2, cliente.getNome());
				preparedStatement.setString(3, cliente.getPlacaVeiculo());
				preparedStatement.setString(4, cliente.getUsername());
				preparedStatement.setString(5, cliente.getSenha());
				preparedStatement.execute();
				preparedStatement.close();
				
				
			}
	 
	public void registrarReserva(Reserva res) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into reservas(tipoReserva, nomeUsu, email, placa, data, cnpjR) values(?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, res.getTipoReserva());
				preparedStatement.setString(2, res.getNomeUsu());
				preparedStatement.setString(3, res.getEmail());
				preparedStatement.setString(4, res.getPlaca());
				preparedStatement.setString(5, res.getData());
				preparedStatement.setString(6, res.getCnpjR());

				preparedStatement.execute();
				preparedStatement.close();
				
				
			}
	 
	public void insertEst(Estacionamento est) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into estacionamentos(cnpj, nomeEstacionamento, cidade, rua, numero, complemento, telefone, valorDaVaga, latitude, longitude) values(?,?,?,?,?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, est.getCnpj());
				preparedStatement.setString(2, est.getNomeEstacionamento());
				preparedStatement.setString(3, est.getCidade());
				preparedStatement.setString(4, est.getRua());
				preparedStatement.setInt(5, est.getNumero());
				preparedStatement.setString(6, est.getComplemento());
				preparedStatement.setString(7, est.getTelefone());
				preparedStatement.setDouble(8, est.getValorDaVaga());
				preparedStatement.setFloat(9, est.getLatitude());
				preparedStatement.setFloat(10, est.getLongitude());
				preparedStatement.execute();
				preparedStatement.close();
					
				
			}

	public boolean buscaEstacionamentoC(String cnpjR) throws SQLException{
		 
		 String sql =  "SELECT * FROM estacionamentos";
		 
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
			String sql =  "SELECT * FROM estacionamentos";
				 
					PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

					
					ResultSet rs = pst.executeQuery();
					

					while (rs.next()) {
						
						Estacionamento estacionamento = new Estacionamento(); 
						 estacionamento.setCnpj( rs.getString("cnpj"));
						 estacionamento.setNomeEstacionamento( rs.getString("nomeEstacionamento"));
						 estacionamento.setCidade(rs.getString("cidade"));
						 estacionamento.setRua(rs.getString("rua"));
						 estacionamento.setNumero(rs.getInt("numero"));
						 estacionamento.setComplemento(rs.getString("complemento"));
						 estacionamento.setTelefone(rs.getString("telefone"));
						 estacionamento.setValorDaVaga(rs.getDouble("valorDaVaga"));
						 estacionamento.setLatitude(rs.getLong("latitude"));
						 estacionamento.setLongitude(rs.getLong("longitude"));
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
					 cliente.setPlacaVeiculo(rs.getString("placaVeiculo"));
					 cliente.setUsername(rs.getString("username"));
					 cliente.setSenha(rs.getString("senha"));
					 
					 cli.add(cliente);
					 
					
				}
				return cli;
		
 }
	
	public void alteraCliente(Cliente cliente) {
	     String sql = "update cliente set cpf=?, nome=?, placaVeiculo=?, username=?," +
	             "senha=? where id=?";
	     try {
	    	 
	    	 
	    	 PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				
	    	 	preparedStatement.setString(1, cliente.getCpf());
				preparedStatement.setString(2, cliente.getNome());
				preparedStatement.setString(3, cliente.getPlacaVeiculo());
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

		 String sql =  "SELECT * FROM estacionamentos";
		 
			PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				  String cnpj = rs.getString("cnpj");
				  double valorV = rs.getDouble("valorDaVaga");
				  
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
		 
		 
		 System.out.println(user + sen);
		 
			String sql1 =  "SELECT * FROM cliente";	

			String sql =  "SELECT * FROM funcionario";	
		 
			if(tipo.equals("funcionario")){
				
				if(tipo.equals("cliente")){
					 PreparedStatement pst = Connect.getConnection().prepareStatement(sql);
						ResultSet rs = pst.executeQuery();

					
				while (rs.next()) {
					  String username = rs.getString("username");
					  String senha = rs.getString("senha");

					  if (username.equals(user) && senha.equals(sen)) {

							return true;
							 			
						}}
					
				
			}
			
			if(tipo.equals("cliente")){
				 PreparedStatement pst = Connect.getConnection().prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();

				
			while (rs.next()) {
				  String username = rs.getString("username");
				  String senha = rs.getString("senha");

				  if (username.equals(user) && senha.equals(sen)) {

						return true;
						 			
					}}
			
			}
	
		}
						
			
		return false;
		
	
	 }
	


}
	
	

