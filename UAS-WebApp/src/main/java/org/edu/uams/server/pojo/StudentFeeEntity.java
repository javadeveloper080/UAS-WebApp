
package org.edu.uams.server.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    private Double totalAmount;
    
    @Basic(optional = false)
    @Column(name = "fee_payment_date")
    private String feePaymentDate;
    
    @Basic(optional = false)
    @Column(name = "fee_name")
    private String feeName;
    
    @Basic(optional = false)
    @Column(name = "discount_type")
    private String discountType;
    
    @Transient
    private String studentName;
  
    @Transient
    private String rollNum;
    
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

    public StudentFeeEntity(Long id, Double totalAmount, String feePaymentDate, String feeName, String discountType) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.feePaymentDate = feePaymentDate;
        this.feeName = feeName;
        this.discountType = discountType;
    }

    public String getRollNum() {
        if(student != null)
        {
            return student.getRollNum();
        }
        return rollNum;
    }

    public String getStudentName() {
         if(student != null)
        {
            return student.getStudentFullName();
        }
        return studentName;
    }

    

    public FeeTypeEntity getFeeTypeEntity() {
        return feeTypeEntity;
    }

    public void setFeeTypeEntity(FeeTypeEntity feeTypeEntity) {
        this.feeTypeEntity = feeTypeEntity;
    }
    
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

}
