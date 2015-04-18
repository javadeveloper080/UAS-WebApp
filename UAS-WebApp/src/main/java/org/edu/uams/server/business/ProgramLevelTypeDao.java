package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.ProgramLevelTypeEntity;


public class ProgramLevelTypeDao extends AbstractDao<ProgramLevelTypeEntity> {
    
    public ProgramLevelTypeDao() {
        super(ProgramLevelTypeEntity.class);
    }
    
    @Override
    public List<ProgramLevelTypeEntity> findAll() {
        return super.findListByQuery(ProgramLevelTypeEntity.FIND_ALL, null);
    }
    
    public ProgramLevelTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<>();
        parmas.put("code", code);
        return super.findByQuery(ProgramLevelTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
