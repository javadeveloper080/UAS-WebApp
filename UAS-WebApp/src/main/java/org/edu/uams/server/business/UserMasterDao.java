package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.UserMasterEntity;
import org.hibernate.Query;

public class UserMasterDao extends AbstractDao<UserMasterEntity> {

	public UserMasterDao() {
		super(UserMasterEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMasterEntity> findAll() {
		Query query = session.createQuery(UserMasterEntity.USER_MASTER_FIND_ALL);
		return query.list();
	}

	public   UserMasterEntity findUserName(String email) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("email", email);
		return super.findByQuery(UserMasterEntity.FIND_USERNAME, params);
	}

	public boolean checkUserLogin(String userName, String pwd) {

		UserMasterEntity userMasterEntity=findUserName(userName);
		if (userMasterEntity!=null) {
			if (userMasterEntity.getEmail().equals(userName) && userMasterEntity.getPassWord().equals(pwd)) {
				return true;
			}	
		}
		return false;
	}

	public  UserMasterEntity findByLoginName(String loginName,String passWord){


		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("passWord", passWord);

		return super.findByQuery("SELECT u FROM UserMaster u where u.email=:loginName and u.passWord=:passWord", params);

	}

}
