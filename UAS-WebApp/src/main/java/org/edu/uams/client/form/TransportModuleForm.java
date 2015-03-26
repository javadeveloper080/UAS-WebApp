/**
 *
 */
package org.edu.uams.client.form;

import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;


public class TransportModuleForm extends ActionForm {
    
    
    
    private long id;
    private String pageName;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    //Bus Faculty details starts
    private String firstName;
    private String lastName;
    private String addrLine1;
    private String addrLine2;
    private String addrLine3;
    private String addrLine4;
    private String city;
    private String stateName;
    private long zipCode;
    private long mobile;
    private String facultyType;
    private String licenseNum;
    private String licenseExpiryDate ;
    
    private List facultyTypeList;
    private  List busFacultyList;
    
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
    
    public String getAddrLine1() {
        return addrLine1;
    }
    
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }
    
    public String getAddrLine2() {
        return addrLine2;
    }
    
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }
    
    public String getAddrLine3() {
        return addrLine3;
    }
    
    public void setAddrLine3(String addrLine3) {
        this.addrLine3 = addrLine3;
    }
    
    public String getAddrLine4() {
        return addrLine4;
    }
    
    public void setAddrLine4(String addrLine4) {
        this.addrLine4 = addrLine4;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public long getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }
    
    public long getMobile() {
        return mobile;
    }
    
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
    
    public List getFacultyTypeList() {
        return facultyTypeList;
    }
    
    public void setFacultyTypeList(List facultyTypeList) {
        this.facultyTypeList = facultyTypeList;
    }
    
    
    
    public List getBusFacultyList() {
        return busFacultyList;
    }
    
    public void setBusFacultyList(List busFacultyList) {
        this.busFacultyList = busFacultyList;
    }
    
    public String getFacultyType() {
        return facultyType;
    }
    
    public void setFacultyType(String facultyType) {
        this.facultyType = facultyType;
    }
    
    public String getLicenseNum() {
        return licenseNum;
    }
    
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }
    
    public String getLicenseExpiryDate() {
        return licenseExpiryDate;
    }
    
    public void setLicenseExpiryDate(String licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }
    
    
    
    //Bus Faculty details ends
    
    public void resetForm(){
        this.id =0l;
        this.pageName=null;
        this.firstName=null;
        this.lastName =null;
        this.addrLine1=null;
        this.addrLine2 =null;
        this.addrLine3 =null;
        this.addrLine4 =null;
        this.city=null;
        this.stateName =null;
        this.zipCode =0l;
        this.mobile=0l;
        this.facultyTypeList=null;
        this.busFacultyList=null;
        this.licenseNum=null;
        this.licenseExpiryDate =null;
    }
    
    
    
}
