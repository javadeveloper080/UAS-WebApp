
package org.edu.uams.server.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity
@Table(name = "student_degreequalification_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findAll", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByRollNum", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.rollNum = :rollNum"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByDenameInstitution", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.denameInstitution = :denameInstitution"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByDemedium", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.demedium = :demedium"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByDedivision", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.dedivision = :dedivision"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByDepercentage", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.depercentage = :depercentage"),
    @NamedQuery(name = "StudentDegreequalificationDetailsEntity.findByDeyearOfPass", query = "SELECT s FROM StudentDegreequalificationDetailsEntity s WHERE s.deyearOfPass = :deyearOfPass")})
public class StudentDegreequalificationDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_num")
    private String rollNum;
    @Column(name = "dename_institution")
    private String denameInstitution;
    @Column(name = "demedium")
    private String demedium;
    @Column(name = "dedivision")
    private String dedivision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "depercentage")
    private Double depercentage;
    @Column(name = "deyear_of_pass")
    private Integer deyearOfPass;
    @JoinColumn(name = "roll_num", referencedColumnName = "roll_num", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentEntity studentTab;

    public StudentDegreequalificationDetailsEntity() {
    }

    public StudentDegreequalificationDetailsEntity(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getDenameInstitution() {
        return denameInstitution;
    }

    public void setDenameInstitution(String denameInstitution) {
        this.denameInstitution = denameInstitution;
    }

    public String getDemedium() {
        return demedium;
    }

    public void setDemedium(String demedium) {
        this.demedium = demedium;
    }

    public String getDedivision() {
        return dedivision;
    }

    public void setDedivision(String dedivision) {
        this.dedivision = dedivision;
    }

    public Double getDepercentage() {
        return depercentage;
    }

    public void setDepercentage(Double depercentage) {
        this.depercentage = depercentage;
    }

    public Integer getDeyearOfPass() {
        return deyearOfPass;
    }

    public void setDeyearOfPass(Integer deyearOfPass) {
        this.deyearOfPass = deyearOfPass;
    }

    public StudentEntity getStudentTab() {
        return studentTab;
    }

    public void setStudentTab(StudentEntity studentTab) {
        this.studentTab = studentTab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollNum != null ? rollNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentDegreequalificationDetailsEntity)) {
            return false;
        }
        StudentDegreequalificationDetailsEntity other = (StudentDegreequalificationDetailsEntity) object;
        if ((this.rollNum == null && other.rollNum != null) || (this.rollNum != null && !this.rollNum.equals(other.rollNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentDegreequalificationDetailsEntity[ rollNum=" + rollNum + " ]";
    }
    
}
