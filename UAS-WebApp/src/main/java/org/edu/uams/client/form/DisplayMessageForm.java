/**
 * 
 */
package org.edu.uams.client.form;

import org.apache.struts.action.ActionForm;

public class DisplayMessageForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String  message;

	

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
