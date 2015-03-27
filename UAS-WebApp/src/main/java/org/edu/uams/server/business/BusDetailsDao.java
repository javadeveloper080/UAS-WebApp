package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.BusDetailsEntity;


public class BusDetailsDao extends AbstractDao<BusDetailsEntity> {
    
    public BusDetailsDao() {
        super(BusDetailsEntity.class);
    }
    
    
    @Override
    public List<BusDetailsEntity> findAll() {
        return super.findListByQuery(BusDetailsEntity.FIND_ALL, null);
    }
    
}
