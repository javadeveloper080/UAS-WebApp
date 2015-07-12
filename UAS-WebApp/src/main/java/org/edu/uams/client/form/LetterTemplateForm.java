 /**
  *
  */
package org.edu.uams.client.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
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
    private List generatedTemplateList;
    private long documentId;
    private FormFile templatefile;
    private String templatefileName;
    private String templatefileId;
    private FormFile xmlfile;
    private String message ;
    private long letterTemplateId;
    
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
    
    
    
    public FormFile getTemplatefile() {
		return templatefile;
	}

	public void setTemplatefile(FormFile templatefile) {
		this.templatefile = templatefile;
	}

	public FormFile getXmlfile() {
		return xmlfile;
	}

	public void setXmlfile(FormFile xmlfile) {
		this.xmlfile = xmlfile;
	}

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
        this.xmlfile=null;
        this.templatefile=null;
        this.message = null;
        this.templatefileName = null;
		this.templatefileId = null;
    }

	public String getTemplatefileName() {
		return templatefileName;
	}

	public void setTemplatefileName(String templatefileName) {
		this.templatefileName = templatefileName;
	}

	public String getTemplatefileId() {
		return templatefileId;
	}

	public void setTemplatefileId(String templatefileId) {
		this.templatefileId = templatefileId;
	}

	public long getLetterTemplateId() {
		return letterTemplateId;
	}

	public void setLetterTemplateId(long letterTemplateId) {
		this.letterTemplateId = letterTemplateId;
	}

	public List getGeneratedTemplateList() {
		return generatedTemplateList;
	}

	public void setGeneratedTemplateList(List generatedTemplateList) {
		this.generatedTemplateList = generatedTemplateList;
	}
    
    
}
