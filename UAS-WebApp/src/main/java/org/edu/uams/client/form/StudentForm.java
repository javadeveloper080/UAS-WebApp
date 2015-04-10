package org.edu.uams.client.form;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.pojo.StudentEntity;

/**
 *
 * @author SARAT
 */
public class StudentForm extends ActionForm {

    private Long id;
    private Long admnNum;
    private String rollNum;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String dob;
    private String genderType;
    private String pageName;
    private String seatCategoryType;
    private String email;
    private String nationality;
    private String fatherOccup;
    private String motherOccup;
    private String parentMob;
    private Long studentMob;
    private List<StudentEntity> listOfStudents;

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

    public List<StudentEntity> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<StudentEntity> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatCategoryType() {
        return seatCategoryType;
    }

    public void setSeatCategoryType(String seatCategoryType) {
        this.seatCategoryType = seatCategoryType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFatherOccup() {
        return fatherOccup;
    }

    public void setFatherOccup(String fatherOccup) {
        this.fatherOccup = fatherOccup;
    }

    public String getMotherOccup() {
        return motherOccup;
    }

    public void setMotherOccup(String motherOccup) {
        this.motherOccup = motherOccup;
    }

    public String getParentMob() {
        return parentMob;
    }

    public void setParentMob(String parentMob) {
        this.parentMob = parentMob;
    }

    public Long getStudentMob() {
        return studentMob;
    }

    public void setStudentMob(Long studentMob) {
        this.studentMob = studentMob;
    }

    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        admnNum = null;
        rollNum = null;
        firstName = null;
        lastName = null;
        fatherName = null;
        motherName = null;
        studentMob = null;
        dob = null;
        genderType = null;
        pageName = null;
        seatCategoryType = null;
        email = null;
        nationality = null;
        fatherOccup = null;
        motherOccup = null;
        parentMob = null;
    }

}
