package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentHosteDetailsEntity;


public class StudentHostelDetailsDao extends AbstractDao<StudentHosteDetailsEntity> {
    
    public StudentHostelDetailsDao() {
        super(StudentHosteDetailsEntity.class);
    }
    
    @Override
    public List<StudentHosteDetailsEntity> findAll() {
        return super.findListByQuery(StudentHosteDetailsEntity.FIND_ALL, null);
    }
}
