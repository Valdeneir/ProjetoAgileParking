package br.com.ProjectAP.controller;



import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;


@ManagedBean
public class ClienteBean {

	private String placa;
	
	Cliente cliente = new Cliente();
	Dao dao = new Dao();
	
	
	public void cadastrar() throws ClassNotFoundException, SQLException{
		
		dao.insertCliente(cliente);
		System.out.println(cliente.toString());
		
		
	}
	
	public void verificarLogin() throws ClassNotFoundException, SQLException {
		
		dao.verifica(cliente.getUsername(), cliente.getSenha());
		
		if (getCliente() != null) {
			
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("login Realizado!!"));
      
        
		System.out.println("aehhhhh");

		
	} else {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("login não Realizado!" ));

		System.out.println("deu merda");
			

		
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
}
