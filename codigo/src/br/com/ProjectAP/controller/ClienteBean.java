package br.com.ProjectAP.controller;




import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;
import br.com.ProjectAP.model.Reserva;


@ManagedBean
public class ClienteBean {

	
	private String placa;
	
	private double resultValor;
	private String username;
	private String senha;
	private String selecao;
	Cliente cliente = new Cliente();
	Reserva reserva = new Reserva();
	Dao dao = new Dao();
	
	
	
	
	public void realizarReserva() throws ClassNotFoundException, SQLException{
		System.out.println(reserva.getCnpjR());

		dao.registrarReserva(reserva);
		if (getReserva() != null) {
						
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Reserva Realizada com sucesso!!"));
      
		System.out.println("aehhhhh");

		
	} else
	if(getReserva() == null){

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Reserva não Realizada!!", "ERRO NO SISTEMA" ));

		System.out.println("deu merda");
		
	}
		
	}
	
	
	public String alterar(Cliente cliente) throws ClassNotFoundException, SQLException{
		System.out.println(reserva.getCnpjR());

		this.cliente = cliente;
		
		return "cadastroCliente.xhtml";
		
		
	}
	
	public void remover(Cliente cliente) throws ClassNotFoundException, SQLException{
		System.out.println(cliente.getId());
		dao.removeCli(cliente);
		
		if (cliente.getId() != 0) {
						
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente Removido com sucesso!!"));
      
            System.out.println("aehhhhh");

		
	} else
	if(cliente.getId() == 0){

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente não Removido!!", "ERRO NO SISTEMA" ));

		System.out.println("deu merda");
		
	}
		
	}
	
	
	
	public void cadastrar() throws ClassNotFoundException, SQLException{
		
		System.out.println(cliente.getId());
		System.out.println(dao.verificacpf(cliente.getCpf()));
		
		if(cliente.getId()== 0 ){
			
			if(dao.verificacpf(cliente.getCpf())== false){
				
				dao.insertCliente(cliente);
				FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage("Cliente Cadastrado com sucesso!!"));
				
			}
			
			
				
      
		}
		if(cliente.getId() > 0){
			
			dao.alteraCliente(cliente);
			FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage("Cliente Alterado com sucesso!!"));
	      
			System.out.println("aehhhhh");
	
		}
		
	}
	
	public String verificaFun() throws SQLException{
		
		dao.verificaUSU(getSelecao(), getUsername(), getSenha());
		
		return "manterCliente.xhtml";
		
	}
	
	public void calcularValor() throws SQLException{
		System.out.println(reserva.getCnpjR()+ "chegou aqui linha 61");

	double result= dao.buscaValor(reserva.getCnpjR());

	System.out.println(reserva.getCnpjR()+ result);

		if (reserva.getTipoReserva() == "Dia") {
		
		resultValor = result;
			
		
	} else 
		if(reserva.getTipoReserva() == "Mensal"){
		
			resultValor = result * 25;
		
			
			
	}else 
		if (reserva.getTipoReserva() == "Anual"){
		}
		
		
	   resultValor= result * 300;

		
		
	}
	
	public void verificarCidade() throws ClassNotFoundException, SQLException {
		
		boolean result = dao.buscaEstacionamentoC(reserva.getCnpjR());
		System.out.println( result);
		System.out.println( "voltou pra ca");


		if (result == true) {
		
			FacesContext.getCurrentInstance().addMessage(null,
	                 new FacesMessage("Estacionamento Encontrado!!"));
			
		System.out.println("Encontrou cnpj");

		
	} else if (result == false) {

		 FacesContext.getCurrentInstance().addMessage(null,
                 new FacesMessage("Estacionamento não Encontrado!!"));
	}
		
	}
	
	public void verificarCpf() throws ClassNotFoundException, SQLException {
		
		if(dao.verificacpf(cliente.getCpf())== true){
			
			FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("CPF Já cadastrado!!"));
			
		}
	}
	
	public List<Cliente> getbuscaCliente()throws ClassNotFoundException, SQLException{
		
		List<Cliente> cliente = dao.buscaCliente();
		

		return cliente;
	}
		
	public void verificarLogin() throws ClassNotFoundException, SQLException {
		
		System.out.println(getUsername() + getSenha());
		
		boolean dados =  dao.verifica(getUsername(),getSenha());
		System.out.println(dados);

		if (dados == true) {
			
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Login realizado como " + getSelecao()));
      
		
	} else {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("login não Realizado!" ));
		
	}
		
}
		
	public void search() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No results found with ", "'" + placa + "'"));
	    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getPlaca() {
        return placa;
    }
 
    public void setPlaca(String placa) {
        this.placa = placa;
    }

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public double getResultValor() {
		return resultValor;
	}

	public void setResultValor(double resultValor) {
		this.resultValor = resultValor;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}
    
	
    
    
}
