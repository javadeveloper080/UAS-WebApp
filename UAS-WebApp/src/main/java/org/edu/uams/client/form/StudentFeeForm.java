/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.client.form;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author SARAT
 */
public class StudentFeeForm extends org.apache.struts.action.ActionForm {

    private String serial;
    private BigDecimal totalAmount;
    private String feePaymentDate;
    private String feeName;
    private String discountType;
    private String rollNum;

    /**
     *
     */
    public StudentFeeForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        serial = null;
        totalAmount = null;
        feePaymentDate = null;
        feeName = null;
        discountType = null;
        rollNum = null;
    }

}
