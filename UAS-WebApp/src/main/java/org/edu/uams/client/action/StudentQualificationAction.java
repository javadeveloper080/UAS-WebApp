/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.edu.uams.client.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.StudentQualificationForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentQualificationDao;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.pojo.StudentQualificationEntity;


public class StudentQualificationAction  extends DispatchAction {
    
    
    
    
    public ActionForward studentQualificationPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        final StudentQualificationForm studentQlfForm = (StudentQualificationForm) form;
        
        StudentQualificationDao studentQlfDao = new StudentQualificationDao();
        StudentDao studentDao =new StudentDao();
        
        StudentEntity studentEntity =null;
        StudentQualificationEntity studentQualificationEntity = null;
        
        if (studentQlfForm.getSearchText()!=null) {
            studentEntity = studentDao.findByStudentRollNumber(studentQlfForm.getSearchText());
        }
        
        
        if (studentQlfForm.getPageName() != null && studentQlfForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            studentQualificationEntity =new StudentQualificationEntity();
            copyDataFromSQFormToSQEntity(studentQlfForm, studentQualificationEntity,true);
            studentQlfDao.persist(studentQualificationEntity);
        }
        
        else if (studentQlfForm.getPageName() != null && studentQlfForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {
            studentQualificationEntity =studentQlfDao.findByPrimaryKey(studentQlfForm.getId());
            copyDataFromSQFormToSQEntity(studentQlfForm, studentQualificationEntity,true);
            studentQlfDao.update(studentQualificationEntity);
        }
        
        if (studentEntity!=null) {
            studentQlfForm.setRollNum(studentEntity.getRollNum());
            studentQlfForm.setStudentFullName(studentEntity.getStudentFullName());
            studentQlfForm.setStudentId(studentEntity.getId());
            studentQualificationEntity =studentQlfDao.findByPrimaryKey(studentQlfForm.getId());
            if (studentQualificationEntity!=null) {
                copyDataFromSQFormToSQEntity(studentQlfForm, studentQualificationEntity,false);
            }
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
            studentQlfEntity.setDegMedium(studentQlfForm.getDegMedium());
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
            studentQlfForm.setDegMedium(studentQlfEntity.getDegMedium());
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
