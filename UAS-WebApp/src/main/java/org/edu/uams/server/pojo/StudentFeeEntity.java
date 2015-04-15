
package org.edu.uams.server.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "student_fee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentFeeEntity.findAll", query = "SELECT s FROM StudentFeeEntity s"),
    @NamedQuery(name = "StudentFeeEntity.findByTotalAmount", query = "SELECT s FROM StudentFeeEntity s WHERE s.totalAmount = :totalAmount"),
    @NamedQuery(name = "StudentFeeEntity.findByFeePaymentDate", query = "SELECT s FROM StudentFeeEntity s WHERE s.feePaymentDate = :feePaymentDate"),
    @NamedQuery(name = "StudentFeeEntity.findByFeeName", query = "SELECT s FROM StudentFeeEntity s WHERE s.feeName = :feeName"),
    @NamedQuery(name = "StudentFeeEntity.findByDiscountType", query = "SELECT s FROM StudentFeeEntity s WHERE s.discountType = :discountType"),
    @NamedQuery(name = "StudentFeeEntity.findBySerial", query = "SELECT s FROM StudentFeeEntity s WHERE s.serial = :serial")})
public class StudentFeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
      @Id
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    
    @Basic(optional = false)
    @Column(name = "fee_payment_date")
    private String feePaymentDate;
    
    
    @Basic(optional = false)
    @Column(name = "fee_name")
    private String feeName;
    
    
    @Basic(optional = false)
    @Column(name = "discount_type")
    private String discountType;
    
    
    
  
    @JoinColumn(name = "fee_category_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FeeCategoryTypeEntity FeeCategoryTypeEntity;
    
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentEntity rollNum;

    public StudentFeeEntity() {
    }

    public StudentFeeEntity(String serial) {
        this.serial = serial;
    }

    public StudentFeeEntity(String serial, BigDecimal totalAmount, String feePaymentDate, String feeName, String discountType) {
        this.serial = serial;
        this.totalAmount = totalAmount;
        this.feePaymentDate = feePaymentDate;
        this.feeName = feeName;
        this.discountType = discountType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFeePaymentDate() {
        return feePaymentDate;
    }

    public void setFeePaymentDate(String feePaymentDate) {
        this.feePaymentDate = feePaymentDate;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentFeeEntity)) {
            return false;
        }
        StudentFeeEntity other = (StudentFeeEntity) object;
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.edu.uams.pojo.StudentFeeEntity[ serial=" + serial + " ]";
    }
    
}
