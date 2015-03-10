package org.edu.uams.server.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UserMasterType")
@Table(name = "User_master_type")
public class UserMasterTypeEntity implements Serializable {

	public UserMasterTypeEntity(String value) {
		super();
		this.value = value;
	}
	
	public UserMasterTypeEntity() {
	}

	private static final long serialVersionUID = -918161370208301734L;

	public static final String USERMASTERTYPE_FIND_ALL = "SELECT t FROM UserMasterType t";
	public static final String USERMASTERTYPE_FINDBYVALUE = "SELECT t FROM UserMasterType t where t.value=:value";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "value", unique = true, nullable = false)
	private String value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
