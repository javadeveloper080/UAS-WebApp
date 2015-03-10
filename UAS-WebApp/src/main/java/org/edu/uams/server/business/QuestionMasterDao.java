package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.QuestionMasterEntity;
import org.hibernate.Query;

public class QuestionMasterDao extends AbstractDao<QuestionMasterEntity> {

	public QuestionMasterDao() {
		super(QuestionMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionMasterEntity> findAll() {
		Query query = session.createQuery(QuestionMasterEntity.FIND_ALL);
		return query.list();
	}

	public   QuestionMasterEntity findByQuestionId(long questionId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("questionId", questionId);
		return super.findByQuery(QuestionMasterEntity.FIND_BY_QUESTION_ID, params);
	}	

	
	public   List<QuestionMasterEntity> findByCourseId(long courseId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseId", courseId);
		return super.findListByQuery(QuestionMasterEntity.FIND_BY_COURSE_ID, params);
	}





}
