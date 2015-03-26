/**
 *
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
import org.edu.uams.client.form.TransportModuleForm;
import org.edu.uams.server.api.FacultyType;
import org.edu.uams.server.business.BusFacultyDao;
import org.edu.uams.server.pojo.BusFacultyEntity;


public class TransportModuleAction extends DispatchAction {
    
    
    
    
    public ActionForward busFacultyPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TransportModuleForm transportModuleForm = (TransportModuleForm)form;
        System.out.println("typeTableForm:"+transportModuleForm.getPageName());
        BusFacultyDao busFacultyDao = new BusFacultyDao();
        
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals("GetEditTypeForm"))
        {
            BusFacultyEntity busFacultyEntity = busFacultyDao.findByPrimaryKey(transportModuleForm.getId());
            transportModuleForm.resetForm();
            transportModuleForm.setAddrLine1(busFacultyEntity.getAddrLine1());
            transportModuleForm.setAddrLine3(busFacultyEntity.getAddrLine2());
            transportModuleForm.setAddrLine3(busFacultyEntity.getAddrLine3());
            transportModuleForm.setAddrLine4(busFacultyEntity.getAddrLine4());
            transportModuleForm.setCity(busFacultyEntity.getCity());
            transportModuleForm.setFirstName(busFacultyEntity.getFirstName());
            transportModuleForm.setLastName(busFacultyEntity.getLastName());
            transportModuleForm.setMobile(busFacultyEntity.getMobile());
            transportModuleForm.setStateName(busFacultyEntity.getStateName());
            transportModuleForm.setZipCode(busFacultyEntity.getZipCode());
            transportModuleForm.setFacultyType(busFacultyEntity.getFacultyType().name());
            transportModuleForm.setLicenceNum(busFacultyEntity.getLicenceNum());
            transportModuleForm.setId(busFacultyEntity.getId());
            List<String> facultyTypeList = getFacultyTypeList();
            transportModuleForm.setFacultyTypeList(facultyTypeList);
        }
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals("SubmitEditType"))
        {
            BusFacultyEntity busFacultyEntity = busFacultyDao.findByPrimaryKey(transportModuleForm.getId());
            busFacultyEntity.setAddrLine1(transportModuleForm.getAddrLine1());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine2());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine3());
            busFacultyEntity.setAddrLine4(transportModuleForm.getAddrLine4());
            busFacultyEntity.setCity(transportModuleForm.getCity());
            busFacultyEntity.setFirstName(transportModuleForm.getFirstName());
            busFacultyEntity.setLastName(transportModuleForm.getLastName());
            busFacultyEntity.setMobile(transportModuleForm.getMobile());
            busFacultyEntity.setStateName(transportModuleForm.getStateName());
            busFacultyEntity.setZipCode(transportModuleForm.getZipCode());
            busFacultyEntity.setFacultyType(FacultyType.valueOf(transportModuleForm.getFacultyType()));
            busFacultyEntity.setLicenceNum(transportModuleForm.getLicenceNum());
            busFacultyEntity.setId(transportModuleForm.getId());
            transportModuleForm.resetForm();
        }
        
        if(transportModuleForm.getPageName()!=null && transportModuleForm.getPageName().equals("SubmitAddType"))
        {
            BusFacultyEntity busFacultyEntity = new BusFacultyEntity();
            busFacultyEntity.setAddrLine1(transportModuleForm.getAddrLine1());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine2());
            busFacultyEntity.setAddrLine3(transportModuleForm.getAddrLine3());
            busFacultyEntity.setAddrLine4(transportModuleForm.getAddrLine4());
            busFacultyEntity.setCity(transportModuleForm.getCity());
            busFacultyEntity.setFirstName(transportModuleForm.getFirstName());
            busFacultyEntity.setLastName(transportModuleForm.getLastName());
            busFacultyEntity.setMobile(transportModuleForm.getMobile());
            busFacultyEntity.setStateName(transportModuleForm.getStateName());
            busFacultyEntity.setZipCode(transportModuleForm.getZipCode());
            busFacultyEntity.setFacultyType(FacultyType.valueOf(transportModuleForm.getFacultyType()));
            busFacultyEntity.setLicenceNum(transportModuleForm.getLicenceNum());
            busFacultyDao.persist(busFacultyEntity);
            transportModuleForm.resetForm();
        }
        
        List<BusFacultyEntity> busFacultyList = busFacultyDao.findAll();
        if(!busFacultyList.isEmpty()){
            transportModuleForm.setBusFacultyList(busFacultyList);
        }
        req.setAttribute("transportModule", "true");
        req.setAttribute("busFacultyPage", "true");
        return mapping.findForward("busFacultyPage");
    }
    
    private List<String> getFacultyTypeList() {
        List<String> facultyTypeList = new ArrayList<>();
        for (FacultyType facultyType : FacultyType.values()) {
            facultyTypeList.add(facultyType.name());
        }
        return facultyTypeList;
    }
    
}












