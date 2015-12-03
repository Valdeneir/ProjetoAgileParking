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
	        System.out.println("chegou aqui 0");

	        
	        System.out.println(getEst().getLatitude() + est.getLongitude());
	        
	        	
	      List<Estacionamento> estacionamento;
		try {
			estacionamento = dao.buscaEstacionamento();
		
	      for (Estacionamento dados : estacionamento) {
	    	  
		        System.out.println(dados.getLatitude() +" " + dados.getLongitude());
		        System.out.println("chegou aqui 1");

	 	      
	        LatLng cord = new LatLng( dados.getLatitude() ,dados.getLongitude() );
	      	     
	        simpleModel.addOverlay(new Marker(cord,dados.getNomeEstacionamento()+ "\n" + "Telefone:  "  + dados.getTelefone()));

	      } 
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	        }
	   
	    public MapModel getSimpleModel() {
	        return simpleModel;
	    }


}
