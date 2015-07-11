package org.edu.uams.client.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.edu.uams.client.form.FileUploadForm;
import org.edu.uams.server.business.DocumentDao;
import org.edu.uams.server.pojo.DocumentEntity;
import org.edu.uams.server.util.DocumentConversion;

public class FileUploadAction extends DispatchAction{
    
    public ActionForward uploadFile(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        FileUploadForm fileUploadForm = (FileUploadForm)form;
        pesistDocument(fileUploadForm);
        
        return mapping.findForward("uploadFileSuccess");
    }

    public static long pesistDocument(FileUploadForm fileUploadForm) throws IOException {
        DocumentDao documentDao =new DocumentDao();
        
        FormFile file = fileUploadForm.getFile();
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
            
            
            File path = new File("docs");
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

