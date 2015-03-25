package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.BusFacultyEntity;


public class BusFacultyDao extends AbstractDao<BusFacultyEntity> {
    
    public BusFacultyDao() {
        super(BusFacultyEntity.class);
    }
    
    
    @Override
    public List<BusFacultyEntity> findAll() {
        return super.findListByQuery(BusFacultyEntity.FIND_ALL, null);
    }
    
}
