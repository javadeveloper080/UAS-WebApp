package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.CourseTypeEntity;


public class CourseTypeDao extends AbstractDao<CourseTypeEntity> {
    
    public CourseTypeDao() {
        super(CourseTypeEntity.class);
    }
    
    @Override
    public List<CourseTypeEntity> findAll() {
        return super.findListByQuery(CourseTypeEntity.FIND_ALL, null);
    }
    
    public CourseTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(CourseTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
