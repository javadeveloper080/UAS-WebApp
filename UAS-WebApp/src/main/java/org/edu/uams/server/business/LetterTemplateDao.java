package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.edu.uams.server.pojo.LetterTemplateEntity;


public class LetterTemplateDao extends AbstractDao<LetterTemplateEntity> {
    
    public LetterTemplateDao() {
        super(LetterTemplateEntity.class);
    }
    
    @Override
    public List<LetterTemplateEntity> findAll() {
        return super.findListByQuery(LetterTemplateEntity.FIND_ALL, null);
    }
    
    public LetterTemplateEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(LetterTemplateEntity.FIND_BY_CODE, parmas);
    }
    
}
