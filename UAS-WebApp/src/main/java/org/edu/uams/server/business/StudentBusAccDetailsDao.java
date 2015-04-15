package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentBusAccDetailsEntity;


public class StudentBusAccDetailsDao extends AbstractDao<StudentBusAccDetailsEntity> {
    
    public StudentBusAccDetailsDao() {
        super(StudentBusAccDetailsEntity.class);
    }
    

    @Override
    public List<StudentBusAccDetailsEntity> findAll() {
         return super.findListByQuery(StudentBusAccDetailsEntity.FIND_ALL, null);
    }
    
     public StudentBusAccDetailsEntity findByStudentId(Long studentId) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("studentId", studentId);
        return super.findByQuery(StudentBusAccDetailsEntity.FIND_BY_STUDENT_ID, params);
    }
    
}
