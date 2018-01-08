package BazaDanych;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class DBConfig implements ServletContextListener{

	private static List<String> listaLogin = new ArrayList<>();
	private static List<String> listaHasel = new ArrayList<>();
	
	private static EntityManagerFactory emf;

	public List<String> zwrocListeLogin(){
		return listaLogin;
	}
	
	public List<String> zwrocListeHasel(){
		return listaHasel;
	}
	
	public static EntityManager createEntityManager() {
		if(emf != null)
			return emf.createEntityManager();
		else
			return null;
	}
	
	public static EntityManager createEntityManagers(){
		return emf.createEntityManager();
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	
		if(emf != null && emf.isOpen())
			emf.close();
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		emf = Persistence.createEntityManagerFactory("Quiz");
	}

	
	
}
