package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.ForumSubscribersEntity;
import org.hibernate.Query;

public class ForumsSubscribersDao extends AbstractDao<ForumSubscribersEntity> {

	public ForumsSubscribersDao() {
		super(ForumSubscribersEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumSubscribersEntity> findAll() {
		Query query = session.createQuery(ForumSubscribersEntity.FIND_ALL);
		return query.list();
	}

	public   List<ForumSubscribersEntity> findByForumMasterId(long forumMasterId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("forumMasterId", forumMasterId);
		return super.findListByQuery(ForumSubscribersEntity.FIND_BY_FORUM_MASTER, params);
	}	

	
	public   List<ForumSubscribersEntity> findByCourseId(long userId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("userId", userId);
		return super.findListByQuery(ForumSubscribersEntity.FIND_BY_SUBSCRIBER_ID, params);
	}





}
