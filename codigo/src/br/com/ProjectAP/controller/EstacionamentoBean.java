package br.com.ProjectAP.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.ProjectAP.dao.Dao;
import br.com.ProjectAP.model.Estacionamento;
import br.com.ProjectAP.model.Reserva;

@ManagedBean 
public class EstacionamentoBean {

	Estacionamento est = new Estacionamento();
	Dao dao = new Dao();
	private MapModel simpleModel;
    private LineChartModel lineModel2;
    private int d;
    private int m;
    private int a;
    private String escolha;
    
    
		
    	public String getEscolha() {
		return escolha;
	}


	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}


		public void teste() throws ClassNotFoundException, SQLException{
    	
			
    	System.out.println("Chegou aqui Teste");
    	System.out.println("nome:  " + est.getNomeEstacionamento());


    }
    
    
		public int getD() {
		return d;
	}

		public void setD(int d) {
		this.d = d;
	}

		public int getM() {
		return m;
	}

		public void setM(int m) {
		this.m = m;
	}

		public int getA() {
		return a;
	}

		public void setA(int a) {
		this.a = a;
	}

		public void cadEstacionamento() throws ClassNotFoundException, SQLException{
		System.out.println("aqui 1");

		dao.insertEst(est);
		System.out.println(getEst());
		
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
	        createLineModels();
	       	
	      List<Estacionamento> estacionamento;
		try {
			estacionamento = dao.buscaEstacionamento();
		
	      for (Estacionamento dados : estacionamento) {
	    	  
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
 
	    public LineChartModel getLineModel2() {
	        return lineModel2;
	    }
	     
	    public void createLineModels(){
	    	String nome = null;
	    	  List<Estacionamento> estacionamento;
	  		try {
	  			estacionamento = dao.buscaEstacionamento();
	  		
	  	      for (Estacionamento dados : estacionamento) {
	  	    	  
	  	    	  if(dados.getCnpj().equals(est.getCnpj())){
	  	    		  
	  	    		  nome = dados.getNomeEstacionamento(); 
	  	    		  
	  	    		  
	  	    	  }
	  	       
	  	      } 
	  	        
	  		} catch (SQLException e) {
	  			e.printStackTrace();
	  		}
	  	      
	    	
	        lineModel2 = initCategoryModel();
	        lineModel2.setTitle(nome);
	        lineModel2.setLegendPosition("e");
	        lineModel2.setShowPointLabels(true);
	        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Tipo da Reserva"));
	        Axis    yAxis = lineModel2.getAxis(AxisType.Y);
	        yAxis.setLabel("Reservas");
	        yAxis.setMin(0);
	        yAxis.setMax(100);
	    }
	    
	    public LineChartModel initCategoryModel() {
	        LineChartModel model = new LineChartModel();
	        
	    	 System.out.println("Chegou aqui 04");

	   try {
		contador();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	        
	        ChartSeries boys = new ChartSeries();
	        boys.setLabel("Estatísticas");
	        boys.set("Dia", d);
	        boys.set("Mês", m);
	        boys.set("Ano", a);
	      
	 
	    	 System.out.println("Chegou aqui 07" + d);

	 
	        model.addSeries(boys);
	        
		     
	        return model;
	    }

	    public void contador() throws SQLException, ClassNotFoundException{
	    	
	    	System.out.println("Chegou aqui 02");
	    	

	    	 List<Reserva> reserva;
	 		
	 			reserva = dao.buscaReserva();
	 			
	 	      for (Reserva dados : reserva) {
	 	    	  
	 	    	 System.out.println("Chegou aqui 03");
	 	    	 System.out.println("Teste 01 "+ dados.getCnpj() + est.getCnpj());

	    	 
	    	 if(dados.getTipoReserva().equals("Dia")&& dados.getCnpj().equals(est.getCnpj())){ 		 
	    		  
	    		 d = d+1;
	    		     		 
	    	 }
	    		 if(dados.getTipoReserva().equals("Mensal") && dados.getCnpj().equals(est.getCnpj())){
		    		
	    			 
		    		 m = m+1;
	    			 
		    	 }
	    		 
	    		 if(dados.getTipoReserva().equals("Anual") && dados.getCnpj().equals(est.getCnpj())){
		    		
	    			 
		    		 a = a+1;
	    			 
		    	 }
	    		 
	    	 }
	 	      System.out.println(" aqui" + "/ "+a+ "/ "+d + "/ " + m + "/ " + est.getNomeEstacionamento());
	 	      
	 	      }//}
	    
 
	    
}
