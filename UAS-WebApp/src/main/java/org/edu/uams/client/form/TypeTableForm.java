 /**
  *
  */
package main.java.org.edu.uams.client.form;

import org.apache.struts.action.ActionForm;


public class TypeTableForm extends ActionForm {
    
    
    private String description;
    private long id;
    private String code;

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
    
}
