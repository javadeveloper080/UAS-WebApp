
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
@Table(name = "student_perm_address_details_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findAll", query = "SELECT s FROM StudentPermAddressDetailsEntity s"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByRollNum", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.rollNum = :rollNum"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByPdoorNum", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.pdoorNum = :pdoorNum"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByPstreetName", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.pstreetName = :pstreetName"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByPareaName", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.pareaName = :pareaName"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByPdistrictName", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.pdistrictName = :pdistrictName"),
    @NamedQuery(name = "StudentPermAddressDetailsEntity.findByPpin", query = "SELECT s FROM StudentPermAddressDetailsEntity s WHERE s.ppin = :ppin")})
public class StudentPermAddressDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_num")
    private String rollNum;
    @Column(name = "pdoor_num")
    private String pdoorNum;
    @Column(name = "pstreet_name")
    private String pstreetName;
    @Column(name = "parea_name")
    private String pareaName;
    @Column(name = "pdistrict_name")
    private String pdistrictName;
    @Column(name = "ppin")
    private Long ppin;
    @JoinColumn(name = "roll_num", referencedColumnName = "roll_num", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentEntity studentTab;

    public StudentPermAddressDetailsEntity() {
    }

    public StudentPermAddressDetailsEntity(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getPdoorNum() {
        return pdoorNum;
    }

    public void setPdoorNum(String pdoorNum) {
        this.pdoorNum = pdoorNum;
    }

    public String getPstreetName() {
        return pstreetName;
    }

    public void setPstreetName(String pstreetName) {
        this.pstreetName = pstreetName;
    }

    public String getPareaName() {
        return pareaName;
    }

    public void setPareaName(String pareaName) {
        this.pareaName = pareaName;
    }

    public String getPdistrictName() {
        return pdistrictName;
    }

    public void setPdistrictName(String pdistrictName) {
        this.pdistrictName = pdistrictName;
    }

    public Long getPpin() {
        return ppin;
    }

    public void setPpin(Long ppin) {
        this.ppin = ppin;
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
        if (!(object instanceof StudentPermAddressDetailsEntity)) {
            return false;
        }
        StudentPermAddressDetailsEntity other = (StudentPermAddressDetailsEntity) object;
        if ((this.rollNum == null && other.rollNum != null) || (this.rollNum != null && !this.rollNum.equals(other.rollNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentPermAddressDetailsEntity[ rollNum=" + rollNum + " ]";
    }
    
}
