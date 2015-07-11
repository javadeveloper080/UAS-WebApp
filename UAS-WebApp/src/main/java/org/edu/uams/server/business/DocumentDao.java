package org.edu.uams.server.business;

import java.util.List;

import org.edu.uams.server.pojo.DocumentEntity;


public class DocumentDao extends AbstractDao<DocumentEntity> {
    
    public DocumentDao() {
        super(DocumentEntity.class);
    }
    
    
    @Override
    public List<DocumentEntity> findAll() {
        return super.findListByQuery(DocumentEntity.FIND_ALL, null);
    }
    

}
