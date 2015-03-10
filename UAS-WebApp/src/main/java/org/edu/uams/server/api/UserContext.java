package org.edu.uams.server.api;

import org.edu.uams.client.form.LoginForm;

public class UserContext {

	public UserContext() {
		super();
	}

	public UserContext(long userId, String userName,boolean isAdmin,LoginForm loginForm,String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.isAdmin=isAdmin;
		this.loginForm=loginForm;
		this.userType=userType;
	}

	private long userId;

	private String userName;
	
	private boolean isAdmin;
	
	private String userType;
	
	private LoginForm loginForm;


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserContext other = (UserContext) obj;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}


}
