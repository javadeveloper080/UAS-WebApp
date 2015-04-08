package org.edu.uams.client.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.edu.uams.server.api.GenderType;

/**
 *
 * @author SARAT
 */
public class StudentForm extends ActionForm {

    private Long admnNum;
    private String rollNum;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private Long mobile;
    private String dob;
    private String genderType;
    private String pageName;

    public Long getAdmnNum() {
        return admnNum;
    }

    public void setAdmnNum(Long admnNum) {
        this.admnNum = admnNum;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        admnNum = null;
        rollNum = null;
        firstName = null;
        lastName = null;
        fatherName = null;
        motherName = null;
        mobile = null;
        dob = null;
        genderType = null;
        pageName = null;
    }

}
