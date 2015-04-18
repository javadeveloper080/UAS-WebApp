/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.pojo.StudentQualificationEntity;
import org.hibernate.Query;

/**
 *
 * @author SARAT
 */
public class StudentEnrollmentDAO  extends AbstractDao<StudentEnrollmentEntity> {
    
    public StudentEnrollmentDAO() {
        super(StudentEnrollmentEntity.class);
    }
    
    
    
    @Override
    public List<StudentEnrollmentEntity> findAll() {
        return super.findListByQuery(StudentEnrollmentEntity.FIND_ALL, null);
    }
    
    public Long getLastestId() {
        Query query = session.createQuery(StudentEnrollmentEntity.GET_LASTEST_ID);
        List resultlist = query.list();
        
        if (resultlist!=null && resultlist.size()>0) {
            return (Long) query.list().get(0);
        }
        else{
            return 0L;
        }
    }
    
}
