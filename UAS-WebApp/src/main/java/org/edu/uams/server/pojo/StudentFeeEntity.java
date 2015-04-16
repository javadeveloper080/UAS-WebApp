
package org.edu.uams.server.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "StudentFee")
@Table(name = "student_fee")
public class StudentFeeEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final  String  FIND_ALL ="SELECT sf FROM StudentFee sf";
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
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
    
  
    
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentEntity student;
    
    @JoinColumn(name = "fee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FeeTypeEntity feeTypeEntity;

    public StudentFeeEntity() {
    }

    public StudentFeeEntity(Long id) {
        this.id = id;
    }

    public StudentFeeEntity(Long id, BigDecimal totalAmount, String feePaymentDate, String feeName, String discountType) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.feePaymentDate = feePaymentDate;
        this.feeName = feeName;
        this.discountType = discountType;
    }

    public FeeTypeEntity getFeeTypeEntity() {
        return feeTypeEntity;
    }

    public void setFeeTypeEntity(FeeTypeEntity feeTypeEntity) {
        this.feeTypeEntity = feeTypeEntity;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

}
