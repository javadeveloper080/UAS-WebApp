package org.edu.uams.client.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.StudentForm;
import org.edu.uams.client.form.StudentQualificationForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.api.SeatCategoryType;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentQualificationDao;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.StudentQualificationEntity;
import org.edu.uams.server.util.ApplicationUtil;

/**
 *
 * @author SARAT
 */
public class StudentAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "student";

    public ActionForward studentPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        StudentForm studentForm = (StudentForm) form;

        StudentEntity studentEntity = null;

         StudentDao studentDao = new StudentDao();
        if (studentForm.getPageName() != null && studentForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            studentEntity =new StudentEntity();
            copyDataFromFormToEntity(studentForm, studentEntity);
            studentDao.persist(studentEntity);

        }
         if (studentForm.getPageName() != null && studentForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {
            studentEntity =studentDao.findByPrimaryKey(studentForm.getId());
            copyDataFromFormToEntity(studentForm, studentEntity);
            studentDao.update(studentEntity);
        }
        else if(studentForm.getPageName()!=null && studentForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM)){
            studentEntity =studentDao.findByPrimaryKey(studentForm.getId());
            studentForm.reset(mapping, request);
            studentForm.setRollNum(studentEntity.getRollNum());
            studentForm.setAdmnNum(studentEntity.getAdmnNum());
            studentForm.setDob(ApplicationUtil.formatDateToString(studentEntity.getDob()));
            studentForm.setFatherName(studentEntity.getFatherName());
            studentForm.setGenderType((studentEntity.getGenderType()).name());
            studentForm.setMotherName(studentEntity.getMotherName());
            studentForm.setFirstName(studentEntity.getFirstName());
            studentForm.setLastName(studentEntity.getLastName());
            studentForm.setAdmnNum(studentEntity.getAdmnNum());
            studentForm.setId(studentEntity.getId());
            studentForm.setStudentMob(studentEntity.getStudentMob());
            studentForm.setEmail(studentEntity.getEmail());
            studentForm.setParentMob(studentEntity.getParentMob());
            studentForm.setMotherOccup(studentEntity.getMotherOccup());
            studentForm.setFatherOccup(studentEntity.getFatherOccup());
            studentForm.setNationality(studentEntity.getNationality());
            studentForm.setSeatCategoryType((studentEntity.getSeatCategoryType().name()));
        }

         List<StudentEntity> studentList = studentDao.findAll();
         if(!studentList.isEmpty()){
            studentForm.setListOfStudents(studentList);
        }

        request.setAttribute("studentModule", "true");
        request.setAttribute("studentDetails", "true");
        return mapping.findForward(SUCCESS);
    }
     private void copyDataFromFormToEntity(StudentForm studentForm,StudentEntity studentEntity){
            studentEntity.setRollNum(studentForm.getRollNum());
            studentEntity.setAdmnNum(studentForm.getAdmnNum());
            studentEntity.setDob(ApplicationUtil.formatStringToDate(studentForm.getDob()));
            studentEntity.setFatherName(studentForm.getFatherName());
            studentEntity.setGenderType(GenderType.valueOf(studentForm.getGenderType()));
            studentEntity.setMotherName(studentForm.getMotherName());
            studentEntity.setFirstName(studentForm.getFirstName());
            studentEntity.setLastName(studentForm.getLastName());
            studentEntity.setAdmnNum(studentForm.getAdmnNum());
            studentEntity.setStudentMob(studentForm.getStudentMob());
            studentEntity.setEmail(studentForm.getEmail());
            studentEntity.setParentMob(studentForm.getParentMob());
            studentEntity.setMotherOccup(studentForm.getMotherOccup());
            studentEntity.setFatherOccup(studentForm.getFatherOccup());
            studentEntity.setNationality(studentForm.getNationality());
            studentEntity.setSeatCategoryType(SeatCategoryType.valueOf(studentForm.getSeatCategoryType()));
     }

     public ActionForward studentQualificationPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

         final StudentQualificationForm studentQlfForm = (StudentQualificationForm) form;

         StudentQualificationEntity studentQlfEntity = null;

         StudentQualificationDao studentQlfDao = new StudentQualificationDao();
        if (studentQlfForm.getPageName() != null && studentQlfForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            studentQlfEntity =new StudentQualificationEntity();
            copyDataFromSQFormToSQEntity(studentQlfForm, studentQlfEntity,true);
            studentQlfDao.persist(studentQlfEntity);

        }
         if (studentQlfForm.getPageName() != null && studentQlfForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {

            studentQlfEntity =studentQlfDao.findByPrimaryKey(studentQlfForm.getId());
            copyDataFromSQFormToSQEntity(studentQlfForm, studentQlfEntity,true);
            studentQlfDao.update(studentQlfEntity);
        }
        else if(studentQlfForm.getPageName()!=null && studentQlfForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM)){
            studentQlfEntity =studentQlfDao.findByPrimaryKey(studentQlfForm.getId());
            copyDataFromSQFormToSQEntity(studentQlfForm, studentQlfEntity,false);
        }
         
        StudentDao studentDao = new StudentDao();
         List<StudentEntity> studentList = studentDao.findAll();
         if(!studentList.isEmpty()){
            studentQlfForm.setListOfStudents(studentList);
        }
         
         List<StudentQualificationEntity> studentQlfList = studentQlfDao.findAll();
         if(!studentQlfList.isEmpty()){
            studentQlfForm.setListOfStudentQlfs(studentQlfList);
        }

        request.setAttribute("studentModule", "true");
        request.setAttribute("studentQlfDetails", "true");
        return mapping.findForward("studentQualification");
    }
     private void copyDataFromSQFormToSQEntity(StudentQualificationForm studentQlfForm , StudentQualificationEntity studentQlfEntity,boolean isEntity){
         if(isEntity)
         {
            studentQlfEntity.setId(studentQlfForm.getId());
            studentQlfEntity.setDegDivision(studentQlfForm.getDegDivision());
            studentQlfEntity.setDegMedium(studentQlfForm.getDegMedium());//ApplicationUtil.formatStringToDate(studentQlfForm.getDob()));
            studentQlfEntity.setDegNameInstitution(studentQlfForm.getDegNameInstitution());
            studentQlfEntity.setDegPercentage(studentQlfForm.getDegPercentage());
            studentQlfEntity.setDegYearOfPass(studentQlfForm.getDegYearOfPass());
            studentQlfEntity.setDipDivision(studentQlfForm.getDipDivision());
            studentQlfEntity.setDipMedium(studentQlfForm.getDipMedium());
            studentQlfEntity.setDipNameInstitution(studentQlfForm.getDipNameInstitution());
            studentQlfEntity.setDipPercentage(studentQlfForm.getDipPercentage());

            studentQlfEntity.setDipYearOfPass(studentQlfForm.getDipYearOfPass());
            studentQlfEntity.setIntrDivision(studentQlfForm.getIntrDivision());
            studentQlfEntity.setIntrInstitutionName(studentQlfForm.getIntrInstitutionName());
            studentQlfEntity.setIntrMedium(studentQlfForm.getIntrMedium());
            studentQlfEntity.setIntrPercentage(studentQlfForm.getIntrPercentage());
            studentQlfEntity.setIntrYearOfPass(studentQlfForm.getIntrYearOfPass());

            studentQlfEntity.setSdivision(studentQlfForm.getSdivision());
            studentQlfEntity.setSecondaryInstitutionName(studentQlfForm.getSecondaryInstitutionName());
            studentQlfEntity.setSpercentage(studentQlfForm.getSpercentage());

            final StudentDao studentDao = new StudentDao();
            if(studentQlfForm.getStudentId() != 0l){
            studentQlfEntity.setStudent(studentDao.findByPrimaryKey(studentQlfForm.getStudentId()));}
            studentQlfEntity.setsMedium(studentQlfForm.getsMedium());
            studentQlfEntity.setSyearOfPass(studentQlfForm.getSyearOfPass());  
         }else
         {
             studentQlfForm.setId(studentQlfEntity.getId());
            studentQlfForm.setDegDivision(studentQlfEntity.getDegDivision());
            studentQlfForm.setDegMedium(studentQlfEntity.getDegMedium());//ApplicationUtil.formatStringToDate(studentQlfForm.getDob()));
            studentQlfForm.setDegNameInstitution(studentQlfEntity.getDegNameInstitution());
            studentQlfForm.setDegPercentage(studentQlfEntity.getDegPercentage());
            studentQlfForm.setDegYearOfPass(studentQlfEntity.getDegYearOfPass());
            studentQlfForm.setDipDivision(studentQlfEntity.getDipDivision());
            studentQlfForm.setDipMedium(studentQlfEntity.getDipMedium());
            studentQlfForm.setDipNameInstitution(studentQlfEntity.getDipNameInstitution());
            studentQlfForm.setDipPercentage(studentQlfEntity.getDipPercentage());

            studentQlfForm.setDipYearOfPass(studentQlfEntity.getDipYearOfPass());
            studentQlfForm.setIntrDivision(studentQlfEntity.getIntrDivision());
            studentQlfForm.setIntrInstitutionName(studentQlfEntity.getIntrInstitutionName());
            studentQlfForm.setIntrMedium(studentQlfEntity.getIntrMedium());
            studentQlfForm.setIntrPercentage(studentQlfEntity.getIntrPercentage());
            studentQlfForm.setIntrYearOfPass(studentQlfEntity.getIntrYearOfPass());

            studentQlfForm.setSdivision(studentQlfEntity.getSdivision());
            studentQlfForm.setSecondaryInstitutionName(studentQlfEntity.getSecondaryInstitutionName());
            studentQlfForm.setSpercentage(studentQlfEntity.getSpercentage());

            studentQlfForm.setStudentId(studentQlfEntity.getStudent().getId());}
            studentQlfForm.setsMedium(studentQlfForm.getsMedium());
            studentQlfForm.setSyearOfPass(studentQlfForm.getSyearOfPass());
            
     }
}
