package org.edu.uams.client.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author SARAT
 */
public class StudentForm extends ActionForm {

    private Long admnNum;
    private String rollNum;
    private String studentName;
    private String branchName;
    private Short sem;
    private long photo;
    private String path;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Short getSem() {
        return sem;
    }

    public void setSem(Short sem) {
        this.sem = sem;
    }

    public long getPhoto() {
        return photo;
    }

    public void setPhoto(long photo) {
        this.photo = photo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        studentName = null;
        branchName = null;
        sem = null;
        photo = 0L;
        path = null;
        pageName =null;
    }

}
