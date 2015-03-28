package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.BusDetailsEntity;
import org.hibernate.Query;


public class BusDetailsDao extends AbstractDao<BusDetailsEntity> {
    
    public BusDetailsDao() {
        super(BusDetailsEntity.class);
    }
    
    
    @Override
    public List<BusDetailsEntity> findAll() {
        return super.findListByQuery(BusDetailsEntity.FIND_ALL, null);
    }
    
    
     public Long getCountOfBuses() {
         Query query = session.createQuery(BusDetailsEntity.GET_COUNT_OF_BUSES);
        return (Long)query.uniqueResult();
    }
    
}
