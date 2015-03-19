package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.FeeCategoryTypeEntity;


public class FeeCategoryTypeDao extends AbstractDao<FeeCategoryTypeEntity> {
    
    public FeeCategoryTypeDao() {
        super(FeeCategoryTypeEntity.class);
    }
    
    @Override
    public List<FeeCategoryTypeEntity> findAll() {
        return super.findListByQuery(FeeCategoryTypeEntity.FIND_ALL, null);
    }
    
    public FeeCategoryTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(FeeCategoryTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
