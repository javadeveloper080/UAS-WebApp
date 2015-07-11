 /**
  *
  */
package org.edu.uams.client.form;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;


public class LetterTemplateForm extends ActionForm {
    
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String description;
    private long id;
    private String code;
    private String pageName;
    private List letterTemplateList;
    private long documentId;
    private FormFile file;
    private String message ;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public List getLetterTemplateList() {
        return letterTemplateList;
    }
    
    public void setLetterTemplateList(List letterTemplateList) {
        this.letterTemplateList = letterTemplateList;
    }
    
    public long getDocumentId() {
        return documentId;
    }
    
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    
    
    
    public FormFile getFile() {
        return file;
    }
    
    public void setFile(FormFile file) {
        this.file = file;
    }
    
//    public ActionErrors validateForm(ActionMapping mapping,
//            HttpServletRequest request) {
//
//        ActionErrors errors = new ActionErrors();
//
//        if( getFile().getFileSize()== 0){
//            errors.add("common.file.err",
//                    new ActionMessage("error.common.file.required"));
//            return errors;
//        }
//
//        //only allow textfile to upload
//        if(!"text/plain".equals(getFile().getContentType())){
//            errors.add("common.file.err.ext",
//                    new ActionMessage("error.common.file.textfile.only"));
//            return errors;
//        }
//
//        //file size cant larger than 10kb
//        System.out.println(getFile().getFileSize());
//        if(getFile().getFileSize() > 10240){ //10kb
//            errors.add("common.file.err.size",
//                    new ActionMessage("error.common.file.size.limit", 10240));
//            return errors;
//        }
//
//        return errors;
//    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void resetForm() {
        this.pageName = null;
        this.code = null;
        this.description = null;
        this.letterTemplateList = null;
        this.id = 0l;
        this.documentId = 0l;
        this.file=null;
        this.message = null;
    }
    
    
}
