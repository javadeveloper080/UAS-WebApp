/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.edu.uams.client.form;

import java.util.List;



public class StudentFeeForm extends org.apache.struts.action.ActionForm {
    
    private Long id = 0l;
    private String serial;
    private String feePaymentDate;
    private String discountType;
    private String rollNum;
    private String pageName;
    private List studentFeeList;
    private List feeTypeList;
    private Long studentId;
    private Long feeTypeId;
    private String studentName;
    private String  searchText;
    
    private Double paidAmount;
    private Double balanceAmount;
    
    
    private String paymentType;
    private List paymentTypeList;
    
    /**
     *
     */
    public StudentFeeForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String getSearchText() {
        return searchText;
    }
    
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public Long getFeeTypeId() {
        return feeTypeId;
    }
    
    public void setFeeTypeId(Long feeTypeId) {
        this.feeTypeId = feeTypeId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getSerial() {
        return serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    
    
    public String getFeePaymentDate() {
        return feePaymentDate;
    }
    
    public void setFeePaymentDate(String feePaymentDate) {
        this.feePaymentDate = feePaymentDate;
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
    
    public List getStudentFeeList() {
        return studentFeeList;
    }
    
    public void setStudentFeeList(List studentFeeList) {
        this.studentFeeList = studentFeeList;
    }
    
    public List getFeeTypeList() {
        return feeTypeList;
    }
    
    public void setFeeTypeList(List feeTypeList) {
        this.feeTypeList = feeTypeList;
    }
    
    public Double getPaidAmount() {
        return paidAmount;
    }
    
    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
    
    public Double getBalanceAmount() {
        return balanceAmount;
    }
    
    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(List paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }
    
    public void resetform() {
        this.id = 0l;
        this.serial = null;
        this.feePaymentDate = null;
        this.discountType = null;
        this.rollNum = null;
        this.pageName = null;
        this.feeTypeList = null;
        this.studentId = 0l;
        this.feeTypeId = 0l;
        this.studentName = null;
        this.searchText = null;
        this.paidAmount = 0.0;
        this.studentFeeList = null;
        this.balanceAmount = 0.0;
        
        this.paymentType= null;
        this.paymentTypeList= null;
        
    }
    
    
    
}
