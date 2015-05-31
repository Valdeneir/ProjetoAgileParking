package br.com.ProjectAP.controller;



import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;
//import br.com.ProjectAP.util.FacesUtil;


@ManagedBean(name="clienteBean")
public class ClienteBean {

	
	private String keyword; 	
	Cliente cliente = new Cliente();
	
	
	public void cadastrar(){
		

		System.out.println(cliente.toString());
		
		try {
			
			
		Dao.getInstance().salvarObjeto(cliente);
			
		//FacesUtil.addInfoMessage("Cadastro com Sucesso");
			
		} catch (Exception e) {
		System.out.println("erro aqui:  " + e);
		}
		
		limpar();
	}
	
	public void limpar(){
		
		cliente = new Cliente();
		
	}
	
	
	public void search() {
		
	//	Dao.getInstance().buscarPorPlaca( null, ClienteBean.this.getKeyword());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Não Cadastrado!! ", " Seleciona outra Opção"));
    }
	
	
	public void buscaData(){
		
		Date data = new Date();
		System.out.println(data.toString());
		
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	 public String getKeyword() {
	        return keyword;
	    }
	 
	 public void setKeyword(String keyword) {
	        this.keyword = keyword;
	    }
	 
	 
	
	    
}
