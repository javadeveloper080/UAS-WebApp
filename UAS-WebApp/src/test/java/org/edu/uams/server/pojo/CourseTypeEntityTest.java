/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohammed.Tauseef
 */
public class CourseTypeEntityTest extends  AbstractPojoTestCase{
    
    public CourseTypeEntityTest() {
    }
    
    
    
    @Test
    public void testFindAll() {
        Session session=getSession();
        Transaction transaction = session.getTransaction();
        CourseTypeEntity courseTypeEntity=new CourseTypeEntity("TEST", "DESCRIPTION");
        transaction.begin();
        session.save(courseTypeEntity);
               transaction.commit();
        Query query = getSession().createQuery(CourseTypeEntity.FIND_ALL);
        long expResult = 1L;
        long result = query.list().size();
        assertEquals(expResult, result);
        
         transaction.begin();
        session.delete(courseTypeEntity);
        session.flush();
        transaction.commit();
        System.out.println("testing done");
    }
    
    @Test
    public void testFindByCode() {
        Session session=getSession();
        Transaction transaction = session.getTransaction();
        CourseTypeEntity courseTypeEntity=new CourseTypeEntity("ABC", "DESCRIPTION");
        transaction.begin();
        session.save(courseTypeEntity);
            transaction.commit();
        Query query = getSession().createQuery(CourseTypeEntity.FIND_BY_CODE);
        query.setParameter("code", "ABC");
        long expResult = 1L;
        long result = query.list().size();
        assertEquals(expResult, result);
        transaction.begin();
        session.delete(courseTypeEntity);
        session.flush();
        transaction.commit();
        System.out.println("testing done");
    }
    
    
    
    
    
    
}
