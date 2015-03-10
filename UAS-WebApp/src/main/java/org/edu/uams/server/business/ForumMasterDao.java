package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.ForumMasterEntity;
import org.hibernate.Query;

public class ForumMasterDao extends AbstractDao<ForumMasterEntity> {

	public ForumMasterDao() {
		super(ForumMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumMasterEntity> findAll() {
		Query query = session.createQuery(ForumMasterEntity.FIND_ALL);
		return query.list();
	}

	public   ForumMasterEntity findByCourseId(long courseId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseId", courseId);
		return super.findByQuery(ForumMasterEntity.FIND_BY_COURSE_ID, params);
	}	

	
	public   List<ForumMasterEntity> findByUserId(long userId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("userId", userId);
		return super.findListByQuery(ForumMasterEntity.FIND_BY_USER_ID, params);
	}





}
