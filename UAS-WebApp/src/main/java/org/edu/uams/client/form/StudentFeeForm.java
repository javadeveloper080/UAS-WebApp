/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.client.form;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.edu.uams.server.pojo.FeeTypeEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.StudentFeeEntity;

/**
 *
 * @author SARAT
 */
public class StudentFeeForm extends org.apache.struts.action.ActionForm {

    private Long id;
    private String serial;
    private BigDecimal totalAmount;
    private String feePaymentDate;
    private String feeName;
    private String discountType;
    private String rollNum;
    private String pageName;
    private List<StudentFeeEntity> studentFeeEntitys;
    private List<StudentEntity> studentEntitys;
    private List<FeeTypeEntity> feeTypeEntitys;
    private Long studentId;
    private Long feeTypeId;
    private String studentName;
    private String  searchText;
    
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
    
    public List<StudentFeeEntity> getStudentFeeEntitys() {
        return studentFeeEntitys;
    }

    public void setStudentFeeEntitys(List<StudentFeeEntity> studentFeeEntitys) {
        this.studentFeeEntitys = studentFeeEntitys;
    }

    public List<StudentEntity> getStudentEntitys() {
        return studentEntitys;
    }

    public void setStudentEntitys(List<StudentEntity> studentEntitys) {
        this.studentEntitys = studentEntitys;
    }

    public List<FeeTypeEntity> getFeeTypeEntitys() {
        return feeTypeEntitys;
    }

    public void setFeeTypeEntitys(List<FeeTypeEntity> feeTypeEntitys) {
        this.feeTypeEntitys = feeTypeEntitys;
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
        this.id = null;
        this.serial = null;
        this.feePaymentDate = null;
        this.feeName = null;
        this.discountType = null;
        this.rollNum = null;
        this.pageName = null;
        this.studentFeeEntitys = null;
        this.studentEntitys = null;
        this.feeTypeEntitys = null;
        this.studentId = null;
        this.feeTypeId = null;
        this.studentName = null;
        this.searchText = null;
    }

}
