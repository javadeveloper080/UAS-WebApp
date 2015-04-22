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
import org.edu.uams.client.form.HostelRoomDetailsForm;
import org.edu.uams.server.api.ApplicationConstants;
import org.edu.uams.server.business.HostelBlockDao;
import org.edu.uams.server.business.HostelRoomDetailsDao;
import org.edu.uams.server.pojo.HostelBlockEntity;
import org.edu.uams.server.pojo.HostelRoomDetailsEntity;


public class HostelRoomDetailAction extends DispatchAction {
    
    
    
    
    public ActionForward hostelRoomPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        HostelRoomDetailsForm hostelRoomDetailsForm = (HostelRoomDetailsForm)form;
        HostelBlockDao hostelBlockDao = new HostelBlockDao();
        HostelRoomDetailsDao detailsDao = new HostelRoomDetailsDao();
                
        if(hostelRoomDetailsForm.getPageName()!=null && hostelRoomDetailsForm.getPageName().equals(ApplicationConstants.GET_EDIT_TYPE_FORM))
        {
            HostelRoomDetailsEntity detailsEntity = detailsDao.findByPrimaryKey(hostelRoomDetailsForm.getId());
            hostelRoomDetailsForm.resetForm();
            hostelRoomDetailsForm.setId(detailsEntity.getId());
            hostelRoomDetailsForm.sethBlockId(detailsEntity.getBlockEntity().getId());
            hostelRoomDetailsForm.setRoomCapacity(detailsEntity.getRoomCapacity());
            hostelRoomDetailsForm.setRoomDescription(detailsEntity.getRoomDescription());
            hostelRoomDetailsForm.setRoomImage(detailsEntity.getRoomImage());
            hostelRoomDetailsForm.setRoomName(detailsEntity.getRoomName());
            hostelRoomDetailsForm.setRoomPrice(detailsEntity.getRoomPrice());
            hostelRoomDetailsForm.setRoomType(detailsEntity.getRoomType());
        }
        
        else if(hostelRoomDetailsForm.getPageName()!=null && hostelRoomDetailsForm.getPageName().equals(ApplicationConstants.SUBMIT_EDIT_TYPE))
        {
            HostelBlockEntity hostelBlockEntity = hostelBlockDao.findByPrimaryKey(hostelRoomDetailsForm.gethBlockId());
            HostelRoomDetailsEntity detailsEntity = detailsDao.findByPrimaryKey(hostelRoomDetailsForm.getId());
            detailsEntity.setBlockEntity(hostelBlockEntity);
            detailsEntity.setRoomCapacity(hostelRoomDetailsForm.getRoomCapacity());
            detailsEntity.setRoomDescription(hostelRoomDetailsForm.getRoomDescription());
            detailsEntity.setRoomImage(hostelRoomDetailsForm.getRoomImage());
            detailsEntity.setRoomName(hostelRoomDetailsForm.getRoomName());
            detailsEntity.setRoomPrice(hostelRoomDetailsForm.getRoomPrice());
            detailsEntity.setRoomType(hostelRoomDetailsForm.getRoomType());
            
            detailsDao.update(detailsEntity);
            hostelRoomDetailsForm.resetForm();
        }
        
        else if(hostelRoomDetailsForm.getPageName()!=null && hostelRoomDetailsForm.getPageName().equals(ApplicationConstants.SUBMIT_ADD_TYPE))
        {
            HostelRoomDetailsEntity detailsEntity = new HostelRoomDetailsEntity();
           
            HostelBlockEntity hostelBlockEntity = hostelBlockDao.findByPrimaryKey(hostelRoomDetailsForm.gethBlockId());
            detailsEntity.setBlockEntity(hostelBlockEntity);
            detailsEntity.setRoomCapacity(hostelRoomDetailsForm.getRoomCapacity());
            detailsEntity.setRoomDescription(hostelRoomDetailsForm.getRoomDescription());
            detailsEntity.setRoomImage(hostelRoomDetailsForm.getRoomImage());
            detailsEntity.setRoomName(hostelRoomDetailsForm.getRoomName());
            detailsEntity.setRoomPrice(hostelRoomDetailsForm.getRoomPrice());
            detailsEntity.setRoomType(hostelRoomDetailsForm.getRoomType());
            
            detailsDao.persist(detailsEntity);
            hostelRoomDetailsForm.resetForm();
        }
        
        List<HostelRoomDetailsEntity> hostelRoomList = detailsDao.findAll();
        if(hostelRoomList != null){
            hostelRoomDetailsForm.setRoomDetailsEntitys(hostelRoomList);
        }
        
        
        List<HostelBlockEntity> hostelBlockList = hostelBlockDao.findAll();
        if(hostelBlockList != null){
            hostelRoomDetailsForm.setBlockEntitys(hostelBlockList);
        }
        
        req.setAttribute("hostelModule", "true");
        req.setAttribute("hostelRoomPage", "true");
        return mapping.findForward("hostelRoomPage");
    }
    
}











