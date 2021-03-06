/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.edu.uams.server.api.EnrollmentStatusType;
import org.edu.uams.server.api.GenderType;


@Entity(name = "StudentEnrollment")
@Table(name = "student_enrollment")
public class StudentEnrollmentEntity implements Serializable {
    
    public static final String FIND_ALL="SELECT s FROM StudentEnrollment s order  by s.grade desc, s.dateEnrolled";
    public static final String GET_LASTEST_ID="SELECT s.id FROM StudentEnrollment s order by s.id desc";
    public static String FIND_BY_STUDENT_ENROLLMENT_NUMBER="SELECT s FROM StudentEnrollment s where s.enrollmentNumber = :enrollmentNumber";
    public static String FIND_BY_APPLIED_COURSE_ID="SELECT s FROM StudentEnrollment s join s.appliedCourseType c where c.id = :courseId order by s.grade desc, s.dateEnrolled";
    public static String FIND_BY_STATUS="SELECT s FROM StudentEnrollment s  where s.enrollmentStatusType = :enrollmentStatusType order by s.grade desc, s.dateEnrolled";
    public static String FIND_BY_APPLIED_COURSE_STATUS="SELECT s FROM StudentEnrollment s join s.appliedCourseType c where s.enrollmentStatusType = :enrollmentStatusType and c.id = :courseId order by s.grade desc, s.dateEnrolled";
    
    private static final long serialVersionUID = 1L;
    
    
    
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    
    
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
    
    
    @Basic(optional = false)
    @Column(name = "gender_type", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    
    @Basic(optional = false)
    @Column(name = "enrollment_status_type", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnrollmentStatusType enrollmentStatusType;
    
    
    @Basic(optional = true)
    @Column(name = "student_mob",nullable = true)
    private long studentMob;
    
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    
    @ManyToOne(optional = false, targetEntity = CourseTypeEntity.class)
    @JoinColumn(name = "applied_course_type_id", referencedColumnName = "id", nullable = false)
    private CourseTypeEntity appliedCourseType;
    
    @ManyToOne(optional = false, targetEntity = CourseTypeEntity.class)
    @JoinColumn(name = "attend_course_type_id", referencedColumnName = "id", nullable = false)
    private CourseTypeEntity lastGraduatedCourseType;
    
    
    @ManyToOne(optional = false, targetEntity = ProgramLevelTypeEntity.class)
    @JoinColumn(name = "applied_degree_type_id", referencedColumnName = "id", nullable = false)
    private ProgramLevelTypeEntity appliedProgramLevelType;
    
    
    @ManyToOne(optional = false, targetEntity = ProgramLevelTypeEntity.class)
    @JoinColumn(name = "attend_degree_type_id", referencedColumnName = "id", nullable = true)
    private ProgramLevelTypeEntity lastGraduatedProgramLevelType;
    
    @Basic(optional = false)
    @Column(name = "date_enrolled", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnrolled;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grade", precision = 17, scale = 17)
    private Double grade;
    
    @Basic(optional = false)
    @Column(name = "enrollment_number",unique = true,nullable = false)
    private String enrollmentNumber;
    
    
    @Basic(optional = false)
    @Column(name = "has_admitted")
    private boolean hasAdmitted;
    
    public StudentEnrollmentEntity() {
    }
    
    public StudentEnrollmentEntity(Long id) {
        this.id = id;
    }
    
    public StudentEnrollmentEntity(Long id, Date dateEnrolled) {
        this.id = id;
        this.dateEnrolled = dateEnrolled;
    }
    
    public Date getDateEnrolled() {
        return dateEnrolled;
    }
    
    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }
    
    public Double getGrade() {
        return grade;
    }
    
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    public long getId() {
        return id;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public CourseTypeEntity getAppliedCourseType() {
        return appliedCourseType;
    }
    
    public void setAppliedCourseType(CourseTypeEntity appliedCourseType) {
        this.appliedCourseType = appliedCourseType;
    }
    
    public CourseTypeEntity getLastGraduatedCourseType() {
        return lastGraduatedCourseType;
    }
    
    public void setLastGraduatedCourseType(CourseTypeEntity lastGraduatedCourseType) {
        this.lastGraduatedCourseType = lastGraduatedCourseType;
    }
    
    public ProgramLevelTypeEntity getLastGraduatedProgramLevelType() {
        return lastGraduatedProgramLevelType;
    }
    
    public void setLastGraduatedProgramLevelType(ProgramLevelTypeEntity lastGraduatedProgramLevelType) {
        this.lastGraduatedProgramLevelType = lastGraduatedProgramLevelType;
    }
    
    public ProgramLevelTypeEntity getAppliedProgramLevelType() {
        return appliedProgramLevelType;
    }
    
    public void setAppliedProgramLevelType(ProgramLevelTypeEntity appliedProgramLevelType) {
        this.appliedProgramLevelType = appliedProgramLevelType;
    }
    
    
    
    
    
    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }
    
    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
    
    public EnrollmentStatusType getEnrollmentStatusType() {
        return enrollmentStatusType;
    }
    
    public void setEnrollmentStatusType(EnrollmentStatusType enrollmentStatusType) {
        this.enrollmentStatusType = enrollmentStatusType;
    }

    public boolean isHasAdmitted() {
        return hasAdmitted;
    }

    public void setHasAdmitted(boolean hasAdmitted) {
        this.hasAdmitted = hasAdmitted;
    }
    
    
    
}
