package org.edu.uams.server.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Admin")
@Table(name = "admin")
public class AdminEntity implements Serializable {

	private static final long serialVersionUID = 6681266362470155697L;
	public static final String ADMIN_FIND_ALL = "SELECT a FROM Admin a";
	public static final String ADMIN_USERNAME = "SELECT a FROM Admin a where a.adminName=:adminName ";
	public static final String GET_SUPER_ADMIN = "SELECT a FROM Admin a where a.isSuperAdmin=true ";
	public static final String FIND_BY_ADMIN_LOGIN_NAME = "SELECT a FROM Admin a where a.adminName=:adminName and a.passWord=:passWord ";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "pass_word", nullable = false)
	private String passWord;

	@Column(name = "admin_Name", nullable = false, unique = true)
	private String adminName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "is_super_admin", nullable = false)
	private boolean isSuperAdmin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
