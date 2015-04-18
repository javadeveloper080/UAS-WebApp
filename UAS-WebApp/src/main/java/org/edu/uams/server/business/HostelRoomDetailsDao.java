package org.edu.uams.server.business;

import java.util.List;
import org.edu.uams.server.pojo.HostelRoomDetailsEntity;


public class HostelRoomDetailsDao extends AbstractDao<HostelRoomDetailsEntity> {
    
    public HostelRoomDetailsDao() {
        super(HostelRoomDetailsEntity.class);
    }
    
    
    @Override
    public List<HostelRoomDetailsEntity> findAll() {
        return super.findListByQuery(HostelRoomDetailsEntity.FIND_ALL, null);
    }
}
