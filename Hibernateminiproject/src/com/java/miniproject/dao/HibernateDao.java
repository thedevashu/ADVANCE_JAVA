package com.java.miniproject.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.java.miniproject.entity.Hobby;
import com.java.miniproject.entity.User;

public class HibernateDao {

	public HibernateDao() {
		
			
	}
	
	public boolean validateUser(User nuser) {
		Session session= getSession();
		
		org.hibernate.query.Query<User> u  =session.createNativeQuery("select * from user_info where username='"+nuser.getUname()+"' and password='"+nuser.getPass()+"'");
		List<User> ul=u.list();
		System.out.println(ul+"\n");
		if(ul.isEmpty())
			return false;
		else
			return true;
	}

	public static Session getSession()
	{
		//READING the hibernate.cfg.xml  from the classpath 
		  StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
	    // Create MetadataSources
	    MetadataSources sources = new MetadataSources(registry);
	    // Create Metadata
	    Metadata metadata = sources.getMetadataBuilder().build();
	    // Create SessionFactory
	    SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
	   
	    Session session = sessionFactory.openSession(); // start a transaction
		
	    return session;
	}

	public ArrayList<Hobby> getHobby(User u) {
		return null;
		// TODO Auto-generated method stub

	}
	public void addHobby(Hobby hb) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(User nUser) {
		Session session =getSession();
		Transaction tr = session.beginTransaction();
		session.save(nUser);
		tr.commit();
		
	}

}
