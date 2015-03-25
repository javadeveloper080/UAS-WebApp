package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class UserMasterTypeDao extends AbstractDao<UserMasterTypeEntity> {
    
    public UserMasterTypeDao() {
        super(UserMasterTypeEntity.class);
    }
    
    @Override
    public List<UserMasterTypeEntity> findAll() {
        return super.findListByQuery(UserMasterTypeEntity.FIND_ALL, null);
    }
    
    public UserMasterTypeEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(UserMasterTypeEntity.FIND_BY_CODE, parmas);
    }
    
}
