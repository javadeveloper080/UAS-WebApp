package org.edu.uams.client.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Sarat
 */
public class StudentAddressForm extends ActionForm {
    
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String pageName;
    private String addrLine1;
    private String addrLine2;
    private String addrLine3;
    private String addrLine4;
    private String city;
    private String stateName;
    private String country;
    private long zipCode;
    private Long studentId;
    private String addressType;
    
    private List addressTypeList;
    private  List studentAddressList;
    
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
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public String getAddressType() {
        return addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    
    public List getAddressTypeList() {
        return addressTypeList;
    }
    
    public void setAddressTypeList(List addressTypeList) {
        this.addressTypeList = addressTypeList;
    }
    
    public List getStudentAddressList() {
        return studentAddressList;
    }
    
    public void setStudentAddressList(List studentAddressList) {
        this.studentAddressList = studentAddressList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public void resetForm(){
        this.id =0l;
        this.pageName =null;
        this.addrLine1 =null;
        this.addrLine2 =null;
        this.addrLine3 =null;
        this.addrLine4 =null;
        this.city =null;
        this.stateName =null;
        this.zipCode =0l;
        this.studentId = 0l;
        this.addressTypeList=null;
        this.studentAddressList=null;
        
    }
    
    
    
}
