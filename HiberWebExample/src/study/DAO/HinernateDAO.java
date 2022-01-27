package study.DAO;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.entity.GroceryProductEntity;

public class HinernateDAO {
	public Session session;

	public void insertRecord(GroceryProductEntity gp) {
		getSession();
		Transaction tr =session.beginTransaction();
		GroceryProductEntity record =gp;
		session.save(record);
		
		tr.commit();
	}
	
	public  Session getSession()
	{
		//READING the hibernate.cfg.xml  from the classpath 
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources sources = new MetadataSources(registry);		    // Create Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Create SessionFactory
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();

		session = sessionFactory.openSession(); // start a transaction

		return session;
	}
	public List<GroceryProductEntity> detail(){
		getSession();
		Transaction tr =session.beginTransaction();
		
		List<GroceryProductEntity> gplist =session.createQuery("select g from grocery_products g").getResultList();
		tr.commit();
		return gplist;
	}

	public void delete(int pid) {
		
		getSession();
		Transaction tr =session.beginTransaction();
		GroceryProductEntity gp =session.find(GroceryProductEntity.class, pid);
		
		if(gp !=null) {
			session.delete(gp);
		}
		tr.commit();
	}
	
	public void update(String id, String choice, String change) {
		int pid=Integer.parseInt(id);
		getSession();
		Transaction tr = session.beginTransaction();
		GroceryProductEntity gp =session.find(GroceryProductEntity.class, pid);
		if(choice.equals("name")) {
			gp.setProductName(change);
		}
		else if(choice.equals("desc")) {
			gp.setProductDesc(change);
		}
		else if(choice.equals("cost")) {
			gp.setCost(Integer.parseInt(change));
		}
		else if(choice.equals("unit")) {
			gp.setUnit(Integer.parseInt(change));
		}
		else if(choice.equals("date")) {
			gp.setExpiryDate(Date.valueOf(change));
		}
		
		tr.commit();
	}


}
