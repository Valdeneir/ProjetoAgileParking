package br.com.ProjectAP.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.ProjectAP.conexao.Connect;
import br.com.ProjectAP.model.Cliente;
import br.com.ProjectAP.model.Estacionamento;

public class Dao {
	
	
	
	public Dao(){
		
	//	       this.connection = new ConnectionFactory().getConnection();
		    
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
	 
	 public void insertEst(Estacionamento est) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into estacionamentos(cnpj, nomeEstacionamento, local, telefone, valorDaVaga) values(?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, est.getCnpj());
				preparedStatement.setString(2, est.getNomeEstacionamento());
				preparedStatement.setString(3, est.getLocal());
				preparedStatement.setString(4, est.getTelefone());
				preparedStatement.setDouble(5, est.getValorDaVaga());
				preparedStatement.execute();
				preparedStatement.close();
					
				
			}
	 
	 public boolean verifica(String user, String sen){
		 
		 String sql =  "SELECT * FROM cliente WHERE username = user AND senha = sen";

		 if (sql.equals(null)) {
			
			 
			 return true;
			 
		}else{

		return false;	
		
		}
				 
	 
	 }
	}
	

