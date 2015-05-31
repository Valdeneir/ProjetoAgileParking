package br.com.ProjectAP.dao;


import org.hibernate.Session;
import br.com.ProjectAP.hibernate.HibernateUtility;
import br.com.ProjectAP.model.Cliente;




public class Dao {
	
	private static Dao instance;
	private Session sessao;
	
	public Dao(){
		
	}
	
	public static Dao getInstance(){
		if(instance == null)
			instance = new Dao();
		return instance;
	}
	
	public <T> Object buscarPorPlaca(Class<T> clazz, String placa){
		try{
			sessao = HibernateUtility.getSession();
			Object object = sessao.get(clazz, placa);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	
	public void salvarObjeto(Cliente cliente){
		

		try{
			sessao = HibernateUtility.getSession();
			sessao.beginTransaction();
			sessao.save(cliente);
			sessao.getTransaction().commit();
			
		}catch(Exception e){
			sessao.beginTransaction().rollback();
			e.printStackTrace();
			System.out.println(e);
			
		}finally{
				
			sessao.close();
			
		}
	}
	
	
	}
		
	
	
	

