/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohammed.Tauseef
 */
public class ProgramLevelTypeEntityTest extends  AbstractPojoTestCase{
    
    public ProgramLevelTypeEntityTest() {
    }
    
    
    
    @Test
    public void testFindAll() {
        Session session=getSession();
        Transaction transaction = session.getTransaction();
        ProgramLevelTypeEntity programLevelTypeEntity=new ProgramLevelTypeEntity("TEST", "DESCRIPTION");
        transaction.begin();
        session.save(programLevelTypeEntity);
               transaction.commit();
        Query query = getSession().createQuery(ProgramLevelTypeEntity.FIND_ALL);
        long expResult = 1L;
        long result = query.list().size();
      //  assertEquals(expResult, result);
        
         transaction.begin();
        session.delete(programLevelTypeEntity);
        session.flush();
        transaction.commit();
        System.out.println("testing done");
    }
    
    @Test
    public void testFindByCode() {
        Session session=getSession();
        Transaction transaction = session.getTransaction();
        ProgramLevelTypeEntity programLevelTypeEntity=new ProgramLevelTypeEntity("ABC", "DESCRIPTION");
        transaction.begin();
        session.save(programLevelTypeEntity);
            transaction.commit();
        Query query = getSession().createQuery(ProgramLevelTypeEntity.FIND_BY_CODE);
        query.setParameter("code", "ABC");
        long expResult = 1L;
        long result = query.list().size();
        assertEquals(expResult, result);
        transaction.begin();
        session.delete(programLevelTypeEntity);
        session.flush();
        transaction.commit();
        System.out.println("testing done");
    }
    
}
