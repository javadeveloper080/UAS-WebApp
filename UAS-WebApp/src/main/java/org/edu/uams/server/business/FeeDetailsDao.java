package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.FeeDetailsEntity;


public class FeeDetailsDao extends AbstractDao<FeeDetailsEntity> {
    
    public FeeDetailsDao() {
        super(FeeDetailsEntity.class);
    }
    
    @Override
    public List<FeeDetailsEntity> findAll() {
        return super.findListByQuery(FeeDetailsEntity.FIND_ALL, null);
    }
       
    
    
}
