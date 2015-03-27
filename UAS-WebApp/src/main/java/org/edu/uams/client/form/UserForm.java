/**
 *
 */
package org.edu.uams.client.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {

    private static final long serialVersionUID = -4378858689068575003L;

    private long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String userType;

    private String passWord;

    private String addressLine1;

    private String addressLine2;

    private String email;

    private String city;

    private String state;

    private String country;

    private long pin;

    private long mobile;

    private List userTypeList;
    
    private long userTypeId;
    
    private String pageName;
    
    private List usersList;
    
    private String inActiveOn;

    public String getInActiveOn() {
        return inActiveOn;
    }

    public void setInActiveOn(String inActiveOn) {
        this.inActiveOn = inActiveOn;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List getUsersList() {
        return usersList;
    }

    public void setUsersList(List usersList) {
        this.usersList = usersList;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public List getUserTypeList() {
        return userTypeList;
    }

    /**
     * @param userTypeList the userTypeList to set
     */
    public void setUserTypeList(List userTypeList) {
        this.userTypeList = userTypeList;
    }

   
    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public void clearFormValues() {
        this.id = 0;
        this.userName = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
        this.gender = null;
        this.userType = null;
        this.passWord = null;
        this.addressLine1 = null;
        this.addressLine2 = null;
        this.email = null;
        this.city = null;
        this.state = null;
        this.country = null;
        this.pin = 0;
        this.mobile = 0;
        this.userTypeList = null;
        this.userTypeId = 0;
        this.pageName = null;
        this.usersList = null;
        this.inActiveOn = null;
    }

    
}
