package org.edu.uams.client.form;

import java.util.List;
import org.apache.struts.action.ActionForm;


public class StudentEnrollmentForm extends ActionForm {
    
    private long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String genderType;
    private String email;
    private Long studentMob;
    private String pageName;
    
    private Long applyCourseId;
    private Long lastGraduatedCourseId;
    
    private Long appliedProgramLevelTypeId;
    private Long graduatedProgramLevelTypeId;
    
    private String dateEnrolled;
    private Double grade;
    private String enrollmentNumber;
    
    private List listOfCourses;
    private List listOfProgamLevelTypes;
    private List studentEnrollmetList;
    
    private List  genderTypeList;
    
    private List enrollmentStatusTypeList;
    
    private String statusMessage;
    private String enrollmentStatusType;
    
    
    public Long getApplyCourseId() {
        return applyCourseId;
    }
    
    public void setApplyCourseId(Long applyCourseId) {
        this.applyCourseId = applyCourseId;
    }
    
    
    
    public String getDateEnrolled() {
        return dateEnrolled;
    }
    
    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
    
    public Double getGrade() {
        return grade;
    }
    
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    public List getListOfCourses() {
        return listOfCourses;
    }
    
    public void setListOfCourses(List listOfCourses) {
        this.listOfCourses = listOfCourses;
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
    
    public long getId() {
        return id;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Long getStudentMob() {
        return studentMob;
    }
    
    public void setStudentMob(Long studentMob) {
        this.studentMob = studentMob;
    }
    
    public Long getLastGraduatedCourseId() {
        return lastGraduatedCourseId;
    }
    
    public void setLastGraduatedCourseId(Long lastGraduatedCourseId) {
        this.lastGraduatedCourseId = lastGraduatedCourseId;
    }
    
    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }
    
    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
    
    public List getListOfProgamLevelTypes() {
        return listOfProgamLevelTypes;
    }
    
    public void setListOfProgamLevelTypes(List listOfProgamLevelTypes) {
        this.listOfProgamLevelTypes = listOfProgamLevelTypes;
    }
    
    
    
    public Long getAppliedProgramLevelTypeId() {
        return appliedProgramLevelTypeId;
    }
    
    public void setAppliedProgramLevelTypeId(Long appliedProgramLevelTypeId) {
        this.appliedProgramLevelTypeId = appliedProgramLevelTypeId;
    }
    
    public Long getGraduatedProgramLevelTypeId() {
        return graduatedProgramLevelTypeId;
    }
    
    public void setGraduatedProgramLevelTypeId(Long graduatedProgramLevelTypeId) {
        this.graduatedProgramLevelTypeId = graduatedProgramLevelTypeId;
    }
    
    
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
    
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    public List getGenderTypeList() {
        return genderTypeList;
    }
    
    public void setGenderTypeList(List genderTypeList) {
        this.genderTypeList = genderTypeList;
    }

    public List getStudentEnrollmetList() {
        return studentEnrollmetList;
    }

    public void setStudentEnrollmetList(List studentEnrollmetList) {
        this.studentEnrollmetList = studentEnrollmetList;
    }

    public String getEnrollmentStatusType() {
        return enrollmentStatusType;
    }

    public void setEnrollmentStatusType(String enrollmentStatusType) {
        this.enrollmentStatusType = enrollmentStatusType;
    }

    public List getEnrollmentStatusTypeList() {
        return enrollmentStatusTypeList;
    }

    public void setEnrollmentStatusTypeList(List enrollmentStatusTypeList) {
        this.enrollmentStatusTypeList = enrollmentStatusTypeList;
    }
    
    
    public void resetForm() {
        dateEnrolled = null;
        grade = null;
        id = 0l;
        studentEnrollmetList=null;
        graduatedProgramLevelTypeId=null;
        appliedProgramLevelTypeId=null;
        listOfProgamLevelTypes=null;
        
    }
}
