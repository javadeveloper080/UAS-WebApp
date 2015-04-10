
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
import org.edu.uams.server.api.SeatCategoryType;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "Student")
@Table(name = "student")
public class StudentEntity implements Serializable {
    
    public static final String FIND_ALL="SELECT a FROM Student a";
    
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
    
    @Basic(optional = true)
    @Column(name = "student_mob",nullable = true)
    private long studentMob;
    
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
    
    @Basic(optional = false)
    @Column(name = "nationality" ,nullable = false)
    private String nationality;
    
    @Basic(optional = true)
    @Column(name = "father_occup")
    private String fatherOccup;
    
    @Basic(optional = true)
    @Column(name = "mother_occup")
    private String motherOccup;
    
    
    @Basic(optional = true)
    @Column(name = "parent_mob")
    private String parentMob;
    
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    
    @Basic(optional = false)
    @Column(name = "seat_category_type", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatCategoryType seatCategoryType;
    
    
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

    public long getStudentMob() {
        return studentMob;
    }

    public void setStudentMob(long studentMob) {
        this.studentMob = studentMob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SeatCategoryType getSeatCategoryType() {
        return seatCategoryType;
    }

    public void setSeatCategoryType(SeatCategoryType seatCategoryType) {
        this.seatCategoryType = seatCategoryType;
    }
    
    
}
