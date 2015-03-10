package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.QuestionMasterEntity;
import org.edu.uams.server.pojo.ResultMasterEntity;
import org.hibernate.Query;

public class ResultMasterDao extends AbstractDao<ResultMasterEntity> {

	public ResultMasterDao() {
		super(ResultMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResultMasterEntity> findAll() {
		Query query = session.createQuery(ResultMasterEntity.RESULTMASTER_FIND_ALL);
		return query.list();
	}

	public List<ResultMasterEntity> findByUserMasterId(long userMasterId) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("userMasterId", userMasterId);
		return super.findListByQuery(ResultMasterEntity.USERMASTERID, params);
		
	}






}
