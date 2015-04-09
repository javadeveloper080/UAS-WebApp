
package org.edu.uams.server.pojo;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.edu.uams.server.api.GenderType;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "Student")
@Table(name = "student")
public class StudentEntity implements Serializable {
    
    public static final String FIND_ALL="StudentEntity.findAll";
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Basic(optional = false)
    @Column(name = "admn_num",unique = true,nullable = false)
    private Long admnNum;
    
    
    @Basic(optional = false)
    @Column(name = "roll_num",unique = true,nullable = false)
    private String rollNum;
    
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    
    @Basic(optional = false)
    @Column(name = "father_name", nullable = false, length = 100)
    private String fatherName;
    
    @Basic(optional = false)
    @Column(name = "mother_name", nullable = false, length = 100)
    private String motherName;
    
    @Basic(optional = false)
    @Column(name = "mobile",nullable = false)
    private long mobile;
    
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
    
    
    @Basic(optional = false)
    @Column(name = "gender_type", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
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
    
    public long getMobile() {
        return mobile;
    }
    
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
    
    public Date getDob() {
        return dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public GenderType getGenderType() {
        return genderType;
    }
    
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }
    
}
