

package org.edu.uams.server.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.edu.uams.server.api.HasId;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "StudentQualification")
@Table(name = "student_qualification")
public class StudentQualificationEntity implements HasId {
    
    
    private static final long serialVersionUID = 1L;
    public static final  String  FIND_ALL ="SELECT sq FROM StudentQualification sq";
    public static final  String FIND_BY_STUDENT_ID="SELECT sq FROM StudentQualification sq JOIN sq.student s  where s.id = :studentId";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    
    //Degree Starts
    @Basic(optional = true)
    @Column(name = "deg_name_institution",nullable = true)
    private String degNameInstitution;
    
    @Basic(optional = true)
    @Column(name = "deg_medium",nullable = true)
    private String degMedium;
    
    @Basic(optional = true)
    @Column(name = "deg_division")
    private String degDivision;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = true)
    @Column(name = "deg_percentage")
    private Double degPercentage;
    
    @Basic(optional = true)
    @Column(name = "deg_year_of_pass")
    private Integer degYearOfPass;
    //Degree Ends
    
    //Diploma Starts
    @Basic(optional = true)
    @Column(name = "dip_name_institution",nullable = true)
    private String dipNameInstitution;
    
    @Basic(optional = true)
    @Column(name = "dip_medium",nullable = true)
    private String dipMedium;
    
    @Basic(optional = true)
    @Column(name = "dip_division")
    private String dipDivision;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = true)
    @Column(name = "dip_percentage")
    private Double dipPercentage;
    
    @Basic(optional = true)
    @Column(name = "dip_year_of_pass")
    private Integer dipYearOfPass;
    //Diploma Ends
    
    //HSC means Intermediate/12 class Starts
    @Basic(optional = true)
    @Column(name = "intr_name_institution",nullable = true)
    private String intrInstitutionName;
    
    @Basic(optional = true)
    @Column(name = "intr_medium",nullable = true)
    private String intrMedium;
    
    @Basic(optional = true)
    @Column(name = "intr_division",nullable = true)
    private String intrDivision;
    
    
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "intr_percentage",nullable = true)
    private Double intrPercentage;
    
    @Basic(optional = false)
    @Column(name = "intr_year_of_pass",nullable = true)
    private Integer intrYearOfPass;
    //HSC means Intermediate/12 class Ends.
    
    //SSC = X th = Secondary School Certificate  Starts
    @Basic(optional = true)
    @Column(name = "s_inst_name",length = 200,nullable = true)
    private String secondaryInstitutionName;
    
    @Basic(optional = true)
    @Column(name = "smedium",nullable = true)
    private String sMedium;
    
    @Basic(optional = true)
    @Column(name = "sdivision",nullable = true)
    private String sdivision;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = true)
    @Column(name = "spercentage")
    private Double spercentage;
    
    @Basic(optional = true)
    @Column(name = "syear_of_pass")
    private Integer syearOfPass;
    // SSC = X th = Secondary School Certificate Ends
    
//    @Basic(optional = true)
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    @OneToOne(fetch = FetchType.EAGER)
//    private StudentEntity student;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false )
    private StudentEntity student;
    
    public StudentQualificationEntity() {
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

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
    
    
    
}
