package org.edu.uams.client.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.edu.uams.client.form.StudentForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.pojo.BusFacultyEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.util.ApplicationUtil;

/**
 *
 * @author SARAT
 */
public class StudentAction extends Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "student";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

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
            studentForm.setMobile(studentEntity.getMobile());
            studentForm.setGenderType((studentEntity.getGenderType()).name());
            studentForm.setMotherName(studentEntity.getMotherName());
            studentForm.setFirstName(studentEntity.getFirstName());
            studentForm.setLastName(studentEntity.getLastName());
            studentForm.setAdmnNum(studentEntity.getAdmnNum());
            studentForm.setId(studentEntity.getId());
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
            studentEntity.setStudentMob(studentForm.getMobile());
            studentEntity.setGenderType(GenderType.valueOf(studentForm.getGenderType()));
            studentEntity.setMotherName(studentForm.getMotherName());
            studentEntity.setFirstName(studentForm.getFirstName());
            studentEntity.setLastName(studentForm.getLastName());
            studentEntity.setAdmnNum(studentForm.getAdmnNum());
     }
}
