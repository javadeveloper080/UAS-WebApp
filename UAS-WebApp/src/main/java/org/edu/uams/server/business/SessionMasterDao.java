package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.SessionMasterEntity;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.hibernate.Query;

public class SessionMasterDao extends AbstractDao<SessionMasterEntity> {

	public SessionMasterDao() {
		super(SessionMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SessionMasterEntity> findAll() {
		Query query = session.createQuery(SessionMasterEntity.SESSIONMASTER_FIND_ALL);
		return query.list();
	}


	public  List<SessionMasterEntity> findSessionsForCourse(CourseMasterEntity courseMasterEntity) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseMasterEntity", courseMasterEntity);
		return super.findListByQuery(SessionMasterEntity.SESSIONMASTER_FIND_BY_COURSE_ID, params);
	}
	
	public SessionMasterEntity findBySessionTopic(String topic) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("topic", topic);
		return super.findByQuery(SessionMasterEntity.FIND_BY_SESSION_TOPIC, params);
	}



}
