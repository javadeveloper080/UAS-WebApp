package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.StudentEntity;


public class StudentDao extends AbstractDao<StudentEntity> {
    
    public StudentDao() {
        super(StudentEntity.class);
    }
    
    @Override
    public List<StudentEntity> findAll() {
        return super.findListByQuery(StudentEntity.FIND_ALL, null);
    }
    
//    public StudentEntity findByCode(String code) {
//        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
//        parmas.put("code", code);
//        return super.findByQuery(StudentEntity.FIND_BY_CODE, parmas);
//    }
    
}
