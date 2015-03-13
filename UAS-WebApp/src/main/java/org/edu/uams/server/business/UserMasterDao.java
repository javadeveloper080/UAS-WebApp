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
    
    @Override
    public List<UserMasterEntity> findAll() {
        Query query = session.createQuery(UserMasterEntity.FIND_ALL);
        return query.list();
    }
    
    public   UserMasterEntity findUserName(String userName) {
        Map<String, Object> params=new LinkedHashMap<String, Object>();
        params.put("userName", userName);
        return super.findByQuery(UserMasterEntity.FIND_BY_USERNAME, params);
    }
    
    public boolean checkUserLogin(String userName, String pwd) {
        UserMasterEntity userMasterEntity=findUserName(userName);
        if (userMasterEntity!=null) {
            if (userMasterEntity.getUserName().equals(userName) && userMasterEntity.getPassWord().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
    
    public  UserMasterEntity findByLoginName(String userName,String passWord){
        Map<String, Object> params=new LinkedHashMap<String, Object>();
        params.put("userName", userName);
        params.put("passWord", passWord);
        return super.findByQuery(UserMasterEntity.FIND_BY_LOGIN_NAME_PWD, params);
    }
    
}
