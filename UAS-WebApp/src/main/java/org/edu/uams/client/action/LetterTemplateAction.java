/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.client.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.edu.uams.client.form.LetterTemplateForm;
import org.edu.uams.server.api.DocType;
import org.edu.uams.server.api.Document;
import org.edu.uams.server.business.DocumentDao;
import org.edu.uams.server.business.GeneratedLettersDao;
import org.edu.uams.server.business.LetterTemplateDao;
import org.edu.uams.server.pojo.DocumentEntity;
import org.edu.uams.server.pojo.GeneratedLetterEntity;
import org.edu.uams.server.pojo.LetterTemplateEntity;
import org.edu.uams.server.util.DocumentConversion;
import org.edu.uams.server.util.XMLProcesser;


public class LetterTemplateAction  extends DispatchAction {





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
			if (letterTemplateEntity.getDocumentId()>0) {
				Document document=new DocumentDao().findByPrimaryKey(letterTemplateEntity.getDocumentId());
				if (document!=null) {
					letterTemplateForm.setTemplatefileName(document.getFileName());
				}
			}

			letterTemplateForm.setId(letterTemplateEntity.getId());
		}

		if(letterTemplateForm.getPageName()!=null && letterTemplateForm.getPageName().equals("SubmitEditType"))
		{
			if (!validateForm(letterTemplateForm)) {
				List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
				if(!letterTemplateEntityList.isEmpty()){
					letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
				}
				letterTemplateForm.setTemplatefile(letterTemplateForm.getTemplatefile());
				letterTemplateForm.setXmlfile(letterTemplateForm.getXmlfile());
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
				long documentId = this.pesistTemplateDocument(letterTemplateForm);
				letterTemplateEntity.setDocumentId(documentId);
			}
			letterTemplateEntity.setDocumentId(letterTemplateForm.getDocumentId());
			letterTemplateEntity=letterTemplateDao.update(letterTemplateEntity);
			String xmlFileString = new String(letterTemplateForm.getXmlfile().getFileData());
			this.processBatchLetters(letterTemplateDao, letterTemplateEntity,xmlFileString);
			letterTemplateForm.resetForm();

		}

		if(letterTemplateForm.getPageName()!=null && letterTemplateForm.getPageName().equals("SubmitAddType"))
		{
			if (!validateForm(letterTemplateForm)) {
				List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
				if(!letterTemplateEntityList.isEmpty()){
					letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
				}
				letterTemplateForm.setTemplatefile(letterTemplateForm.getTemplatefile());
				letterTemplateForm.setXmlfile(letterTemplateForm.getXmlfile());
				req.setAttribute("communicationModule", "true");
				req.setAttribute("letterTemplatePage", "true");
				return mapping.findForward("letterTemplatePage");
			}
			LetterTemplateEntity letterTemplateEntity = new LetterTemplateEntity();
			letterTemplateEntity.setCode(letterTemplateForm.getCode());
			letterTemplateEntity.setDescription(letterTemplateForm.getDescription());
			long documentId = this.pesistTemplateDocument(letterTemplateForm);
			letterTemplateEntity.setDocumentId(documentId);
			letterTemplateEntity=letterTemplateDao.persist(letterTemplateEntity);
			String xmlFileString = new String(letterTemplateForm.getXmlfile().getFileData());
			this.processBatchLetters(letterTemplateDao, letterTemplateEntity,xmlFileString);
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


		if( letterTemplateForm.getTemplatefile().getFileSize()== 0){
			letterTemplateForm.setMessage("Please select a letter template file to upload");
			return false;
		}

		//only allow textfile to upload
		if(!(DocType.doc.name().equals(letterTemplateForm.getTemplatefile().getContentType()) || !(DocType.docx.name().equals(letterTemplateForm.getTemplatefile().getContentType())))){
			letterTemplateForm.setMessage("Only .doc or .docx file is allow to upload");
			return false;
		}

		if( letterTemplateForm.getXmlfile().getFileSize()== 0){
			letterTemplateForm.setMessage("Please select a xml data file to upload");
			return false;
		}

		//only allow textfile to upload
		if(!"text/xml".equals(letterTemplateForm.getXmlfile().getContentType())){
			letterTemplateForm.setMessage("Only .xml file is allow to upload");
			return false;
		}

		//file size cant larger than 10kb
		/* if(letterTemplateForm.getFile().getFileSize() > 10240){ //10kb
            letterTemplateForm.setMessage("File size exceeds"+ 10240 +"bytes");
            return false;
        }*/

		return true;
	}



	public ActionForward generatedLetterPage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
			HttpServletResponse res)throws Exception
			{

		LetterTemplateForm letterTemplateForm = (LetterTemplateForm)form;
		System.out.println("typeTableForm:"+letterTemplateForm.getPageName());
		LetterTemplateDao letterTemplateDao = new LetterTemplateDao();


		long letterTemplateId=letterTemplateForm.getLetterTemplateId();

		if (letterTemplateId>0) {
			GeneratedLettersDao generatedLettersDao = new GeneratedLettersDao();
			List<GeneratedLetterEntity> generatedLetterList  = generatedLettersDao.findAllGeneratedLettersByTemplateId(letterTemplateId);
			if(generatedLetterList!=null && !generatedLetterList.isEmpty()){
				letterTemplateForm.setGeneratedTemplateList(generatedLetterList);
			}
		}

		List<LetterTemplateEntity> letterTemplateEntityList = letterTemplateDao.findAll();
		if(letterTemplateEntityList!=null && !letterTemplateEntityList.isEmpty()){
			letterTemplateForm.setLetterTemplateList(letterTemplateEntityList);
		}
		req.setAttribute("communicationModule", "true");
		req.setAttribute("generatedLetterPage", "true");
		return mapping.findForward("generatedLetterPage");
			}

	private  long pesistTemplateDocument(LetterTemplateForm letterTemplateForm) throws IOException {
		DocumentDao documentDao =new DocumentDao();

		FormFile file = letterTemplateForm.getTemplatefile();
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


	//asynchoronus process
	private  void processBatchLetters(final LetterTemplateDao letterTemplateDao,final LetterTemplateEntity letterTemplateEntity,final String xmlFileString){

		Runnable task = new Runnable() {

			@Override
			public void run() {
				try {
					letterTemplateDao.processBatchLetters(letterTemplateEntity,XMLProcesser.getReportDataMap(xmlFileString));
				} catch (Exception ex) {
					System.out.println("processBatchLetters failed");
					ex.printStackTrace();
					//handle error which cannot be thrown back
				}
			}
		};
		new Thread(task, "ServiceThread").start(); 
	}


	public ActionForward downloadFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		Long documentId=1l;

		if (request.getParameter("documentId")!=null) {
			documentId =new Long( request.getParameter("documentId"));
		}

		DocumentDao documentDao =new DocumentDao();
		DocumentEntity document=documentDao.findByPrimaryKey(documentId);

		if (document!=null) {
			String filePath = getServlet().getServletContext().getRealPath("/") +"upload";

			File path = new File(filePath);
			if (!path.isDirectory()) {
				path.mkdir();
			}
			File file = new File(path, document.getFileName());
			DocumentConversion.getFileFromBytes(document.getFileBytes(), file);

			FileInputStream in =new FileInputStream(file);

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment;filename="+document.getFileName());

			ServletOutputStream out = response.getOutputStream();

			byte[] outputByte = new byte[4096];
			while(in.read(outputByte, 0, 4096) != -1){
				out.write(outputByte, 0, 4096);
			}
			in.close();
			out.flush();
			out.close();

		}
		return null;
	}


}
