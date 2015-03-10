package org.edu.uams.server.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserMaster")
@Table(name = "user_master")
public class UserMasterEntity implements Serializable {

	private static final long serialVersionUID = 8949487620455307771L;

	public static final String USER_MASTER_FIND_ALL = "SELECT u FROM UserMaster u";
	public static final String FIND_USERNAME = "SELECT u FROM UserMaster u where u.email=:email ";


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long userId;

	@ManyToOne(optional = false, targetEntity = UserMasterTypeEntity.class)
	@JoinColumn(name = "user_master_type_id", referencedColumnName = "id", nullable = false, updatable = false)
	private UserMasterTypeEntity userMasterType;

	@Column(name = "pass_word", nullable = false, length = 15)
	private String passWord;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "address_line1", nullable = true)
	private String addressLine1;
	
	@Column(name = "address_line2", nullable = true)
	private String addressLine2;

	@Column(name = "gender", nullable = true)
	private String gender;

	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "state", nullable = true)
	private String state;
	
	@Column(name = "country", nullable = true)
	private String country;
	
	@Column(name = "pin", nullable = true)
	private long pin;
	
	@Column(name = "mobile", nullable = true)
	private long mobile;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserMasterTypeEntity getUserMasterType() {
		return userMasterType;
	}

	public void setUserMasterType(UserMasterTypeEntity userMasterType) {
		this.userMasterType = userMasterType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

}
