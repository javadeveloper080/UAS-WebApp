 /**
  *
  */
package org.edu.uams.client.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.edu.uams.client.form.TypeTableForm;
import org.edu.uams.server.api.Type;
import org.edu.uams.server.business.FeeCategoryTypeDao;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.pojo.FeeCategoryTypeEntity;
import org.edu.uams.server.pojo.FeeTypeEntity;


public class TypeTableAction extends DispatchAction {
    
    
    
    
    public ActionForward feeTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
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
        
        return mapping.findForward("feeTypePage");
    }
    
    
    public ActionForward feeCategoryTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        TypeTableForm typeTableForm = (TypeTableForm)form;
        System.out.println("typeTableForm:"+typeTableForm.getPageName());
        FeeCategoryTypeDao feeCategoryTypeDao = new FeeCategoryTypeDao();
        
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("GetEditTypeForm"))
        {
            typeTableForm.resetForm();
            FeeCategoryTypeEntity feeCategoryType = feeCategoryTypeDao.findByPrimaryKey(typeTableForm.getId());
            typeTableForm.setCode(feeCategoryType.getCode());
            typeTableForm.setDescription(feeCategoryType.getDescription());
            typeTableForm.setId(feeCategoryType.getId());
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitEditType"))
        {
            FeeCategoryTypeEntity feeCategoryType = feeCategoryTypeDao.findByPrimaryKey(typeTableForm.getId());
            feeCategoryType.setCode(typeTableForm.getCode());
            feeCategoryType.setDescription(typeTableForm.getDescription());
            feeCategoryTypeDao.update(feeCategoryType);
            typeTableForm.resetForm();
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitAddType"))
        {
            FeeCategoryTypeEntity feeCategoryType = new FeeCategoryTypeEntity();
            feeCategoryType.setCode(typeTableForm.getCode());
            feeCategoryType.setDescription(typeTableForm.getDescription());
            feeCategoryTypeDao.persist(feeCategoryType);
            typeTableForm.resetForm();
        }
        
        List<FeeCategoryTypeEntity> feeCategoryTypeList = feeCategoryTypeDao.findAll();
        typeTableForm.setTypeFormList(null);
        if(!feeCategoryTypeList.isEmpty()){
            typeTableForm.setTypeFormList(feeCategoryTypeList);
        }
        
        return mapping.findForward("feeCategoryTypePage");
    }
    
    
    public ActionForward checkUniqueCode(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TypeTableForm typeTableForm = (TypeTableForm)form;
        response.setContentType("text/text;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        
        Long key = typeTableForm.getId();
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("FeeType"))
        {
            FeeTypeDao feeTypeDao = new FeeTypeDao();
            Type typeEntity =feeTypeDao.findByCode(typeTableForm.getCode());
            checkUniqueCodeHelper(typeEntity, key, response);
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("FeeCategoryType"))
        {
            FeeCategoryTypeDao feeCategoryTypeDao = new FeeCategoryTypeDao();
            Type typeEntity =feeCategoryTypeDao.findByCode(typeTableForm.getCode());
            checkUniqueCodeHelper(typeEntity, key, response);
        }
        return null;
    }
    
    private void checkUniqueCodeHelper(Type typeEntity, Long key, HttpServletResponse response) throws IOException {
        if (typeEntity!=null) {
            Long pkKey= typeEntity.getId();
            if (key!=null && key>0 && !pkKey.equals(key)) {
                response.getWriter().write("true");
            }else{
                response.getWriter().write("false");
            }
        }else{
            response.getWriter().write("false");
        }
    }
    
    
    
}












