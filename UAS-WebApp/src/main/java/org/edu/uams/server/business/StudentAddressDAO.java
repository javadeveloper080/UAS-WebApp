/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentAddressEntity;

/**
 *
 * @author SARAT
 */
public class StudentAddressDAO extends AbstractDao<StudentAddressEntity> {
    
    public StudentAddressDAO() {
        super(StudentAddressEntity.class);
    }
    @Override
    public List<StudentAddressEntity> findAll() {
        return super.findListByQuery(StudentAddressEntity.FIND_ALL, null);
    }
    
    
    public List<StudentAddressEntity> findByStudentId(Long studentId) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("studentId", studentId);
        return super.findListByQuery(StudentAddressEntity.FIND_BY_STUDENT_ID, params);      
    }
    
}
