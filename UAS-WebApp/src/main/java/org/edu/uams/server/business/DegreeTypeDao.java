package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.DegreeTypeEntity;


public class DegreeTypeDao extends AbstractDao<DegreeTypeEntity> {
    
    public DegreeTypeDao() {
        super(DegreeTypeEntity.class);
    }
    
    @Override
    public List<DegreeTypeEntity> findAll() {
        return super.findListByQuery(DegreeTypeEntity.FIND_ALL, null);
    }
    
    public DegreeTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(DegreeTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
