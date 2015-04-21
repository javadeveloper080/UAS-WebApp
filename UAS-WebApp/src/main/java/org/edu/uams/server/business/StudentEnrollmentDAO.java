/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.api.EnrollmentStatusType;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.hibernate.Query;


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
    
     public StudentEnrollmentEntity findByStudentEnrollmentNumber(String enrollmentNumber) {
         Map<String, Object> params=new LinkedHashMap<>();
        params.put("enrollmentNumber", enrollmentNumber);
        return super.findByQuery(StudentEnrollmentEntity.FIND_BY_STUDENT_ENROLLMENT_NUMBER, params);
    }
    
     
    public List<StudentEnrollmentEntity> findByAppliedCourse(Long courseId) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("courseId", courseId);
        return super.findListByQuery(StudentEnrollmentEntity.FIND_BY_APPLIED_COURSE_ID, params);
    }
    
    public List<StudentEnrollmentEntity> findByEnrollmentStatusType(String enrollmentStatusType) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("enrollmentStatusType", EnrollmentStatusType.valueOf(enrollmentStatusType));
        return super.findListByQuery(StudentEnrollmentEntity.FIND_BY_STATUS, params);
    }
    
     public List<StudentEnrollmentEntity> findByAppliedCourseStatusType(Long courseId,String enrollmentStatusType) {
        Map<String, Object> params=new LinkedHashMap<>();
        params.put("enrollmentStatusType", EnrollmentStatusType.valueOf(enrollmentStatusType));
        params.put("courseId", courseId);
        return super.findListByQuery(StudentEnrollmentEntity.FIND_BY_APPLIED_COURSE_STATUS, params);
    }
    
    
    
}
