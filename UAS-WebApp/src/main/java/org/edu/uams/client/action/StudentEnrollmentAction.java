
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
import org.edu.uams.client.form.StudentEnrollmentForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.business.CourseTypeDao;
import org.edu.uams.server.business.ProgramLevelTypeDao;
import org.edu.uams.server.business.StudentEnrollmentDAO;
import org.edu.uams.server.pojo.CourseTypeEntity;
import org.edu.uams.server.pojo.ProgramLevelTypeEntity;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.util.ApplicationUtil;


public class StudentEnrollmentAction extends DispatchAction {
    
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
    public ActionForward studentEnrollmentPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        StudentEnrollmentForm studentEnrollmentForm = (StudentEnrollmentForm) form;
        StudentEnrollmentEntity enrollmentEntity = null;
        
        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        
        Long nextId=studentEnrollmentDAO.getLastestId()+1;
        
        ProgramLevelTypeDao programLevelTypeDao = new ProgramLevelTypeDao();
        CourseTypeDao courseTypeDao = new CourseTypeDao();
        
        if (studentEnrollmentForm.getPageName() != null && studentEnrollmentForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            enrollmentEntity = new StudentEnrollmentEntity();
            copyFormDataToEntity(studentEnrollmentForm, enrollmentEntity,courseTypeDao, programLevelTypeDao,nextId);
            StudentEnrollmentEntity persited=studentEnrollmentDAO.persist(enrollmentEntity);
            if (persited!=null ) {
                studentEnrollmentForm.setStatusMessage("You have Sucessfull enrolled for the selected course, Your Enrollemnt number is :"+persited.getEnrollmentNumber());
            }
        }
        
        List<CourseTypeEntity> listOfCourses = courseTypeDao.findAll();
        studentEnrollmentForm.setListOfCourses(listOfCourses);
        studentEnrollmentForm.setGenderTypeList(getGenderTypeList());
        studentEnrollmentForm.setListOfProgamLevelTypes(programLevelTypeDao.findAll());
        
        return mapping.findForward(SUCCESS);
    }
    
    private void copyFormDataToEntity(StudentEnrollmentForm studentEnrollmentForm, StudentEnrollmentEntity enrollmentEntity,CourseTypeDao courseTypeDao,
            ProgramLevelTypeDao programLevelTypeDao,Long nextId) {
        CourseTypeEntity appliedCourse = courseTypeDao.findByPrimaryKey(studentEnrollmentForm.getApplyCourseId());
        
        ProgramLevelTypeEntity appliedDProgramLevelType=programLevelTypeDao.findByPrimaryKey(studentEnrollmentForm.getAppliedProgramLevelTypeId());
        
        enrollmentEntity.setAppliedCourseType(appliedCourse);
        enrollmentEntity.setAppliedProgramLevelType(appliedDProgramLevelType);
        enrollmentEntity.setDateEnrolled(ApplicationUtil.formatStringToDate(studentEnrollmentForm.getDateEnrolled()));
        enrollmentEntity.setDob(ApplicationUtil.formatStringToDate(studentEnrollmentForm.getDob()));
        enrollmentEntity.setEmail(studentEnrollmentForm.getEmail());
        enrollmentEntity.setFirstName(studentEnrollmentForm.getFirstName());
        enrollmentEntity.setGenderType(GenderType.valueOf(studentEnrollmentForm.getGenderType()));
        enrollmentEntity.setGrade(studentEnrollmentForm.getGrade());
        enrollmentEntity.setLastGraduatedCourseType(courseTypeDao.findByPrimaryKey(studentEnrollmentForm.getLastGraduatedCourseId()));
        if (studentEnrollmentForm.getGraduatedProgramLevelTypeId()!=null) {
            enrollmentEntity.setLastGraduatedProgramLevelType(programLevelTypeDao.findByPrimaryKey(studentEnrollmentForm.getGraduatedProgramLevelTypeId()));
        }
        enrollmentEntity.setLastName(studentEnrollmentForm.getLastName());
        enrollmentEntity.setStudentMob(studentEnrollmentForm.getStudentMob());
        
        String enrollmentNumber=appliedDProgramLevelType.getCode()+"-"+appliedCourse.getCode()+ "-"+nextId;
        enrollmentEntity.setEnrollmentNumber(enrollmentNumber);
        
    }
    
    
     private List<LabelValueBean> getGenderTypeList() {
        List<LabelValueBean> genderTypeList = new ArrayList<>();
        for (GenderType genderType : GenderType.values()) {
            genderTypeList.add(new LabelValueBean(genderType.name(), genderType.name()));
        }
        return genderTypeList;
    }
}
