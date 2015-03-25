
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
@Table(name = "student_interqualification_details_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findAll", query = "SELECT s FROM StudentInterqualificationDetailsEntity s"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByRollNum", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.rollNum = :rollNum"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByInameInstitution", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.inameInstitution = :inameInstitution"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByImedium", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.imedium = :imedium"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByIdivision", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.idivision = :idivision"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByIpercentage", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.ipercentage = :ipercentage"),
    @NamedQuery(name = "StudentInterqualificationDetailsEntity.findByIyearOfPass", query = "SELECT s FROM StudentInterqualificationDetailsEntity s WHERE s.iyearOfPass = :iyearOfPass")})
public class StudentInterqualificationDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_num")
    private String rollNum;
    @Column(name = "iname_institution")
    private String inameInstitution;
    @Column(name = "imedium")
    private String imedium;
    @Column(name = "idivision")
    private String idivision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ipercentage")
    private Double ipercentage;
    @Column(name = "iyear_of_pass")
    private Integer iyearOfPass;
    @JoinColumn(name = "roll_num", referencedColumnName = "roll_num", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentEntity studentTab;

    public StudentInterqualificationDetailsEntity() {
    }

    public StudentInterqualificationDetailsEntity(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getInameInstitution() {
        return inameInstitution;
    }

    public void setInameInstitution(String inameInstitution) {
        this.inameInstitution = inameInstitution;
    }

    public String getImedium() {
        return imedium;
    }

    public void setImedium(String imedium) {
        this.imedium = imedium;
    }

    public String getIdivision() {
        return idivision;
    }

    public void setIdivision(String idivision) {
        this.idivision = idivision;
    }

    public Double getIpercentage() {
        return ipercentage;
    }

    public void setIpercentage(Double ipercentage) {
        this.ipercentage = ipercentage;
    }

    public Integer getIyearOfPass() {
        return iyearOfPass;
    }

    public void setIyearOfPass(Integer iyearOfPass) {
        this.iyearOfPass = iyearOfPass;
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
        if (!(object instanceof StudentInterqualificationDetailsEntity)) {
            return false;
        }
        StudentInterqualificationDetailsEntity other = (StudentInterqualificationDetailsEntity) object;
        if ((this.rollNum == null && other.rollNum != null) || (this.rollNum != null && !this.rollNum.equals(other.rollNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentInterqualificationDetailsEntity[ rollNum=" + rollNum + " ]";
    }
    
}
