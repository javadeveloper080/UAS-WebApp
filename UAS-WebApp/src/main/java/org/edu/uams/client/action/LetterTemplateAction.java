/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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
import org.apache.struts.upload.FormFile;
import org.edu.uams.client.form.LetterTemplateForm;
import org.edu.uams.server.api.DocType;
import org.edu.uams.server.business.DocumentDao;
import org.edu.uams.server.business.LetterTemplateDao;
import org.edu.uams.server.pojo.DocumentEntity;
import org.edu.uams.server.pojo.LetterTemplateEntity;


public class LetterTemplateAction  extends DispatchAction {
    
    public ActionForward forwardletterTemplatePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        return mapping.findForward("forwardletterTemplatePage");
    }
    
    
    public ActionForward letterTemplatePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        LetterTemplateForm letterTemplateForm = (LetterTemplateForm)form;
        System.out.println("typeTableForm:"+letterTemplateForm.getPageName());
        LetterTemplateDao letterTemplateDao = new LetterTemplateDao();
        
        if(letterTemplateForm.getPageName()!=null && letterTemplateForm.getPageName().equals("GetEditTypeForm"))
        {
            LetterTemplateEntity letterTemplateEntity = letterTemplateDao.findByPrimaryKey(letterTemplateForm.getId());
            letterTemplateForm.resetForm();
            letterTemplateForm.setCode(letterTemplateEntity.getCode());
            letterTemplateForm.setDescription(letterTemplateEntity.getDescription());
            letterTemplateForm.setDocumentId(letterTemplateEntity.getDocumentId());
            letterTemplateForm.setId(letterTemplateEntity.getId());
        }
        
        if(letterTemplateForm.getPageName()!=null && letterTemplateForm.getPageName().equals("SubmitEditType"))
        {
            if (!validateForm(letterTemplateForm)) {
                List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
                if(!letterTemplateEntityList.isEmpty()){
                    letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
                }
                req.setAttribute("communicationModule", "true");
                req.setAttribute("letterTemplatePage", "true");
                return mapping.findForward("letterTemplatePage");
            }
            LetterTemplateEntity letterTemplateEntity = letterTemplateDao.findByPrimaryKey(letterTemplateForm.getId());
            letterTemplateEntity.setCode(letterTemplateForm.getCode());
            letterTemplateEntity.setDescription(letterTemplateForm.getDescription());
            Long formDocumentId=letterTemplateForm.getDocumentId();
            Long savedDocumentId=letterTemplateEntity.getDocumentId();
            
            if (!formDocumentId.equals(savedDocumentId)) {
                long documentId = this.pesistDocument(letterTemplateForm);
                letterTemplateEntity.setDocumentId(documentId);
            }
            letterTemplateEntity.setDocumentId(letterTemplateForm.getDocumentId());
            letterTemplateDao.update(letterTemplateEntity);
            letterTemplateForm.resetForm();
            
        }
        
        if(letterTemplateForm.getPageName()!=null && letterTemplateForm.getPageName().equals("SubmitAddType"))
        {
            if (!validateForm(letterTemplateForm)) {
                List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
                if(!letterTemplateEntityList.isEmpty()){
                    letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
                }
                req.setAttribute("communicationModule", "true");
                req.setAttribute("letterTemplatePage", "true");
                return mapping.findForward("letterTemplatePage");
            }
            LetterTemplateEntity letterTemplateEntity = new LetterTemplateEntity();
            letterTemplateEntity.setCode(letterTemplateForm.getCode());
            letterTemplateEntity.setDescription(letterTemplateForm.getDescription());
            long documentId = this.pesistDocument(letterTemplateForm);
            letterTemplateEntity.setDocumentId(documentId);
            letterTemplateDao.persist(letterTemplateEntity);
            letterTemplateForm.resetForm();
        }
        
        
        List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
        if(!letterTemplateEntityList.isEmpty()){
            letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
        }
        req.setAttribute("communicationModule", "true");
        req.setAttribute("letterTemplatePage", "true");
        return mapping.findForward("letterTemplatePage");
    }
    
    public boolean validateForm(LetterTemplateForm letterTemplateForm) {
        
        
        if( letterTemplateForm.getFile().getFileSize()== 0){
            letterTemplateForm.setMessage("Please select a file to upload");
            return false;
        }
        
        //only allow textfile to upload
        if(!(DocType.doc.name().equals(letterTemplateForm.getFile().getContentType()) || !(DocType.docx.name().equals(letterTemplateForm.getFile().getContentType())))){
            letterTemplateForm.setMessage("Only text file is allow to upload");
            return false;
        }
        
        //file size cant larger than 10kb
        if(letterTemplateForm.getFile().getFileSize() > 10240){ //10kb
            letterTemplateForm.setMessage("File size exceeds"+ 10240 +"bytes");
            return false;
        }
        
        return true;
    }
    public  long pesistDocument(LetterTemplateForm letterTemplateForm) throws IOException {
        DocumentDao documentDao =new DocumentDao();
        
        FormFile file = letterTemplateForm.getFile();
        String fileName = file.getFileName();
        String contentType = file.getContentType();
        DocumentEntity documentEntity=new DocumentEntity();
        documentEntity.setFileName(fileName);
        documentEntity.setMimeType(contentType);
        documentEntity.setFileBytes(file.getFileData());
        DocumentEntity persistedEntity = documentDao.persist(documentEntity);
        System.out.println("Done");
        System.out.println(persistedEntity.getId());
        return persistedEntity.getId();
    }
    
    
}
