package org.edu.uams.client.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author SARAT
 */
public class StudentEnrollmentForm extends ActionForm {

    private Long studentId;
    private Long courseId;
    private String dateEnrolled;
    private Double grade;
    private Long id;
    private String pageName;
    private String searchText;
    private String rollNum;
    private String studentFullName;
    private List listOfCourses;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public List getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
      
    
    public void resetForm() {
        studentId = null;
        courseId = null;
        dateEnrolled = null;
        grade = null;
        id = null;
    }
}
