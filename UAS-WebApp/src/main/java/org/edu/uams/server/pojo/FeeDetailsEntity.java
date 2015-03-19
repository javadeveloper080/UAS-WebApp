/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "FeeDetails")
@Table(name = "fee_details")


public class FeeDetailsEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
       public static final  String  FIND_ALL="SELECT f FROM FeeType f";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    
    @Basic(optional = false)
    @Column(name = "code", unique = true, nullable = false, length = 10)
    private String feeCode;
    
    
    
    @Basic(optional = false)
    @Column(name = "description", unique = true, nullable = false, length = 50)
    private String feeName;
    
    
    @JoinColumn(name = "fee_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FeeTypeEntity feeType;
    
    @JoinColumn(name = "fee_cat", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FeeCategoryTypeEntity feeCategoryType;
    
    
    @Basic(optional = false)
    @Column(name = "admn_type")
    private String admnType;
    

    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orig_amount")
    private BigDecimal origAmount;
    
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    
    public FeeDetailsEntity() {
    }
    
    public FeeDetailsEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public FeeTypeEntity getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeTypeEntity feeType) {
        this.feeType = feeType;
    }

    public FeeCategoryTypeEntity getFeeCategoryType() {
        return feeCategoryType;
    }

    public void setFeeCategoryType(FeeCategoryTypeEntity feeCategoryType) {
        this.feeCategoryType = feeCategoryType;
    }

    public String getAdmnType() {
        return admnType;
    }

    public void setAdmnType(String admnType) {
        this.admnType = admnType;
    }

    

    public BigDecimal getOrigAmount() {
        return origAmount;
    }

    public void setOrigAmount(BigDecimal origAmount) {
        this.origAmount = origAmount;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
    
    
    
}
