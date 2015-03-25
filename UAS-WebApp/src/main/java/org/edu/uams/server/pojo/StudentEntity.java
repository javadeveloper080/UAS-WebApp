
package org.edu.uams.server.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentEntity.findAll", query = "SELECT s FROM StudentEntity s"),
    @NamedQuery(name = "StudentEntity.findByAdmnNum", query = "SELECT s FROM StudentEntity s WHERE s.admnNum = :admnNum"),
    @NamedQuery(name = "StudentEntity.findByRollNum", query = "SELECT s FROM StudentEntity s WHERE s.rollNum = :rollNum"),
    @NamedQuery(name = "StudentEntity.findByStudentName", query = "SELECT s FROM StudentEntity s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "StudentEntity.findByBranchName", query = "SELECT s FROM StudentEntity s WHERE s.branchName = :branchName"),
    @NamedQuery(name = "StudentEntity.findBySem", query = "SELECT s FROM StudentEntity s WHERE s.sem = :sem"),
    @NamedQuery(name = "StudentEntity.findByPhoto", query = "SELECT s FROM StudentEntity s WHERE s.photo = :photo"),
    @NamedQuery(name = "StudentEntity.findByPath", query = "SELECT s FROM StudentEntity s WHERE s.path = :path")})
public class StudentEntity implements Serializable {
    
    public static final String FIND_ALL="StudentEntity.findAll";
    
    private static final long serialVersionUID = 1L;
    @Column(name = "admn_num")
    private Long admnNum;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_num")
    private String rollNum;
    @Column(name = "student_name")
    private String studentName;
    @Basic(optional = false)
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "sem")
    private Short sem;
    @Basic(optional = false)
    @Column(name = "photo")
    private long photo;
    @Column(name = "path")
    private String path;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollNum")
    private Collection<StudentOtherDetailsEntity> studentOtherDetailsTabCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollNum")
    private Collection<StudentFeeEntity> studentFeeTabCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollNum")
    private Collection<StudentPersonalDetailsEntity> studentPersonalDetailsTabCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentDegreequalificationDetailsEntity studentDegreequalificationDetailsTab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentCorrAddressDetailsEntity studentCorrAddressDetailsTab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentDiplomaqualificationDetailsEntity studentDiplomaqualificationDetailsTab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentPermAddressDetailsEntity studentPermAddressDetailsTab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentSscqualificationDetailsEntity studentSscqualificationDetailsTab;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentTab")
    private StudentInterqualificationDetailsEntity studentInterqualificationDetailsTab;

    public StudentEntity() {
    }

    public StudentEntity(String rollNum) {
        this.rollNum = rollNum;
    }

    public StudentEntity(String rollNum, String branchName, long photo) {
        this.rollNum = rollNum;
        this.branchName = branchName;
        this.photo = photo;
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

    @XmlTransient
    public Collection<StudentOtherDetailsEntity> getStudentOtherDetailsTabCollection() {
        return studentOtherDetailsTabCollection;
    }

    public void setStudentOtherDetailsTabCollection(Collection<StudentOtherDetailsEntity> studentOtherDetailsTabCollection) {
        this.studentOtherDetailsTabCollection = studentOtherDetailsTabCollection;
    }

    @XmlTransient
    public Collection<StudentFeeEntity> getStudentFeeTabCollection() {
        return studentFeeTabCollection;
    }

    public void setStudentFeeTabCollection(Collection<StudentFeeEntity> studentFeeTabCollection) {
        this.studentFeeTabCollection = studentFeeTabCollection;
    }

    @XmlTransient
    public Collection<StudentPersonalDetailsEntity> getStudentPersonalDetailsTabCollection() {
        return studentPersonalDetailsTabCollection;
    }

    public void setStudentPersonalDetailsTabCollection(Collection<StudentPersonalDetailsEntity> studentPersonalDetailsTabCollection) {
        this.studentPersonalDetailsTabCollection = studentPersonalDetailsTabCollection;
    }

    public StudentDegreequalificationDetailsEntity getStudentDegreequalificationDetailsTab() {
        return studentDegreequalificationDetailsTab;
    }

    public void setStudentDegreequalificationDetailsTab(StudentDegreequalificationDetailsEntity studentDegreequalificationDetailsTab) {
        this.studentDegreequalificationDetailsTab = studentDegreequalificationDetailsTab;
    }

    public StudentCorrAddressDetailsEntity getStudentCorrAddressDetailsTab() {
        return studentCorrAddressDetailsTab;
    }

    public void setStudentCorrAddressDetailsTab(StudentCorrAddressDetailsEntity studentCorrAddressDetailsTab) {
        this.studentCorrAddressDetailsTab = studentCorrAddressDetailsTab;
    }

    public StudentDiplomaqualificationDetailsEntity getStudentDiplomaqualificationDetailsTab() {
        return studentDiplomaqualificationDetailsTab;
    }

    public void setStudentDiplomaqualificationDetailsTab(StudentDiplomaqualificationDetailsEntity studentDiplomaqualificationDetailsTab) {
        this.studentDiplomaqualificationDetailsTab = studentDiplomaqualificationDetailsTab;
    }

    public StudentPermAddressDetailsEntity getStudentPermAddressDetailsTab() {
        return studentPermAddressDetailsTab;
    }

    public void setStudentPermAddressDetailsTab(StudentPermAddressDetailsEntity studentPermAddressDetailsTab) {
        this.studentPermAddressDetailsTab = studentPermAddressDetailsTab;
    }

    public StudentSscqualificationDetailsEntity getStudentSscqualificationDetailsTab() {
        return studentSscqualificationDetailsTab;
    }

    public void setStudentSscqualificationDetailsTab(StudentSscqualificationDetailsEntity studentSscqualificationDetailsTab) {
        this.studentSscqualificationDetailsTab = studentSscqualificationDetailsTab;
    }

    public StudentInterqualificationDetailsEntity getStudentInterqualificationDetailsTab() {
        return studentInterqualificationDetailsTab;
    }

    public void setStudentInterqualificationDetailsTab(StudentInterqualificationDetailsEntity studentInterqualificationDetailsTab) {
        this.studentInterqualificationDetailsTab = studentInterqualificationDetailsTab;
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
        if (!(object instanceof StudentEntity)) {
            return false;
        }
        StudentEntity other = (StudentEntity) object;
        if ((this.rollNum == null && other.rollNum != null) || (this.rollNum != null && !this.rollNum.equals(other.rollNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentEntity[ rollNum=" + rollNum + " ]";
    }
    
}
