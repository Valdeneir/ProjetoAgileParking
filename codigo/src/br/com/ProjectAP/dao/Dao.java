package br.com.ProjectAP.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ProjectAP.conexao.Connect;
import br.com.ProjectAP.model.Cliente;
import br.com.ProjectAP.model.Estacionamento;
import br.com.ProjectAP.model.Reserva;

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
	 
	public void registrarReserva(Reserva res) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into reservas(cidade, tipoReserva, nomeUsu, email, placa, data) values(?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, res.getCidade() );
				preparedStatement.setString(2, res.getTipoReserva());
				preparedStatement.setString(3, res.getNomeUsu());
				preparedStatement.setString(4, res.getEmail());
				preparedStatement.setString(5, res.getPlaca());
				preparedStatement.setString(6, res.getData());
				preparedStatement.execute();
				preparedStatement.close();
				
				
			}
	 
	 public void insertEst(Estacionamento est) throws ClassNotFoundException, SQLException {
			
			
			String sql = "insert into estacionamentos(cnpj, nomeEstacionamento, cidade, rua, numero, complemento, telefone, valorDaVaga) values(?,?,?,?,?,?,?,?);";
			
				
				PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, est.getCnpj());
				preparedStatement.setString(2, est.getNomeEstacionamento());
				preparedStatement.setString(3, est.getCidade());
				preparedStatement.setString(4, est.getRua());
				preparedStatement.setInt(5, est.getNumero());
				preparedStatement.setString(6, est.getComplemento());
				preparedStatement.setString(7, est.getTelefone());
				preparedStatement.setDouble(8, est.getValorDaVaga());
				preparedStatement.execute();
				preparedStatement.close();
					
				
			}

	 public boolean buscaEstacionamentoC(String cid) throws SQLException{
		 
		 String sql =  "SELECT * FROM estacionamentos";
		 
			PreparedStatement pst = Connect.getConnection().prepareStatement(sql);

			System.out.println("chegou aqui" + cid );
			
			ResultSet rs = pst.executeQuery();

			
			
			while (rs.next()) {
				  String cidade = rs.getString("cidade");
					System.out.println("chegou aqui" + cidade );

				  if (cidade.equals(cid)) {

						return true;
						 			
					}

				}
			return false;
			
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
	

