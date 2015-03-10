package org.edu.uams.server.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.server.pojo.AdminEntity;
import org.hibernate.Query;

public class AdminDao extends AbstractDao<AdminEntity> {

	public AdminDao() {
		super(AdminEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminEntity> findAll() {
		Query query = session.createQuery(AdminEntity.ADMIN_FIND_ALL);
		return query.list();
	}

	public   AdminEntity findAdminName(String adminName) {
		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("adminName", adminName);
		return super.findByQuery(AdminEntity.ADMIN_USERNAME, params);
	}

	public boolean checkUserLogin(String userName, String pwd) {

		AdminEntity adminEntity=findAdminName(userName);
		if (adminEntity!=null) {
			if (adminEntity.getAdminName().equals(userName) && adminEntity.getPassWord().equals(pwd)) {
				return true;
			}	
		}
		return false;
	}

	public  AdminEntity findByAdminLoginName(String loginName,String passWord){

		Map<String, Object> params=new LinkedHashMap<String, Object>();
		params.put("adminName", loginName);
		params.put("passWord", passWord);

		return super.findByQuery(AdminEntity.FIND_BY_ADMIN_LOGIN_NAME, params);

	}

}
