package org.edu.uams.client.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.dto.LabelValueBean;
import org.edu.uams.client.form.StudentForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.api.SeatCategoryType;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentEnrollmentDAO;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.util.ApplicationUtil;


public class StudentAction extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "student";
    
    public ActionForward studentPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        StudentForm studentForm = (StudentForm) form;
        
        StudentDao studentDao =new StudentDao();
        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        StudentEnrollmentEntity studentEnrollmentEntity=null;
        
        StudentEntity studentEntity =null;
        String statusMessage="";
        
        if (studentForm.getEnrollmentNumSearch()!=null && !studentForm.getEnrollmentNumSearch().isEmpty()) {
            studentEnrollmentEntity = studentEnrollmentDAO.findByStudentEnrollmentNumber(studentForm.getEnrollmentNumSearch());
            studentForm.setEnrollmentNumber(studentEnrollmentEntity.getEnrollmentNumber());
        }
        
        else if (studentForm.getStudentRollNumSearch()!=null && !studentForm.getStudentRollNumSearch().isEmpty()) {
            studentEntity = studentDao.findByStudentRollNumber(studentForm.getStudentRollNumSearch());
            studentEntity =studentDao.findByPrimaryKey(studentEntity.getId());
            studentForm.resetForm();
            studentForm.setRollNum(studentEntity.getRollNum());
            studentForm.setStudentRollNum(studentEntity.getRollNum());
            studentForm.setStudentFullName(studentEntity.getStudentFullName());
            studentForm.setEnrollmentNumber(studentEntity.getStudentEnrollment().getEnrollmentNumber());
            studentForm.setDob(ApplicationUtil.formatDateToString(studentEntity.getDob()));
            studentForm.setFatherName(studentEntity.getFatherName());
            studentForm.setGenderType((studentEntity.getGenderType()).name());
            studentForm.setMotherName(studentEntity.getMotherName());
            studentForm.setFirstName(studentEntity.getFirstName());
            studentForm.setLastName(studentEntity.getLastName());
            studentForm.setId(studentEntity.getId());
            studentForm.setStudentMob(studentEntity.getStudentMob());
            studentForm.setEmail(studentEntity.getEmail());
            studentForm.setParentMob(studentEntity.getParentMob());
            studentForm.setMotherOccup(studentEntity.getMotherOccup());
            studentForm.setFatherOccup(studentEntity.getFatherOccup());
            studentForm.setNationality(studentEntity.getNationality());
            studentForm.setSeatCategoryType((studentEntity.getSeatCategoryType().name()));
        }
        else if (studentForm.getPageName() != null && studentForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            studentEntity =new StudentEntity();
            studentEnrollmentEntity=studentEnrollmentDAO.findByStudentEnrollmentNumber(studentForm.getEnrollmentNumber());
            studentEntity.setStudentEnrollment(studentEnrollmentEntity);
            int year = Calendar.getInstance().get(Calendar.YEAR);
            copyDataFromFormToEntity(studentForm, studentEntity);
            studentEntity.setRollNum(studentEnrollmentEntity.getEnrollmentNumber()+"-"+year);
            StudentEntity persisted= studentDao.persist(studentEntity);
            studentEnrollmentEntity.setHasAdmitted(Boolean.TRUE);
            studentEnrollmentDAO.update(studentEnrollmentEntity);
            if (persisted!=null) {
                statusMessage=ApplicationConstants.PROFILE_ADDED_SUCESSFULLY +" For the Roll Number :"+persisted.getRollNum();
            }
             studentForm.resetForm();
        }else if (studentForm.getPageName() != null && studentForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {
            studentEntity =studentDao.findByPrimaryKey(studentForm.getId());
            copyDataFromFormToEntity(studentForm, studentEntity);
            StudentEntity updated = studentDao.update(studentEntity);
            if (updated!=null) {
                statusMessage=ApplicationConstants.PROFILE_UDPATED_SUCESSFULLY +" For the Roll Number :"+updated.getRollNum();
            }
             studentForm.resetForm();
        }
        
         
        studentForm.setStatusMessage(statusMessage);
        studentForm.setGenderTypeList(getGenderTypeList());
        studentForm.setSeatCategoryTypeList(getSeatCategoryTypeList());
        
        request.setAttribute("studentModule", "true");
        request.setAttribute("studentDetails", "true");
        return mapping.findForward(SUCCESS);
    }
    private void copyDataFromFormToEntity(StudentForm studentForm,StudentEntity studentEntity){
        
        studentEntity.setDob(ApplicationUtil.formatStringToDate(studentForm.getDob()));
        studentEntity.setFatherName(studentForm.getFatherName());
        studentEntity.setGenderType(GenderType.valueOf(studentForm.getGenderType()));
        studentEntity.setMotherName(studentForm.getMotherName());
        studentEntity.setFirstName(studentForm.getFirstName());
        studentEntity.setLastName(studentForm.getLastName());
        studentEntity.setStudentMob(studentForm.getStudentMob());
        studentEntity.setEmail(studentForm.getEmail());
        studentEntity.setParentMob(studentForm.getParentMob());
        studentEntity.setMotherOccup(studentForm.getMotherOccup());
        studentEntity.setFatherOccup(studentForm.getFatherOccup());
        studentEntity.setNationality(studentForm.getNationality());
        studentEntity.setSeatCategoryType(SeatCategoryType.valueOf(studentForm.getSeatCategoryType()));
    }
    
    
    //Check valid student exists for this StudentRollNumber
    public ActionForward findByStudentRollNumber(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        StudentForm studentForm = (StudentForm) form;
        StudentDao studentDao = new StudentDao();
        
        StudentEntity studentEntity= studentDao.findByStudentRollNumber(studentForm.getRollNum());
        
        if (studentEntity!=null) {
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
        return null;
    }
    
    //Check valid student exists for this StudentRollNumber
    public ActionForward findByStudentEnrollmentNumber(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        StudentForm studentForm = (StudentForm) form;
        String enrollmentNum = studentForm.getEnrollmentNumSearch();
        
        StudentDao studentDao = new StudentDao();
        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        
        StudentEnrollmentEntity studentEnrollmentEntity = studentEnrollmentDAO.findByStudentEnrollmentNumber(enrollmentNum);
        
        if (studentEnrollmentEntity==null) {
            response.getWriter().write("EnrollmentNoFound");
        }else if(studentEnrollmentEntity!=null){
            StudentEntity studentEntity= studentDao.findByStudentEnrollmentNumber(enrollmentNum);
            if (studentEntity!=null) {
                response.getWriter().write(studentEntity.getRollNum());
            }else{
                 response.getWriter().write("true");
            }
       }
        return null;
    }
    
    private List<LabelValueBean> getGenderTypeList() {
        List<LabelValueBean> genderTypeList = new ArrayList<>();
        for (GenderType genderType : GenderType.values()) {
            genderTypeList.add(new LabelValueBean(genderType.name(), genderType.name()));
        }
        return genderTypeList;
    }
    
    private List<LabelValueBean> getSeatCategoryTypeList() {
        List<LabelValueBean> facultyTypeList = new ArrayList<>();
        for (SeatCategoryType seatCategoryType : SeatCategoryType.values()) {
            facultyTypeList.add(new LabelValueBean(seatCategoryType.name(), seatCategoryType.name()));
        }
        return facultyTypeList;
    }
}
