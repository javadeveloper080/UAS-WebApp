package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentBusAccDetailsEntity;

import org.edu.uams.server.pojo.StudentCourseEntity;

public class StudentCourseDao extends AbstractDao<StudentCourseEntity> {
    
    public StudentCourseDao() {
        super(StudentCourseEntity.class);
    }
    
    
    @Override
    public List<StudentCourseEntity> findAll() {
        return super.findListByQuery(StudentCourseEntity.FIND_ALL, null);
    }
    
    public List<StudentCourseEntity> findByStudentId(Long studentId) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("studentId", studentId);
        return super.findListByQuery(StudentBusAccDetailsEntity.FIND_BY_STUDENT_ID, params);
    }
    
    
    
    
    
}
