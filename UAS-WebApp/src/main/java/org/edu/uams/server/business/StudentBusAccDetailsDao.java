package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentBusAccDetailsEntity;


public class StudentBusAccDetailsDao extends AbstractDao<StudentBusAccDetailsEntity> {
    
    public StudentBusAccDetailsDao() {
        super(StudentBusAccDetailsEntity.class);
    }
    

    @Override
    public List<StudentBusAccDetailsEntity> findAll() {
         return super.findListByQuery(StudentBusAccDetailsEntity.FIND_ALL, null);
    }
    
}
