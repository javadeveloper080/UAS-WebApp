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
import org.edu.uams.client.form.StudentCorrAddressDetailsForm;
import org.edu.uams.server.business.StudentCorrAddressDetailsDAO;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.pojo.StudentAddressEntity;

/**
 *
 * @author SARAT
 */
public class StudentCorrAddressDetailsAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "studentCorrAdd";

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
        StudentCorrAddressDetailsForm studentCorrAddressDetailsForm = (StudentCorrAddressDetailsForm) form;
        StudentCorrAddressDetailsDAO corrAddressDetailsDAO = new StudentCorrAddressDetailsDAO();
        
        StudentDao studentDao =new StudentDao();

        if (studentCorrAddressDetailsForm.getPageName() != null) {
            StudentAddressEntity studentCorrAddressDetailsEntity = new StudentAddressEntity();
            studentCorrAddressDetailsEntity.setAreaName(studentCorrAddressDetailsForm.getAreaName());
            studentCorrAddressDetailsEntity.setCity(studentCorrAddressDetailsForm.getCity());
            studentCorrAddressDetailsEntity.setDistrictName(studentCorrAddressDetailsForm.getDistrictName());
            studentCorrAddressDetailsEntity.setDoorNum(studentCorrAddressDetailsForm.getDoorNum());
            studentCorrAddressDetailsEntity.setPin(studentCorrAddressDetailsForm.getPin());
            studentCorrAddressDetailsEntity.setRollNum(studentCorrAddressDetailsForm.getRollNum());
            studentCorrAddressDetailsEntity.setStreetName(studentCorrAddressDetailsForm.getStreetName());
            studentCorrAddressDetailsEntity.setStudentTab(studentDao.findByPrimaryKey(studentCorrAddressDetailsForm.getRollNum()));
            corrAddressDetailsDAO.persist(studentCorrAddressDetailsEntity);
        }

        request.setAttribute("studentModule", "true");
        request.setAttribute("studentCorrAddr", "true");
        return mapping.findForward(SUCCESS);
    }
}
