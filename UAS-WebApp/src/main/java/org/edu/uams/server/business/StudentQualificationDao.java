package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentQualificationEntity;


public class StudentQualificationDao extends AbstractDao<StudentQualificationEntity> {
    
    public StudentQualificationDao() {
        super(StudentQualificationEntity.class);
    }
    
    @Override
    public List<StudentQualificationEntity> findAll() {
        return super.findListByQuery(StudentQualificationEntity.FIND_ALL, null);
    }
  
}
