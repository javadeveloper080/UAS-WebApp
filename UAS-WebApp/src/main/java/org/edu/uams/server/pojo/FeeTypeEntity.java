package org.edu.uams.server.pojo;


import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.edu.uams.server.api.Type;


@Entity(name = "FeeType")
@Table(name = "fee_type")
public class FeeTypeEntity implements Type {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    
    public static final  String  FIND_ALL="SELECT f FROM FeeType f";
    public static final  String  FIND_BY_CODE="SELECT f FROM FeeType f where f.code = :code";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "code", unique = true, nullable = false, length = 10)
    private String code;
    
    @Column(name = "description", nullable = false, length =100)
    private String description;
    
    
    @JoinColumn(name = "fee_category_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FeeCategoryTypeEntity feeCategoryTypeEntity;

    @Basic(optional = true)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Basic(optional = true)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Basic(optional = true)
    @Column(name = "amount")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public FeeCategoryTypeEntity getFeeCategoryTypeEntity() {
        return feeCategoryTypeEntity;
    }

    public void setFeeCategoryTypeEntity(FeeCategoryTypeEntity feeCategoryTypeEntity) {
        this.feeCategoryTypeEntity = feeCategoryTypeEntity;
    }

    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
}
