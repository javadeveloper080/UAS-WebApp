/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edu.uams.server.pojo;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mohammed.Tauseef
 */
public class NewMain {

 private static SessionFactory factory; 
 
 
    public static void main(String[] args) {
       createSessionFactory();
		 Session session=factory.openSession();
                 System.out.println("session tauseef::"+session);
                 
                 Query query = session.createQuery(CourseTypeEntity.FIND_ALL);

		

		List resultlist = query.list();
                
                System.out.println("result tauseef::"+resultlist.size());
    }
    
   


	

	public static SessionFactory createSessionFactory() {

		if (factory==null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;

	}

    
}
