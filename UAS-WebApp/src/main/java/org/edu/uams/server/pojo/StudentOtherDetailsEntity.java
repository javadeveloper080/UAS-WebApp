

package org.edu.uams.server.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity
@Table(name = "student_other_details_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentOtherDetailsEntity.findAll", query = "SELECT s FROM StudentOtherDetailsEntity s"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByNationality", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.nationality = :nationality"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByMotherLang", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.motherLang = :motherLang"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByMole1", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.mole1 = :mole1"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByMole2", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.mole2 = :mole2"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByCaste", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.caste = :caste"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByReligionName", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.religionName = :religionName"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByBloodGroup", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.bloodGroup = :bloodGroup"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findBySaccountNum", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.saccountNum = :saccountNum"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findBySbankName", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.sbankName = :sbankName"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findBySbranch", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.sbranch = :sbranch"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByDobCerti", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.dobCerti = :dobCerti"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByHallticketeei", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.hallticketeei = :hallticketeei"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByInterMom", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.interMom = :interMom"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByRankcardeei", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.rankcardeei = :rankcardeei"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findBySsc", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.ssc = :ssc"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByStudyCerti", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.studyCerti = :studyCerti"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByCasteCerti", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.casteCerti = :casteCerti"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findByTc", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.tc = :tc"),
    @NamedQuery(name = "StudentOtherDetailsEntity.findById", query = "SELECT s FROM StudentOtherDetailsEntity s WHERE s.id = :id")})
public class StudentOtherDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "mother_lang")
    private String motherLang;
    @Column(name = "mole1")
    private String mole1;
    @Column(name = "mole2")
    private String mole2;
    @Column(name = "caste")
    private String caste;
    @Column(name = "religion_name")
    private String religionName;
    @Column(name = "blood_group")
    private String bloodGroup;
    @Column(name = "saccount_num")
    private String saccountNum;
    @Column(name = "sbank_name")
    private String sbankName;
    @Column(name = "sbranch")
    private String sbranch;
    @Column(name = "dob_certi")
    private String dobCerti;
    @Column(name = "hallticketeei")
    private String hallticketeei;
    @Column(name = "inter_mom")
    private String interMom;
    @Column(name = "rankcardeei")
    private String rankcardeei;
    @Column(name = "ssc")
    private String ssc;
    @Column(name = "study_certi")
    private String studyCerti;
    @Column(name = "caste_certi")
    private String casteCerti;
    @Column(name = "tc")
    private String tc;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "roll_num", referencedColumnName = "roll_num")
    @ManyToOne(optional = false)
    private StudentEntity rollNum;

    public StudentOtherDetailsEntity() {
    }

    public StudentOtherDetailsEntity(Long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMotherLang() {
        return motherLang;
    }

    public void setMotherLang(String motherLang) {
        this.motherLang = motherLang;
    }

    public String getMole1() {
        return mole1;
    }

    public void setMole1(String mole1) {
        this.mole1 = mole1;
    }

    public String getMole2() {
        return mole2;
    }

    public void setMole2(String mole2) {
        this.mole2 = mole2;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getSaccountNum() {
        return saccountNum;
    }

    public void setSaccountNum(String saccountNum) {
        this.saccountNum = saccountNum;
    }

    public String getSbankName() {
        return sbankName;
    }

    public void setSbankName(String sbankName) {
        this.sbankName = sbankName;
    }

    public String getSbranch() {
        return sbranch;
    }

    public void setSbranch(String sbranch) {
        this.sbranch = sbranch;
    }

    public String getDobCerti() {
        return dobCerti;
    }

    public void setDobCerti(String dobCerti) {
        this.dobCerti = dobCerti;
    }

    public String getHallticketeei() {
        return hallticketeei;
    }

    public void setHallticketeei(String hallticketeei) {
        this.hallticketeei = hallticketeei;
    }

    public String getInterMom() {
        return interMom;
    }

    public void setInterMom(String interMom) {
        this.interMom = interMom;
    }

    public String getRankcardeei() {
        return rankcardeei;
    }

    public void setRankcardeei(String rankcardeei) {
        this.rankcardeei = rankcardeei;
    }

    public String getSsc() {
        return ssc;
    }

    public void setSsc(String ssc) {
        this.ssc = ssc;
    }

    public String getStudyCerti() {
        return studyCerti;
    }

    public void setStudyCerti(String studyCerti) {
        this.studyCerti = studyCerti;
    }

    public String getCasteCerti() {
        return casteCerti;
    }

    public void setCasteCerti(String casteCerti) {
        this.casteCerti = casteCerti;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getRollNum() {
        return rollNum;
    }

    public void setRollNum(StudentEntity rollNum) {
        this.rollNum = rollNum;
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
        if (!(object instanceof StudentOtherDetailsEntity)) {
            return false;
        }
        StudentOtherDetailsEntity other = (StudentOtherDetailsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentOtherDetailsEntity[ id=" + id + " ]";
    }
    
}
