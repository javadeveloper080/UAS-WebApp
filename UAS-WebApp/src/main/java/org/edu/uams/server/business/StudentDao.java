package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.StudentEntity;


public class StudentDao extends AbstractDao<StudentEntity> {
    
    public StudentDao() {
        super(StudentEntity.class);
    }
    
    @Override
    public List<StudentEntity> findAll() {
        return super.findListByQuery(StudentEntity.FIND_ALL, null);
    }
    
    public StudentEntity findByStudentRollNumber(String rollNumber) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("rollNumber", rollNumber);
        return super.findByQuery(StudentEntity.FIND_BY_STUDENT_ROLL_NUMBER, params);
    }

    public StudentEntity findByStudentEnrollmentNumber(String enrollmentNumber) {
         Map<String, Object> params=new LinkedHashMap<>();
        params.put("enrollmentNumber", enrollmentNumber);
        return super.findByQuery(StudentEntity.FIND_BY_STUDENT_ENROLLMENT_NUMBER, params);
    }
        
}
