
package org.edu.uams.client.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.edu.uams.client.form.StudentForm;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.pojo.StudentEntity;

/**
 *
 * @author SARAT
 */
public class StudentAction extends Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "student";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        StudentForm studentForm =(StudentForm)form;
        
        StudentEntity  studentEntity = new StudentEntity();
        
        if(studentForm.getPageName()!=null ){
        
        studentEntity.setRollNum(studentForm.getRollNum());
        studentEntity.setBranchName(studentForm.getBranchName());
        studentEntity.setPath(studentForm.getPath());
        studentEntity.setPhoto(studentForm.getPhoto());
        studentEntity.setSem(studentForm.getSem());
        studentEntity.setStudentName(studentForm.getStudentName());
        studentEntity.setAdmnNum(studentForm.getAdmnNum());
        
        StudentDao studentDao = new StudentDao();
        studentDao.persist(studentEntity);
        }
        request.setAttribute("studentModule", "true");
        request.setAttribute("studentDetails", "true");
        return mapping.findForward(SUCCESS);
    }

}
