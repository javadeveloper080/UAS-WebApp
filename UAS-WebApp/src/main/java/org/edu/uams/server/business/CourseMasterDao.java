package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.CourseMasterEntity;
import org.hibernate.Query;

public class CourseMasterDao extends AbstractDao<CourseMasterEntity> {

	public CourseMasterDao() {
		super(CourseMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseMasterEntity> findAll() {
		Query query = session.createQuery(CourseMasterEntity.COURSEMASTER_FIND_ALL);
		return query.list();
	}

	public CourseMasterEntity findByCourseName(String courseName) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseName", courseName);
		return super.findByQuery(CourseMasterEntity.FIND_BY_COURSE_NAME, params);
	}

	public CourseMasterEntity findByCourseKey(String courseKey) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("courseKey", courseKey);
		return super.findByQuery(CourseMasterEntity.COURSEMASTER_FIND_COURSEKEY, params);
	}






}
