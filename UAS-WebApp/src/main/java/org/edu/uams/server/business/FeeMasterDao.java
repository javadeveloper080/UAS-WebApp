package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.FeeMasterEntity;


public class FeeMasterDao extends AbstractDao<FeeMasterEntity> {
    
    public FeeMasterDao() {
        super(FeeMasterEntity.class);
    }
    
    @Override
    public List<FeeMasterEntity> findAll() {
        return super.findListByQuery(FeeMasterEntity.FIND_ALL, null);
    }
       
    
    
}
