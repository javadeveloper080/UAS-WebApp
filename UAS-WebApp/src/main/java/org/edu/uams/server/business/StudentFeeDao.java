package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentFeeEntity;


public class StudentFeeDao extends AbstractDao<StudentFeeEntity> {
    
    public StudentFeeDao() {
        super(StudentFeeEntity.class);
    }
    
    @Override
    public List<StudentFeeEntity> findAll() {
        return super.findListByQuery(StudentFeeEntity.FIND_ALL, null);
    }
    
    
    
}
