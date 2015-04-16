package org.edu.uams.client.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.StudentFeeForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentFeeDao;
import org.edu.uams.server.pojo.FeeTypeEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.StudentFeeEntity;

/**
 *
 * @author SARAT
 */
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
    public ActionForward studentFeePage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final StudentFeeForm studentFeeForm = (StudentFeeForm) form;

        StudentFeeDao studentFeeDao = new StudentFeeDao();
        StudentDao studentDao = new StudentDao();
        FeeTypeDao feeTypeDao = new FeeTypeDao();

        StudentEntity studentEntity = null;
        StudentFeeEntity studentFeeEntity = null;
        FeeTypeEntity feeTypeEntity = null;
        
        if (studentFeeForm.getSearchText()!=null) {
            studentEntity = studentDao.findByStudentRollNumber(studentFeeForm.getSearchText());
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
        }else
        {
            if (studentFeeEntity != null) {
                copyDataFromSQFormToSQEntity(studentFeeForm, studentFeeEntity, false, studentDao, feeTypeDao);
            }
        }
        List<StudentEntity> studentList = studentDao.findAll();
        List<FeeTypeEntity> feeTypeList = feeTypeDao.findAll();
        List<StudentFeeEntity> studentFeeList = studentFeeDao.findAll();
        if(feeTypeList != null){
        studentFeeForm.setFeeTypeEntitys(feeTypeList);}
        if(studentList != null){
        studentFeeForm.setStudentEntitys(studentList);}
        if(studentFeeList != null){
        studentFeeForm.setStudentFeeEntitys(studentFeeList);}

        request.setAttribute("studentModule", "true");
        request.setAttribute("studentFee", "true");
        return mapping.findForward("studentFeePage");
    }

    private void copyDataFromSQFormToSQEntity(StudentFeeForm studentFeeForm, StudentFeeEntity studentFeeEntity, boolean isEntity, StudentDao studentDao, FeeTypeDao feeTypeDao) {

        if (isEntity) {
            studentFeeEntity.setDiscountType(studentFeeForm.getDiscountType());
            studentFeeEntity.setFeeName(studentFeeForm.getFeeName());
            studentFeeEntity.setFeePaymentDate(studentFeeForm.getFeePaymentDate());

            studentFeeEntity.setFeeTypeEntity(feeTypeDao.findByPrimaryKey(studentFeeForm.getStudentId()));
            studentFeeEntity.setId(studentFeeForm.getId());

            studentFeeEntity.setStudent(studentDao.findByPrimaryKey(studentFeeForm.getStudentId()));
            studentFeeEntity.setTotalAmount(studentFeeForm.getTotalAmount());

        } else {
            studentFeeForm.setDiscountType(studentFeeEntity.getDiscountType());
            studentFeeForm.setFeeName(studentFeeEntity.getFeeName());
            studentFeeForm.setFeePaymentDate(studentFeeEntity.getFeePaymentDate());

            studentFeeForm.setFeeTypeId(studentFeeEntity.getFeeTypeEntity().getId());
            studentFeeForm.setId(studentFeeEntity.getId());

            studentFeeForm.setStudentId(studentFeeEntity.getStudent().getId());
            studentFeeForm.setStudentName(studentFeeEntity.getStudent().getStudentFullName());
            studentFeeForm.setRollNum(studentFeeEntity.getStudent().getRollNum());
            studentFeeForm.setTotalAmount(studentFeeEntity.getTotalAmount());

        }
    }
}
