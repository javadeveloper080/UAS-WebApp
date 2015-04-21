/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edu.uams.server.pojo;

import org.hibernate.Query;
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
    
    

    /**
     * Test of getId method, of class CourseTypeEntity.
     */
    @Test
    public void testFindAll() {
        Query query = getSession().createQuery(CourseTypeEntity.FIND_ALL);
        long expResult = 0L;
        long result = query.list().size();
        assertEquals(expResult, result);
        System.out.println("testing done");
    }

   
    
}
