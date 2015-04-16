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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SARAT
 */
@Entity(name = "StudentEnrollment")
@Table(name = "student_enrollment")
@NamedQueries({
    @NamedQuery(name = "StudentEnrollment.findAll", query = "SELECT s FROM StudentEnrollment s"),
    @NamedQuery(name = "StudentEnrollment.findById", query = "SELECT s FROM StudentEnrollment s WHERE s.id = :id"),
    @NamedQuery(name = "StudentEnrollment.findByDateEnrolled", query = "SELECT s FROM StudentEnrollment s WHERE s.dateEnrolled = :dateEnrolled"),
    @NamedQuery(name = "StudentEnrollment.findByGrade", query = "SELECT s FROM StudentEnrollment s WHERE s.grade = :grade")})
public class StudentEnrollmentEntity implements Serializable {
    
    public static final String FIND_ALL="StudentEnrollment.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "date_enrolled", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnrolled;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grade", precision = 17, scale = 17)
    private Double grade;
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private StudentEntity studentId;
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CourseMasterEntity courseId;

    public StudentEnrollmentEntity() {
    }

    public StudentEnrollmentEntity(Long id) {
        this.id = id;
    }

    public StudentEnrollmentEntity(Long id, Date dateEnrolled) {
        this.id = id;
        this.dateEnrolled = dateEnrolled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StudentEntity getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentEntity studentId) {
        this.studentId = studentId;
    }

    public CourseMasterEntity getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseMasterEntity courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEnrollmentEntity)) {
            return false;
        }
        StudentEnrollmentEntity other = (StudentEnrollmentEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.server.pojo.StudentEnrollment[ id=" + id + " ]";
    }
    
}
