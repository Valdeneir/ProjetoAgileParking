package br.com.ProjectAP.controller;



import javax.faces.bean.ManagedBean;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;


@ManagedBean
public class ClienteBean {

	Cliente cliente = new Cliente();
	
	public void cadastrar(){
		
		System.out.println(cliente.toString());
		
		Dao.getInstance().salvarObjeto(cliente);
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
