package br.com.ProjectAP.controller;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Estacionamento;

@ManagedBean 
public class EstacionamentoBean {

	Estacionamento est = new Estacionamento();
	Dao dao = new Dao();
	
public void cadEstacionamento() throws ClassNotFoundException, SQLException{
		
		dao.insertEst(est);
		
		if (getEst() != null) {
			
	            FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage("Cadastro Realizado com sucesso!!"));
	      
	        
			System.out.println("aehhhhh");

			
		} else {

	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro não Realizado", "'" ));

			System.out.println("deu merda");
				

			
		}
		
		System.out.println(est.toString());
		
		
	}

public Estacionamento getEst() {
	return est;
}

public void setEst(Estacionamento est) {
	this.est = est;
}
	



}
