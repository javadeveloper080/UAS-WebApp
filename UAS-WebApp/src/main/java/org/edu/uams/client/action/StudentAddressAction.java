/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
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
import org.edu.uams.client.form.StudentAddressForm;
import org.edu.uams.server.api.AddressType;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.StudentAddressDAO;
import org.edu.uams.server.business.StudentDao;
import org.edu.uams.server.pojo.StudentAddressEntity;


public class StudentAddressAction  extends DispatchAction {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "studentAdd";
    
    
    public ActionForward studentAdressPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        StudentAddressForm studentAddressForm = (StudentAddressForm) form;
        StudentAddressDAO studentAddressDAO = new StudentAddressDAO();
        
        StudentDao studentDao =new StudentDao();
        
        if(studentAddressForm.getPageName()!=null && studentAddressForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            
            StudentAddressEntity studentAddressEntity = studentAddressDAO.findByPrimaryKey(studentAddressForm.getId());
            studentAddressForm.setAddrLine1(studentAddressEntity.getAddrLine1());
            studentAddressForm.setAddrLine2(studentAddressEntity.getAddrLine2());
            studentAddressForm.setAddrLine3(studentAddressEntity.getAddrLine3());
            studentAddressForm.setAddrLine4(studentAddressEntity.getAddrLine4());
            studentAddressForm.setCity(studentAddressEntity.getCity());
            studentAddressForm.setStateName(studentAddressEntity.getStateName());
            studentAddressForm.setZipCode(studentAddressEntity.getZipCode());
            studentAddressForm.setAddressType(studentAddressEntity.getAddressType().name());
            studentAddressForm.setStudentId(studentAddressEntity.getStudent().getId());
            studentAddressForm.setId(studentAddressEntity.getId());
        }
        
        else if(studentAddressForm.getPageName()!=null && studentAddressForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            StudentAddressEntity studentAddressEntity = studentAddressDAO.findByPrimaryKey(studentAddressForm.getId());
            studentAddressEntity.setAddrLine1(studentAddressForm.getAddrLine1());
            studentAddressEntity.setAddrLine2(studentAddressForm.getAddrLine2());
            studentAddressEntity.setAddrLine3(studentAddressForm.getAddrLine3());
            studentAddressEntity.setAddrLine4(studentAddressForm.getAddrLine4());
            studentAddressEntity.setCity(studentAddressForm.getCity());
            studentAddressEntity.setStateName(studentAddressForm.getStateName());
            studentAddressEntity.setZipCode(studentAddressForm.getZipCode());
            studentAddressEntity.setAddressType(AddressType.valueOf(studentAddressForm.getAddressType()));
            studentAddressEntity.setStudent(studentDao.findByPrimaryKey(studentAddressForm.getStudentId()));
            studentAddressDAO.update(studentAddressEntity);
            studentAddressForm.resetForm();
        }
        
        else if(studentAddressForm.getPageName()!=null && studentAddressForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            StudentAddressEntity studentAddressEntity = new StudentAddressEntity();
            studentAddressEntity.setAddrLine1(studentAddressForm.getAddrLine1());
            studentAddressEntity.setAddrLine2(studentAddressForm.getAddrLine2());
            studentAddressEntity.setAddrLine3(studentAddressForm.getAddrLine3());
            studentAddressEntity.setAddrLine4(studentAddressForm.getAddrLine4());
            studentAddressEntity.setCity(studentAddressForm.getCity());
            studentAddressEntity.setStateName(studentAddressForm.getStateName());
            studentAddressEntity.setZipCode(studentAddressForm.getZipCode());
            studentAddressEntity.setAddressType(AddressType.valueOf(studentAddressForm.getAddressType()));
            studentAddressEntity.setStudent(studentDao.findByPrimaryKey(studentAddressForm.getStudentId()));
            studentAddressDAO.persist(studentAddressEntity);
            studentAddressForm.resetForm();
        }
        
        List<StudentAddressEntity> studentAddressList = studentAddressDAO.findAll();
        studentAddressForm.setAddressTypeList(getAddressTypeList());
        if(!studentAddressList.isEmpty()){
            studentAddressForm.setStudentAddressList(studentAddressList);
        }
        
        request.setAttribute("studentModule", "true");
        request.setAttribute("studentAdd", "true");
        return mapping.findForward(SUCCESS);
    }
    
    private List<LabelValueBean> getAddressTypeList() {
        List<LabelValueBean> facultyTypeList = new ArrayList<>();
        for (AddressType addressType : AddressType.values()) {
            facultyTypeList.add(new LabelValueBean(addressType.name(), addressType.name()));
        }
        return facultyTypeList;
    }
}
