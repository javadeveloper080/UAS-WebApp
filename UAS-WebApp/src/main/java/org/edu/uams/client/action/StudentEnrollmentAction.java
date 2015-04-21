
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
import org.edu.uams.server.api.EmailDTO;
import org.edu.uams.server.api.EnrollmentStatusType;
import org.edu.uams.server.api.GenderType;
import org.edu.uams.server.business.CourseTypeDao;
import org.edu.uams.server.business.ProgramLevelTypeDao;
import org.edu.uams.server.business.StudentEnrollmentDAO;
import org.edu.uams.server.pojo.CourseTypeEntity;
import org.edu.uams.server.pojo.ProgramLevelTypeEntity;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.util.ApplicationUtil;
import org.edu.uams.server.util.SendMail;


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
                sendEmailToStudent(persited);
                studentEnrollmentForm.setStatusMessage("You have Sucessfull enrolled for the selected course, Your Enrollemnt number is :"+persited.getEnrollmentNumber());
            }
        }
        
        List<CourseTypeEntity> listOfCourses = courseTypeDao.findAll();
        studentEnrollmentForm.setListOfCourses(listOfCourses);
        studentEnrollmentForm.setGenderTypeList(getGenderTypeList());
        studentEnrollmentForm.setListOfProgamLevelTypes(programLevelTypeDao.findAll());
        
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward allStudentEnrollmentPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        StudentEnrollmentForm studentEnrollmentForm = (StudentEnrollmentForm) form;
        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        
        List<StudentEnrollmentEntity> studentEnrollmetList=null;
        
        if (studentEnrollmentForm.getPageName() != null && studentEnrollmentForm.getPageName().equals(ApplicationConstants.FILTER_TYPE)) {
           
            if (studentEnrollmentForm.getApplyCourseId()!=null && studentEnrollmentForm.getApplyCourseId()>0
                    && studentEnrollmentForm.getEnrollmentStatusType()!=null && !studentEnrollmentForm.getEnrollmentStatusType().isEmpty()) {
                studentEnrollmetList=studentEnrollmentDAO.findByAppliedCourseStatusType(studentEnrollmentForm.getApplyCourseId(), studentEnrollmentForm.getEnrollmentStatusType());
            }
            
            else if (studentEnrollmentForm.getApplyCourseId()!=null && studentEnrollmentForm.getApplyCourseId()>0
                    && (studentEnrollmentForm.getEnrollmentStatusType()==null || studentEnrollmentForm.getEnrollmentStatusType().isEmpty())) {
                studentEnrollmetList=studentEnrollmentDAO.findByAppliedCourse(studentEnrollmentForm.getApplyCourseId());
            }
            else if ((studentEnrollmentForm.getApplyCourseId()==null || studentEnrollmentForm.getApplyCourseId()==0 )
                    && (studentEnrollmentForm.getEnrollmentStatusType()!=null && !studentEnrollmentForm.getEnrollmentStatusType().isEmpty())) {
                studentEnrollmetList=studentEnrollmentDAO.findByEnrollmentStatusType(studentEnrollmentForm.getEnrollmentStatusType());
            }
            else{
                studentEnrollmetList=studentEnrollmentDAO.findAll();
            }
            
        }else{
            studentEnrollmetList=studentEnrollmentDAO.findAll();
        }
        
        
        studentEnrollmentForm.setEnrollmentStatusTypeList(getEnrollmentStatusTypeList());
        
        CourseTypeDao courseTypeDao = new CourseTypeDao();
        List<CourseTypeEntity> listOfCourses = courseTypeDao.findAll();
        studentEnrollmentForm.setListOfCourses(listOfCourses);
        
        studentEnrollmentForm.setStudentEnrollmetList(studentEnrollmetList);
        request.setAttribute("studentModule", "true");
        request.setAttribute("enrollments", "true");
        return mapping.findForward("allStudentEnrollmentPage");
    }
    
    
    public ActionForward sendStatusToStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        StudentEnrollmentForm studentEnrollmentForm = (StudentEnrollmentForm) form;
        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        
        StudentEnrollmentEntity studentEnrollmentEntity = studentEnrollmentDAO.findByPrimaryKey(studentEnrollmentForm.getId());
        studentEnrollmentEntity.setEnrollmentStatusType(EnrollmentStatusType.valueOf(studentEnrollmentForm.getStatusMessage()));
        studentEnrollmentDAO.update(studentEnrollmentEntity);
        String studentEmailAdress=studentEnrollmentEntity.getEmail();
        String subject=" Enrollment Number :"+studentEnrollmentEntity.getEnrollmentNumber();
        
        
        String emailBody="Dear " + studentEnrollmentEntity.getLastName() + " ,\n  Your enrollment number "+studentEnrollmentEntity.getEnrollmentNumber()+" \n \n  "
                + "Applied Course" +":" +studentEnrollmentEntity.getAppliedCourseType().getCode()+"\n \n"
                + "has been "+studentEnrollmentForm.getStatusMessage()+"\n \n"
                + " Thanks, Admin \n \n ";
        
        
        EmailDTO dto=new EmailDTO( studentEmailAdress, subject, emailBody);
        SendMail.sendMail(dto);
        
        response.getWriter().write("done");
        return null;
    }
    
    public void sendEmailToStudent(StudentEnrollmentEntity studentEnrollmentEntity)
    {
        String studentEmailAdress=studentEnrollmentEntity.getEmail();
        
        String subject=" Enrollment Number :"+studentEnrollmentEntity.getEnrollmentNumber();
        
        String emailBody="Dear " + studentEnrollmentEntity.getLastName() + " ,\n  Please find  your enrollment number "+studentEnrollmentEntity.getEnrollmentNumber()+" \n \n  "
                + "Applied Course" +":" +studentEnrollmentEntity.getAppliedCourseType().getCode()+"\n \n"
                + " Thanks, Admin \n \n ";
        
        EmailDTO dto=new EmailDTO( studentEmailAdress, subject, emailBody);
        SendMail.sendMail(dto);
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
        enrollmentEntity.setEnrollmentStatusType(EnrollmentStatusType.PENDING);
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
    
      private List<LabelValueBean> getEnrollmentStatusTypeList() {
        List<LabelValueBean> enrollmentStatusTypeList = new ArrayList<>();
        for (EnrollmentStatusType enrollmentStatusType : EnrollmentStatusType.values()) {
            enrollmentStatusTypeList.add(new LabelValueBean(enrollmentStatusType.name(), enrollmentStatusType.name()));
        }
        return enrollmentStatusTypeList;
    }
}
