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
import org.edu.uams.server.business.CourseTypeDao;
import org.edu.uams.server.business.DegreeTypeDao;
import org.edu.uams.server.business.FeeCategoryTypeDao;
import org.edu.uams.server.business.FeeTypeDao;
import org.edu.uams.server.pojo.CourseTypeEntity;
import org.edu.uams.server.pojo.DegreeTypeEntity;
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
            
            FeeTypeEntity feeTypeEntity = feeTypeDao.findByPrimaryKey(typeTableForm.getId());
            typeTableForm.resetForm();
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
        req.setAttribute("feeModule", "true");
        req.setAttribute("feeTypePage", "true");
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
            
            FeeCategoryTypeEntity feeCategoryType = feeCategoryTypeDao.findByPrimaryKey(typeTableForm.getId());
            typeTableForm.resetForm();
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
        req.setAttribute("feeModule", "true");
        req.setAttribute("feeCategoryTypePage", "true");
        return mapping.findForward("feeCategoryTypePage");
    }
    
    
    
    public ActionForward degreeTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TypeTableForm typeTableForm = (TypeTableForm)form;
        System.out.println("typeTableForm:"+typeTableForm.getPageName());
        DegreeTypeDao degreeTypeDao = new DegreeTypeDao();
        
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("GetEditTypeForm"))
        {
            
            DegreeTypeEntity degreeTypeEntity = degreeTypeDao.findByPrimaryKey(typeTableForm.getId());
            typeTableForm.resetForm();
            typeTableForm.setCode(degreeTypeEntity.getCode());
            typeTableForm.setDescription(degreeTypeEntity.getDescription());
            typeTableForm.setId(degreeTypeEntity.getId());
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitEditType"))
        {
            DegreeTypeEntity degreeTypeEntity = degreeTypeDao.findByPrimaryKey(typeTableForm.getId());
            degreeTypeEntity.setCode(typeTableForm.getCode());
            degreeTypeEntity.setDescription(typeTableForm.getDescription());
            degreeTypeDao.update(degreeTypeEntity);
            typeTableForm.resetForm();
            
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitAddType"))
        {
            DegreeTypeEntity degreeTypeEntity = new DegreeTypeEntity();
            degreeTypeEntity.setCode(typeTableForm.getCode());
            degreeTypeEntity.setDescription(typeTableForm.getDescription());
            degreeTypeDao.persist(degreeTypeEntity);
            typeTableForm.resetForm();
        }
        
        List<DegreeTypeEntity> degreeTypeList = degreeTypeDao.findAll();
        if(!degreeTypeList.isEmpty()){
            typeTableForm.setTypeFormList(degreeTypeList);
        }
        req.setAttribute("courseModule", "true");
        req.setAttribute("degreeTypePage", "true");
        return mapping.findForward("degreeTypePage");
    }
    
    
    public ActionForward courseTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        TypeTableForm typeTableForm = (TypeTableForm)form;
        System.out.println("typeTableForm:"+typeTableForm.getPageName());
        CourseTypeDao courseTypeDao = new CourseTypeDao();
        
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("GetEditTypeForm"))
        {
            
            CourseTypeEntity courseTypeEntity = courseTypeDao.findByPrimaryKey(typeTableForm.getId());
            typeTableForm.resetForm();
            typeTableForm.setCode(courseTypeEntity.getCode());
            typeTableForm.setDescription(courseTypeEntity.getDescription());
            typeTableForm.setId(courseTypeEntity.getId());
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitEditType"))
        {
            CourseTypeEntity courseTypeEntity = courseTypeDao.findByPrimaryKey(typeTableForm.getId());
            courseTypeEntity.setCode(typeTableForm.getCode());
            courseTypeEntity.setDescription(typeTableForm.getDescription());
            courseTypeDao.update(courseTypeEntity);
            typeTableForm.resetForm();
            
        }
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("SubmitAddType"))
        {
            CourseTypeEntity courseTypeEntity = new CourseTypeEntity();
            courseTypeEntity.setCode(typeTableForm.getCode());
            courseTypeEntity.setDescription(typeTableForm.getDescription());
            courseTypeDao.persist(courseTypeEntity);
            typeTableForm.resetForm();
        }
        
        List<CourseTypeEntity> courseTypeList = courseTypeDao.findAll();
        if(!courseTypeList.isEmpty()){
            typeTableForm.setTypeFormList(courseTypeList);
        }
        req.setAttribute("courseModule", "true");
        req.setAttribute("courseTypePage", "true");
        return mapping.findForward("courseTypePage");
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
        
        
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("DegreeType"))
        {
            DegreeTypeDao degreeTypeDao = new DegreeTypeDao();
            Type typeEntity =degreeTypeDao.findByCode(typeTableForm.getCode());
            checkUniqueCodeHelper(typeEntity, key, response);
        }
        if(typeTableForm.getPageName()!=null && typeTableForm.getPageName().equals("CourseType"))
        {
            CourseTypeDao courseTypeDao = new CourseTypeDao();
            Type typeEntity =courseTypeDao.findByCode(typeTableForm.getCode());
            checkUniqueCodeHelper(typeEntity, key, response);
        }
        
        
        
        return null;
    }
    
    private void checkUniqueCodeHelper(Type typeEntity, Long key, HttpServletResponse response) throws IOException {
        if (typeEntity!=null) {
            Long pkKey= typeEntity.getId();
            if (key!=null && key>0 && pkKey.equals(key)) {
                response.getWriter().write("false");
            }else{
                response.getWriter().write("true");
            }
        }else{
            response.getWriter().write("false");
        }
    }
    
    
    
}












