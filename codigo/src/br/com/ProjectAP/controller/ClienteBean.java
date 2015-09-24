package br.com.ProjectAP.controller;




import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;
import br.com.ProjectAP.model.Reserva;


@ManagedBean
public class ClienteBean {

	
	private String placa;
	
	Cliente cliente = new Cliente();
	Reserva reserva = new Reserva();
	Dao dao = new Dao();
	
	public void realizarReserva() throws ClassNotFoundException, SQLException{
		System.out.println(reserva.getCidade());

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
	
	public void cadastrar() throws ClassNotFoundException, SQLException{
		
		dao.insertCliente(cliente);
		System.out.println(cliente.toString());
	
	}
	
	public void verificarCidade() throws ClassNotFoundException, SQLException {
		
		boolean result = dao.buscaEstacionamentoC(reserva.getCidade());
		System.out.println( result);

		if (result == true) {
		
		System.out.println("Encontrou cidade");

		
	} else {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não existe estacionamentos cadastrados na cidade escolhida" ));
		
	}
		
	}
	
	public void verificarLogin() throws ClassNotFoundException, SQLException {
		
		dao.verifica(cliente.getUsername(), cliente.getSenha());
		
		if (getCliente() != null) {
			
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("login Realizado!!"));
      
        
		System.out.println("aehhhhh");

		
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
    
	
    
    
}
