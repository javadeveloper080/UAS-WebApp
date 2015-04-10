

package org.edu.uams.client.form;

import org.edu.uams.server.pojo.*;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Mohammed.Tauseef
 */
public class StudentQualificationForm extends ActionForm{
    
    private long id;
    
    
    private String degNameInstitution;
    
    private String degMedium;
    
    private String degDivision;
    
    private Double degPercentage;
    
    private Integer degYearOfPass;
    
    private String dipNameInstitution;
    
    private String dipMedium;
    
    private String dipDivision;
    
    private Double dipPercentage;
    
    private Integer dipYearOfPass;
    
    private String intrInstitutionName;
    
    private String intrMedium;
    
    private String intrDivision;
    
    
    private Double intrPercentage;
    
    private Integer intrYearOfPass;
 
    private String secondaryInstitutionName;
    
    private String sMedium;
    
    private String sdivision;
    
    private Double spercentage;
    
    private Integer syearOfPass;
    
    private String pageName;
    
    private long studentId;
    
    private List<StudentEntity> listOfStudents;
    
    private List<StudentQualificationEntity> listOfStudentQlfs;
    
    public StudentQualificationForm() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDegNameInstitution() {
        return degNameInstitution;
    }

    public void setDegNameInstitution(String degNameInstitution) {
        this.degNameInstitution = degNameInstitution;
    }

    public String getDegMedium() {
        return degMedium;
    }

    public void setDegMedium(String degMedium) {
        this.degMedium = degMedium;
    }

    public String getDegDivision() {
        return degDivision;
    }

    public void setDegDivision(String degDivision) {
        this.degDivision = degDivision;
    }

    public Double getDegPercentage() {
        return degPercentage;
    }

    public void setDegPercentage(Double degPercentage) {
        this.degPercentage = degPercentage;
    }

    public Integer getDegYearOfPass() {
        return degYearOfPass;
    }

    public void setDegYearOfPass(Integer degYearOfPass) {
        this.degYearOfPass = degYearOfPass;
    }

    public String getDipNameInstitution() {
        return dipNameInstitution;
    }

    public void setDipNameInstitution(String dipNameInstitution) {
        this.dipNameInstitution = dipNameInstitution;
    }

    public String getDipMedium() {
        return dipMedium;
    }

    public void setDipMedium(String dipMedium) {
        this.dipMedium = dipMedium;
    }

    public String getDipDivision() {
        return dipDivision;
    }

    public void setDipDivision(String dipDivision) {
        this.dipDivision = dipDivision;
    }

    public Double getDipPercentage() {
        return dipPercentage;
    }

    public void setDipPercentage(Double dipPercentage) {
        this.dipPercentage = dipPercentage;
    }

    public Integer getDipYearOfPass() {
        return dipYearOfPass;
    }

    public void setDipYearOfPass(Integer dipYearOfPass) {
        this.dipYearOfPass = dipYearOfPass;
    }

    public String getIntrInstitutionName() {
        return intrInstitutionName;
    }

    public void setIntrInstitutionName(String intrInstitutionName) {
        this.intrInstitutionName = intrInstitutionName;
    }

    public String getIntrMedium() {
        return intrMedium;
    }

    public void setIntrMedium(String intrMedium) {
        this.intrMedium = intrMedium;
    }

    public String getIntrDivision() {
        return intrDivision;
    }

    public void setIntrDivision(String intrDivision) {
        this.intrDivision = intrDivision;
    }

    public Double getIntrPercentage() {
        return intrPercentage;
    }

    public void setIntrPercentage(Double intrPercentage) {
        this.intrPercentage = intrPercentage;
    }

    public Integer getIntrYearOfPass() {
        return intrYearOfPass;
    }

    public void setIntrYearOfPass(Integer intrYearOfPass) {
        this.intrYearOfPass = intrYearOfPass;
    }

    public String getSecondaryInstitutionName() {
        return secondaryInstitutionName;
    }

    public void setSecondaryInstitutionName(String secondaryInstitutionName) {
        this.secondaryInstitutionName = secondaryInstitutionName;
    }

    public String getsMedium() {
        return sMedium;
    }

    public void setsMedium(String sMedium) {
        this.sMedium = sMedium;
    }

    public String getSdivision() {
        return sdivision;
    }

    public void setSdivision(String sdivision) {
        this.sdivision = sdivision;
    }

    public Double getSpercentage() {
        return spercentage;
    }

    public void setSpercentage(Double spercentage) {
        this.spercentage = spercentage;
    }

    public Integer getSyearOfPass() {
        return syearOfPass;
    }

    public void setSyearOfPass(Integer syearOfPass) {
        this.syearOfPass = syearOfPass;
    }

    public List<StudentEntity> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<StudentEntity> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<StudentQualificationEntity> getListOfStudentQlfs() {
        return listOfStudentQlfs;
    }

    public void setListOfStudentQlfs(List<StudentQualificationEntity> listOfStudentQlfs) {
        this.listOfStudentQlfs = listOfStudentQlfs;
    }

    
}
