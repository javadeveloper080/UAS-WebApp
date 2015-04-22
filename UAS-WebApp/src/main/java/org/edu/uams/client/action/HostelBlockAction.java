 /**
  *
  */
package org.edu.uams.client.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.HostelBlockForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.HostelBlockDao;
import org.edu.uams.server.pojo.HostelBlockEntity;


public class HostelBlockAction extends DispatchAction {
    
    
    
    
    public ActionForward hostelBlockPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        HostelBlockForm hostelBlockForm = (HostelBlockForm)form;
        HostelBlockDao hostelBlockDao = new HostelBlockDao();
        
        if(hostelBlockForm.getPageName()!=null && hostelBlockForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            HostelBlockEntity hostelBlockEntity = hostelBlockDao.findByPrimaryKey(hostelBlockForm.getId());
            hostelBlockForm.resetForm();
            hostelBlockForm.setAddrLine1(hostelBlockEntity.getAddrLine1());
            hostelBlockForm.setAddrLine2(hostelBlockEntity.getAddrLine2());
            hostelBlockForm.setAddrLine3(hostelBlockEntity.getAddrLine3());
            hostelBlockForm.setAddrLine4(hostelBlockEntity.getAddrLine4());
            hostelBlockForm.setCity(hostelBlockEntity.getCity());
            hostelBlockForm.setInchargeName(hostelBlockEntity.getInchargeName());
            hostelBlockForm.setMobile(hostelBlockEntity.getMobile());
            hostelBlockForm.setStateName(hostelBlockEntity.getStateName());
            hostelBlockForm.setZipCode(hostelBlockEntity.getZipCode());
            hostelBlockForm.setName(hostelBlockEntity.getName());
            hostelBlockForm.setId(hostelBlockEntity.getId());
        }
        
        else if(hostelBlockForm.getPageName()!=null && hostelBlockForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            HostelBlockEntity hostelBlockEntity = hostelBlockDao.findByPrimaryKey(hostelBlockForm.getId());
            hostelBlockEntity.setAddrLine1(hostelBlockForm.getAddrLine1());
            hostelBlockEntity.setAddrLine2(hostelBlockForm.getAddrLine2());
            hostelBlockEntity.setAddrLine3(hostelBlockForm.getAddrLine3());
            hostelBlockEntity.setAddrLine4(hostelBlockForm.getAddrLine4());
            hostelBlockEntity.setCity(hostelBlockForm.getCity());
            hostelBlockEntity.setInchargeName(hostelBlockForm.getInchargeName());
            hostelBlockEntity.setMobile(hostelBlockForm.getMobile());
            hostelBlockEntity.setStateName(hostelBlockForm.getStateName());
            hostelBlockEntity.setZipCode(hostelBlockForm.getZipCode());
            hostelBlockEntity.setName(hostelBlockForm.getName());
            
            hostelBlockDao.update(hostelBlockEntity);
            hostelBlockForm.resetForm();
        }
        
        else if(hostelBlockForm.getPageName()!=null && hostelBlockForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            HostelBlockEntity hostelBlockEntity = new HostelBlockEntity();
            hostelBlockEntity.setAddrLine1(hostelBlockForm.getAddrLine1());
            hostelBlockEntity.setAddrLine2(hostelBlockForm.getAddrLine2());
            hostelBlockEntity.setAddrLine3(hostelBlockForm.getAddrLine3());
            hostelBlockEntity.setAddrLine4(hostelBlockForm.getAddrLine4());
            hostelBlockEntity.setCity(hostelBlockForm.getCity());
            hostelBlockEntity.setInchargeName(hostelBlockForm.getInchargeName());
            hostelBlockEntity.setMobile(hostelBlockForm.getMobile());
            hostelBlockEntity.setStateName(hostelBlockForm.getStateName());
            hostelBlockEntity.setZipCode(hostelBlockForm.getZipCode());
            hostelBlockEntity.setName(hostelBlockForm.getName());
            hostelBlockDao.persist(hostelBlockEntity);
            hostelBlockForm.resetForm();
        }
        
        List<HostelBlockEntity> hostelBlockList = hostelBlockDao.findAll();
        if(hostelBlockList != null){
            hostelBlockForm.setBlockEntitys(hostelBlockList);
        }
        req.setAttribute("hostelModule", "true");
        req.setAttribute("hostelBlockPage", "true");
        return mapping.findForward("hostelBlockPage");
    }
    
}












