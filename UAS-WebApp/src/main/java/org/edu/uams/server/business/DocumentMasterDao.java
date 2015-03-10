package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.DocumentEntity;
import org.edu.uams.server.pojo.ExamMasterEntity;

public class DocumentMasterDao extends AbstractDao<DocumentEntity> {

	public DocumentMasterDao() {
		super(DocumentEntity.class);
	}

	@Override
	public List<DocumentEntity> findAll() {
		return null;
	}

	
	public List<DocumentEntity> findByCourseId(Long courseId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseId", courseId);
		return super.findListByQuery(DocumentEntity.FIND_BY_COURSEID,params);
	}


}
