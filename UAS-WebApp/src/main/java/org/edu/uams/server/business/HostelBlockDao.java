package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.HostelBlockEntity;


public class HostelBlockDao extends AbstractDao<HostelBlockEntity> {
    
    public HostelBlockDao() {
        super(HostelBlockEntity.class);
    }
    
    
    @Override
    public List<HostelBlockEntity> findAll() {
        return super.findListByQuery(HostelBlockEntity.FIND_ALL, null);
    }
}
