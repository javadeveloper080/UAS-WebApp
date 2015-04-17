package org.edu.uams.server.util;

import java.util.List;

import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.UserMasterDao;
import org.edu.uams.server.business.UserMasterTypeDao;
import org.edu.uams.server.pojo.UserMasterEntity;
import org.edu.uams.server.pojo.UserMasterTypeEntity;

public class ApplicationIntializer {
    
    private static UserMasterTypeDao userMasterTypeDao=null;
    
    public static void init() {
        createUserMasterTypeValues();
        createUserMasterDefaultValue();
    }
    
    
    
    private static void createUserMasterTypeValues() {
        
        userMasterTypeDao=new UserMasterTypeDao();
        List<UserMasterTypeEntity> userTypelist = userMasterTypeDao.findAll();
        
        if (userTypelist==null || userTypelist.isEmpty()) {
            UserMasterTypeEntity professor = new UserMasterTypeEntity(ApplicationConstants.PROFESSOR,ApplicationConstants.PROFESSOR);
            UserMasterTypeEntity student = new UserMasterTypeEntity(ApplicationConstants.STUDENT,ApplicationConstants.STUDENT);
            UserMasterTypeEntity clerk = new UserMasterTypeEntity(ApplicationConstants.CLERK,ApplicationConstants.CLERK);
            UserMasterTypeEntity admin = new UserMasterTypeEntity(ApplicationConstants.ADMIN,ApplicationConstants.ADMIN);
            userMasterTypeDao.persist(admin);
            userMasterTypeDao.persist(professor);
            userMasterTypeDao.persist(clerk);
            userMasterTypeDao.persist(student);
        }
        
    }
    
    private static void createUserMasterDefaultValue() {
        
        UserMasterDao userMasterDao=new UserMasterDao();
        UserMasterEntity admin =userMasterDao.findUserName(ApplicationConstants.ADMIN);
        
        
        if (admin==null) {
            admin=new UserMasterEntity();
            admin.setPassword("pwd");
            admin.setEmail("admin.@tmail.com");
            admin.setUserName(ApplicationConstants.ADMIN);
            admin.setUserType(userMasterTypeDao.findByCode(ApplicationConstants.ADMIN));
            admin.setEmail("admin@test.com");
            userMasterDao.persist(admin);
        }
    }
    
  
    
}
