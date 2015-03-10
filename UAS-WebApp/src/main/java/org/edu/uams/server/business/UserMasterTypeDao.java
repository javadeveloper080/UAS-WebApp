package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class UserMasterTypeDao extends AbstractDao<UserMasterTypeEntity> {

	public UserMasterTypeDao() {
		super(UserMasterTypeEntity.class);
	}

	@Override
	public List<UserMasterTypeEntity> findAll() {
		return super.findListByQuery(UserMasterTypeEntity.USERMASTERTYPE_FIND_ALL, null);
	}

	public UserMasterTypeEntity findByValue(String value) {
		Map<String, Object> parmas=new LinkedHashMap<String, Object>();
		parmas.put("value", value);
		return super.findByQuery(UserMasterTypeEntity.USERMASTERTYPE_FINDBYVALUE, parmas);
	}

}
