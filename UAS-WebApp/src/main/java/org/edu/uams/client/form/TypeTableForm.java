/**
 *
 */
package org.edu.uams.client.form;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class TypeTableForm extends ActionForm {
    
    
    private String description;
    private long id;
    private String code;
    private String pageName;
    
    private List typeFormList;
    
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
    
    public List getTypeFormList() {
        return typeFormList;
    }
    
    public void setTypeFormList(List typeFormList) {
        this.typeFormList = typeFormList;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    
    public void resetForm() {
        this.pageName = null;
        this.code = null;
        this.description = null;
        this.typeFormList = null;
        this.id = 0l;
    }
    
//    @Override
//    public void reset(ActionMapping mapping, HttpServletRequest request) {
//        this.pageName = null;
//        this.code = null;
//        this.description = null;
//        this.typeFormList = null;
//        this.id = 0l;
//    }
}
