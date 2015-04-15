package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentQualificationEntity;


public class StudentQualificationDao extends AbstractDao<StudentQualificationEntity> {
    
    public StudentQualificationDao() {
        super(StudentQualificationEntity.class);
    }
    
    @Override
    public List<StudentQualificationEntity> findAll() {
        return super.findListByQuery(StudentQualificationEntity.FIND_ALL, null);
    }
    
    public StudentQualificationEntity findByStudentId(Long studentId) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("studentId", studentId);
        return super.findByQuery(StudentQualificationEntity.FIND_BY_STUDENT_ID, params);
    }
    
}
