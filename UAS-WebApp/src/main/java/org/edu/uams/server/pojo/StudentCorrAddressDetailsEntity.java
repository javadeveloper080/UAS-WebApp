

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
@Table(name = "student_corr_address_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findAll", query = "SELECT s FROM StudentCorrAddressDetailsEntity s"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByRollNum", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.rollNum = :rollNum"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByDoorNum", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.doorNum = :doorNum"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByStreetName", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.streetName = :streetName"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByAreaName", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.areaName = :areaName"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByDistrictName", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.districtName = :districtName"),
    @NamedQuery(name = "StudentCorrAddressDetailsEntity.findByPin", query = "SELECT s FROM StudentCorrAddressDetailsEntity s WHERE s.pin = :pin")})
public class StudentCorrAddressDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_num")
    private String rollNum;
    @Column(name = "door_num")
    private String doorNum;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "area_name")
    private String areaName;
    @Column(name = "district_name")
    private String districtName;
    @Column(name = "pin")
    private Long pin;
    @JoinColumn(name = "roll_num", referencedColumnName = "roll_num", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentEntity studentTab;

    public StudentCorrAddressDetailsEntity() {
    }

    public StudentCorrAddressDetailsEntity(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
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
        if (!(object instanceof StudentCorrAddressDetailsEntity)) {
            return false;
        }
        StudentCorrAddressDetailsEntity other = (StudentCorrAddressDetailsEntity) object;
        if ((this.rollNum == null && other.rollNum != null) || (this.rollNum != null && !this.rollNum.equals(other.rollNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentCorrAddressDetailsEntity[ rollNum=" + rollNum + " ]";
    }
    
}
