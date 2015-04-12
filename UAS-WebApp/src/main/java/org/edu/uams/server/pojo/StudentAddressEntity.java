

package org.edu.uams.server.pojo;

import java.io.Serializable;
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
import org.edu.uams.server.api.AddressType;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "StudentAddress")
@Table(name = "student_address")
public class StudentAddressEntity implements Serializable {
    
    public static String FIND_ALL="SELECT s FROM StudentAddress s";
    public static String FIND_BY_STUDENT_ID="SELECT sa FROM StudentAddress sa JOIN sa.student s  where s.id = :studentId";
    public static String FIND_BY_STUDENT_ADDRESSTYPE="SELECT sa FROM StudentAddress sa JOIN sa.student s  where s.id = :studentId and sa.addressType=:addressType";
        
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    
    @Basic(optional = false)
    @Column(name = "addr_line_1")
    private String addrLine1;
    
    @Basic(optional = true)
    @Column(name = "addr_line_2")
    private String addrLine2;
    
    @Basic(optional = true)
    @Column(name = "addr_line_3")
    private String addrLine3;
    
    
    @Basic(optional = true)
    @Column(name = "addr_line_4")
    private String addrLine4;
    
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @Column(name = "state_name")
    private String stateName;
    
    @Basic(optional = false)
    @Column(name = "zip_code")
    private String zipCode;
    
    
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false )
    private StudentEntity student;
    
    @Basic(optional = false)
    @Column(name = "address_type", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    
    public StudentAddressEntity() {
    }
    
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getAddrLine1() {
        return addrLine1;
    }
    
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }
    
    public String getAddrLine2() {
        return addrLine2;
    }
    
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }
    
    public String getAddrLine3() {
        return addrLine3;
    }
    
    public void setAddrLine3(String addrLine3) {
        this.addrLine3 = addrLine3;
    }
    
    public String getAddrLine4() {
        return addrLine4;
    }
    
    public void setAddrLine4(String addrLine4) {
        this.addrLine4 = addrLine4;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public StudentEntity getStudent() {
        return student;
    }
    
    public void setStudent(StudentEntity student) {
        this.student = student;
    }
    
    public AddressType getAddressType() {
        return addressType;
    }
    
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
