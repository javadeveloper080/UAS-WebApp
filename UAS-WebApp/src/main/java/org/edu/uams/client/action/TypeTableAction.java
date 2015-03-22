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
import org.edu.uams.client.form.TypeTableForm;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.pojo.FeeTypeEntity;


public class TypeTableAction extends DispatchAction {
    
    
    
    
    public ActionForward feeTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        try {
            
            
            TypeTableForm typeTableForm = (TypeTableForm)form;
            System.out.println("typeTableForm:"+typeTableForm.getPageName());
            FeeTypeDao feeTypeDao = new FeeTypeDao();
            
            
            if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("GetEditTypeForm"))
            {
                typeTableForm.resetForm();
                FeeTypeEntity feeTypeEntity = feeTypeDao.findByPrimaryKey(typeTableForm.getId());
                typeTableForm.setCode(feeTypeEntity.getCode());
                typeTableForm.setDescription(feeTypeEntity.getDescription());
                typeTableForm.setId(feeTypeEntity.getId());
            }
            
            if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitEditType"))
            {
                FeeTypeEntity feeTypeEntity = feeTypeDao.findByPrimaryKey(typeTableForm.getId());
                feeTypeEntity.setCode(typeTableForm.getCode());
                feeTypeEntity.setDescription(typeTableForm.getDescription());
                feeTypeDao.update(feeTypeEntity);
                typeTableForm.resetForm();
            }
            
            if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitAddType"))
            {
                FeeTypeEntity feeTypeEntity = new FeeTypeEntity();
                feeTypeEntity.setCode(typeTableForm.getCode());
                feeTypeEntity.setDescription(typeTableForm.getDescription());
                feeTypeDao.persist(feeTypeEntity);
                typeTableForm.resetForm();
            }
            
            List<FeeTypeEntity> feeTypeList = feeTypeDao.findAll();
            if(!feeTypeList.isEmpty()){
                typeTableForm.setTypeFormList(feeTypeList);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapping.findForward("feeTypePage");
    }
    
    
    public ActionForward checkUniqueCode(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TypeTableForm typeTableForm = (TypeTableForm)form;
        response.setContentType("text/text;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("FeeType"))
        {
            FeeTypeDao feeTypeDao = new FeeTypeDao();
            FeeTypeEntity feeTypeEntity =feeTypeDao.findByCode(typeTableForm.getCode());
            if (feeTypeEntity!=null) {
                response.getWriter().write("true");
            }else{
                response.getWriter().write("false");
            }
        }
        return null;
    }
    
    
    
}












