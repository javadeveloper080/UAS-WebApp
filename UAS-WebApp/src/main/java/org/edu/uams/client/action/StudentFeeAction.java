package org.edu.uams.client.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.dto.LabelValueBean;
import org.edu.uams.client.form.StudentFeeForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.PaymentType;
import org.edu.uams.server.api.SeatCategoryType;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentFeeDao;
import org.edu.uams.server.pojo.FeeTypeEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.StudentFeeEntity;


public class StudentFeeAction extends DispatchAction {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward studentFeePage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        final StudentFeeForm studentFeeForm = (StudentFeeForm) form;
        
        StudentFeeDao studentFeeDao = new StudentFeeDao();
        StudentDao studentDao = new StudentDao();
        FeeTypeDao feeTypeDao = new FeeTypeDao();
        
        StudentEntity studentEntity = null;
        StudentFeeEntity studentFeeEntity = null;
        FeeTypeEntity feeTypeEntity = null;
        
        if (studentFeeForm.getSearchText()!=null) {
            studentEntity = studentDao.findByStudentRollNumber(studentFeeForm.getSearchText());
            if(studentEntity != null)
            {
                studentFeeForm.setRollNum(studentEntity.getRollNum());
                studentFeeForm.setStudentName(studentEntity.getStudentFullName());
                studentFeeForm.setStudentId(studentEntity.getId());
            }
        }
        
        if (studentFeeForm.getPageName() != null && studentFeeForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            studentFeeEntity = new StudentFeeEntity();
            copyDataFromSQFormToSQEntity(studentFeeForm, studentFeeEntity, true, studentDao, feeTypeDao);
            studentFeeDao.persist(studentFeeEntity);
        } else if (studentFeeForm.getPageName() != null && studentFeeForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {
            studentFeeEntity = studentFeeDao.findByPrimaryKey(studentFeeForm.getId());
            copyDataFromSQFormToSQEntity(studentFeeForm, studentFeeEntity, true, studentDao, feeTypeDao);
            studentFeeDao.update(studentFeeEntity);
        } else if (studentFeeForm.getPageName() != null && studentFeeForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM)) {
            studentFeeEntity = studentFeeDao.findByPrimaryKey(studentFeeForm.getId());
            if (studentFeeEntity != null) {
                copyDataFromSQFormToSQEntity(studentFeeForm, studentFeeEntity, false, studentDao, feeTypeDao);
            }
        }
        
        studentFeeForm.resetform();
        List<FeeTypeEntity> feeTypeList = feeTypeDao.findAll();
        List<StudentFeeEntity> studentFeeList = studentFeeDao.findAll();
        studentFeeForm.setPaymentTypeList(getPaymentTypeList());
        
        if(feeTypeList != null){
            studentFeeForm.setFeeTypeList(feeTypeList);
        }
        if(studentFeeList != null){
            studentFeeForm.setStudentFeeList(studentFeeList);
        }
        
        request.setAttribute("studentModule", "true");
        request.setAttribute("studentFee", "true");
        return mapping.findForward("studentFeePage");
    }
    
    private void copyDataFromSQFormToSQEntity(StudentFeeForm studentFeeForm, StudentFeeEntity studentFeeEntity, boolean isEntity, StudentDao studentDao, FeeTypeDao feeTypeDao) {
        
        if (isEntity) {
            studentFeeEntity.setDiscountType(studentFeeForm.getDiscountType());
            studentFeeEntity.setFeePaymentDate(studentFeeForm.getFeePaymentDate());
            studentFeeEntity.setFeeTypeEntity(feeTypeDao.findByPrimaryKey(studentFeeForm.getFeeTypeId()));
            studentFeeEntity.setStudent(studentDao.findByPrimaryKey(studentFeeForm.getStudentId()));
            studentFeeEntity.setPaidAmount(studentFeeForm.getPaidAmount());
            studentFeeEntity.setBalanceAmount(studentFeeForm.getBalanceAmount());
            studentFeeEntity.setPaymentType(PaymentType.valueOf(studentFeeForm.getPaymentType()));
            
        } else {
            studentFeeForm.setDiscountType(studentFeeEntity.getDiscountType());
            studentFeeForm.setFeePaymentDate(studentFeeEntity.getFeePaymentDate());
            studentFeeForm.setFeeTypeId(studentFeeEntity.getFeeTypeEntity().getId());
            studentFeeForm.setId(studentFeeEntity.getId());
            studentFeeForm.setStudentId(studentFeeEntity.getStudent().getId());
            studentFeeForm.setStudentName(studentFeeEntity.getStudent().getStudentFullName());
            studentFeeForm.setRollNum(studentFeeEntity.getStudent().getRollNum());
            studentFeeForm.setPaidAmount(studentFeeEntity.getPaidAmount());
            studentFeeForm.setBalanceAmount(studentFeeEntity.getBalanceAmount());
            studentFeeForm.setPaymentType((studentFeeEntity.getPaymentType().name()));
            
        }
    }
    
    private List<LabelValueBean> getPaymentTypeList() {
        List<LabelValueBean> paymentTypeList = new ArrayList<>();
        for (PaymentType paymentType : PaymentType.values()) {
            paymentTypeList.add(new LabelValueBean(paymentType.name(), paymentType.name()));
        }
        return paymentTypeList;
    }
}
