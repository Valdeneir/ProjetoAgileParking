package br.com.ProjectAP.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Cliente;

@ManagedBean 
@SessionScoped
public class AutencicacaoLogin {

	private Cliente cLogado;
	private String tipo;
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getcLogado() {
		if(cLogado == null){
			
			cLogado = new Cliente();
			
		}
		
		return cLogado;
	}

	public void setcLogado(Cliente cLogado) {
		this.cLogado = cLogado;
	}
	
	public void entrar(){
		
		try {
			
		Dao usuDAO = new Dao();
		
		System.out.println(tipo);

		
	boolean dados =	usuDAO.verificaUSU(tipo , cLogado.getUsername(), cLogado.getSenha());	
		
	System.out.println(dados);
	
		if (dados == true) {
			
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Login realizado como " + tipo + "---" + "Seja Bem Vindo: " +  cLogado.getUsername()));
      		
	} else {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("login não Realizado!" ));
		
	}
				
		System.out.println("Autenticado" + tipo + cLogado.getUsername() + cLogado.getSenha()  );
			
		} catch (Exception e) {
			
			System.out.println("erro" + e);
		
		}
		
	}
	
	
}
