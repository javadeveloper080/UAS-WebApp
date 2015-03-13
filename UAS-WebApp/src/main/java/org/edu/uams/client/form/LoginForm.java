 /**
  *
  */
package org.edu.uams.client.form;

import org.apache.struts.action.ActionForm;


public class LoginForm extends ActionForm {
    
    private String userName;
    private String password;
    private long userId;
    private String name;
    
    
    
    private String userType;
    
    private String loginMessage;
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }
    
    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
    public void clearFormValues() {
        this.userName = null;
        this.password = null;
        this.userId = 0l;
        this.name = null;
        this.userType = null;
    }
    
    public String getLoginMessage() {
        return loginMessage;
    }
    
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
}
