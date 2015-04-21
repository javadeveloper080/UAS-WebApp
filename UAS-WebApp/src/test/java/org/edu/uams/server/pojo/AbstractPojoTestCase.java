/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mohammed.Tauseef
 */
public class AbstractPojoTestCase {
    
    private SessionFactory factory;
    
    
    public  Session getSession() {
        createSessionFactory();
        return factory.openSession();
        
    }
    
    private  SessionFactory createSessionFactory() {
        
        if (factory==null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }
    
}
