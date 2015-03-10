/**
 * 
 */
package org.edu.uams.client.form;

import org.apache.struts.action.ActionForm;

public class AdminForm extends ActionForm {

	private static final long serialVersionUID = 2478335224498992172L;

	private long adminId;

	private String adminName;

	private String passWord;

	private String email;
	
	private String  message;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
