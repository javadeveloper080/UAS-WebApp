/**
 *
 */
package org.edu.uams.client.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {

    private String userName;
    private String password;
    private long id;
    private String name;

    private List userTypeList;

    private String loginMessage;

    private String pageName;
    private String userType;
    private long userTypeId;

    private List usersList;

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }
    public List getUsersList() {
        return usersList;
    }

    public void setUsersList(List usersList) {
        this.usersList = usersList;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
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
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userId
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the userId to set
     */
    public void setId(long id) {
        this.id = id;
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
    public List getUserTypeList() {
        return userTypeList;
    }

    /**
     * @param userTypeList the userType to set
     */
    public void setUserTypeList(List userTypeList) {
        this.userTypeList = userTypeList;
    }

    public void addUserTypeList(Object userType) {
        if (userTypeList == null) {
            userTypeList = new ArrayList();
        }
        this.userTypeList.add(userType);
    }

    public void clearFormValues() {
        this.userName = null;
        this.password = null;
        this.id = 0l;
        this.name = null;
        this.userTypeList = null;
        this.userType = null;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

}
