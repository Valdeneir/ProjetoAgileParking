package br.com.ProjectAP.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Estacionamento;

@ManagedBean 
public class EstacionamentoBean {

	Estacionamento est = new Estacionamento();
	Dao dao = new Dao();
	private MapModel simpleModel;
	
	public void cadEstacionamento() throws ClassNotFoundException, SQLException{
		
		dao.insertEst(est);
		
		if (getEst() != null) {
			
	            FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage("Cadastro Realizado com sucesso!!" + est.getNomeEstacionamento()));
	      
	        
			System.out.println("aehhhhh");

			
		} else {

	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro não Realizado", "'" ));

			System.out.println("deu merda");
				

			
		}
		
		System.out.println(est.toString());
		
		
	}

	public List<Estacionamento> getbuscaEstacionamento()throws ClassNotFoundException, SQLException{
		
		List<Estacionamento> estacionamento = dao.buscaEstacionamento();
		
		return estacionamento;
	}
		
	public Estacionamento getEst() {
	return est;
}
	
	

	public void setEst(Estacionamento est) {
	this.est = est;
}
	  
	    @PostConstruct
	    public void init() {
	        simpleModel = new DefaultMapModel();
	         	
	      	        
	        
	        //Shared coordinates
	        LatLng coord1 = new LatLng(-8.0610225, -34.8792507);
	        LatLng coord2 = new LatLng(-8.039736, -34.8732322);
	        LatLng coord3 = new LatLng(-8.0685763, -34.9092546);
	        LatLng coord4 = new LatLng(-8.0647182, -34.9372104);
	        LatLng coord5 = new LatLng(-8.0634322, -34.9341639);
	        LatLng coord6 = new LatLng(-8.0529223, -34.8964456);
	        LatLng coord7 = new LatLng(-7.934422,-34.8687212);
	        
	          
	        //Basic marker
	        simpleModel.addOverlay(new Marker(coord1, "Park agil"));
	        simpleModel.addOverlay(new Marker(coord2, "Faculdade"));
	        simpleModel.addOverlay(new Marker(coord3, "Faculdade Nova Roma"));
	        simpleModel.addOverlay(new Marker(coord4, "Habibs"));
	        simpleModel.addOverlay(new Marker(coord5, "Faculdade Estacio"));
	        simpleModel.addOverlay(new Marker(coord6, "Banco do Brasil"));
	        simpleModel.addOverlay(new Marker(coord7, "Shoping Paulista"));


	    }
	  
	    public MapModel getSimpleModel() {
	        return simpleModel;
	    }


}
