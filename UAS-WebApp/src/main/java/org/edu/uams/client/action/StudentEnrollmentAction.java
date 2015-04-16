
package org.edu.uams.client.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.edu.uams.client.form.StudentEnrollmentForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.CourseMasterDao;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.business.StudentEnrollmentDAO;
import org.edu.uams.server.pojo.CourseMasterEntity;
import org.edu.uams.server.pojo.StudentEnrollmentEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.util.ApplicationUtil;

/**
 *
 * @author SARAT
 */
public class StudentEnrollmentAction extends org.apache.struts.action.Action {

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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentEnrollmentForm studentEnrollmentForm = (StudentEnrollmentForm) form;
        StudentEnrollmentEntity enrollmentEntity = null;

        StudentEnrollmentDAO studentEnrollmentDAO = new StudentEnrollmentDAO();
        StudentDao studentDao = new StudentDao();
        CourseMasterDao courseMasterDao = new CourseMasterDao();
        List<CourseMasterEntity> listOfCourses = courseMasterDao.findAll();
        studentEnrollmentForm.setListOfCourses(listOfCourses);
        
        if (studentEnrollmentForm.getSearchText()!=null) {
            StudentEntity    studentEntity = studentDao.findByStudentRollNumber(studentEnrollmentForm.getSearchText());
            if(studentEntity!=null){
                studentEnrollmentForm.setRollNum(studentEntity.getRollNum());
                studentEnrollmentForm.setStudentFullName(studentEntity.getStudentFullName());
                studentEnrollmentForm.setStudentId(studentEntity.getId());
            }
        }
        
        if (studentEnrollmentForm.getPageName() != null && studentEnrollmentForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE)) {
            enrollmentEntity = new StudentEnrollmentEntity();
            copyFormDataToEntity(studentEnrollmentForm, enrollmentEntity,studentDao,courseMasterDao);
            studentEnrollmentDAO.persist(enrollmentEntity);
            studentEnrollmentForm.setId(enrollmentEntity.getId());
        }
        if (studentEnrollmentForm.getPageName() != null && studentEnrollmentForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE)) {
            enrollmentEntity = studentEnrollmentDAO.findByPrimaryKey(studentEnrollmentForm.getId());
            copyFormDataToEntity(studentEnrollmentForm, enrollmentEntity,studentDao, courseMasterDao);
            studentEnrollmentDAO.update(enrollmentEntity);
            studentEnrollmentForm.setId(enrollmentEntity.getId());
        }

        request.setAttribute("studentModule", "true");
        request.setAttribute("studentEnrollment", "true");
        return mapping.findForward(SUCCESS);
    }

    private void copyFormDataToEntity(StudentEnrollmentForm studentEnrollmentForm, StudentEnrollmentEntity enrollmentEntity,
        StudentDao studentDao, CourseMasterDao courseMasterDao) {
        enrollmentEntity.setCourseId(courseMasterDao.findByPrimaryKey(studentEnrollmentForm.getCourseId()));
        enrollmentEntity.setDateEnrolled(ApplicationUtil.formatStringToDate(studentEnrollmentForm.getDateEnrolled()));
        enrollmentEntity.setGrade(studentEnrollmentForm.getGrade());
        enrollmentEntity.setStudentId(studentDao.findByPrimaryKey(studentEnrollmentForm.getStudentId()));
    }
}
