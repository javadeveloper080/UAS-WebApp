package org.edu.uams.client.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author SARAT
 */
public class StudentForm extends ActionForm {
    
    private Long id;
    private String enrollmentNumber;
    private String rollNum;
    private String studentRollNum;
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
    private long  studentId;
    private String  studentRollNumSearch;
    private String enrollmentNumSearch;
    private String studentFullName;
    private String statusMessage;
    private List genderTypeList;
    private List seatCategoryTypeList;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }
    
    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
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
    
    public long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentRollNumSearch() {
        return studentRollNumSearch;
    }
    
    public void setStudentRollNumSearch(String studentRollNumSearch) {
        this.studentRollNumSearch = studentRollNumSearch;
    }
    
    
    
    public String getStudentFullName() {
        return studentFullName;
    }
    
    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }
    
    public List getGenderTypeList() {
        return genderTypeList;
    }
    
    public void setGenderTypeList(List genderTypeList) {
        this.genderTypeList = genderTypeList;
    }
    
    public List getSeatCategoryTypeList() {
        return seatCategoryTypeList;
    }
    
    public void setSeatCategoryTypeList(List seatCategoryTypeList) {
        this.seatCategoryTypeList = seatCategoryTypeList;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
    
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    public String getStudentRollNum() {
        return studentRollNum;
    }
    
    public void setStudentRollNum(String studentRollNum) {
        this.studentRollNum = studentRollNum;
    }
    
    public String getEnrollmentNumSearch() {
        return enrollmentNumSearch;
    }
    
    public void setEnrollmentNumSearch(String enrollmentNumSearch) {
        this.enrollmentNumSearch = enrollmentNumSearch;
    }
    
    
    public void resetForm() {
        
        enrollmentNumber = null;
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
        studentId= 0l;
        studentRollNumSearch= null;
        studentFullName= null;
        statusMessage=null;
        enrollmentNumSearch=null;
        id=0l;
        studentRollNum=null;
        genderTypeList=null;
        seatCategoryTypeList=null;
    }
    
}
