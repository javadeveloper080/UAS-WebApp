package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.FeeTypeEntity;


public class FeeTypeDao extends AbstractDao<FeeTypeEntity> {
    
    public FeeTypeDao() {
        super(FeeTypeEntity.class);
    }
    
    @Override
    public List<FeeTypeEntity> findAll() {
        return super.findListByQuery(FeeTypeEntity.FIND_ALL, null);
    }
    
    public FeeTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(FeeTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
