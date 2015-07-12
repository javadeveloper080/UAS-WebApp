package org.edu.uams.client.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import org.edu.uams.server.api.MergeFieldConstants;

public class MergeDataSourceDTO {




	public MergeDataSourceDTO(String studentNumber, String fullname,
			String addressLine1, String addressLine2, String addressLine3,
			String addressLine4, String city, String stateName, String zipCode,
			String country, long studentMob, String emailAddress, String firstName,
			String lastName) {
		super();
		this.studentNumber = studentNumber;
		this.fullname = fullname;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.addressLine4 = addressLine4;
		this.city = city;
		this.stateName = stateName;
		this.postalCode = zipCode;
		this.country = country;
		this.telephoneNumber = studentMob+"";
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	private String studentNumber;

	private String fullname;

	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	private String addressLine4;
	
	private String city;

	private String stateName;

	private String postalCode;

	private String country;

	private String telephoneNumber;

	private String emailAddress;

	private String emailAddressLabel2;

	private String firstName;

	private String lastName;

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddressLabel2() {
		return emailAddressLabel2;
	}

	public void setEmailAddressLabel2(String emailAddressLabel2) {
		this.emailAddressLabel2 = emailAddressLabel2;
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

	
public Map<String, String> getDataSourceValueMap() {
        
        Map<String, String> mappedDataSource = new LinkedHashMap();
        
        mappedDataSource.put(MergeFieldConstants.STUDENT_NUMBER,String.valueOf(this.getStudentNumber()));
        mappedDataSource.put(MergeFieldConstants.FIRSTNAME,this.getFirstName() !=null ? this.getFirstName() : "");
        mappedDataSource.put(MergeFieldConstants.FULLNAME,this.getFullname() !=null ? this.getFullname() : "");
        mappedDataSource.put(MergeFieldConstants.LASTNAME,this.getLastName() !=null ? this.getLastName() : "");
        mappedDataSource.put(MergeFieldConstants.ADDRESSLINE1,this.getAddressLine1() != null ? this.getAddressLine1() : "");
        mappedDataSource.put(MergeFieldConstants.ADDRESSLINE2,this.getAddressLine2() != null ? this.getAddressLine2() : "");
        mappedDataSource.put(MergeFieldConstants.ADDRESSLINE3,this.getAddressLine3() != null ? this.getAddressLine3() : "");
        mappedDataSource.put(MergeFieldConstants.ADDRESSLINE4,this.getAddressLine4() != null ? this.getAddressLine4() : "");
        mappedDataSource.put(MergeFieldConstants.CITY, this.getCity() != null ? this.getCity() : "");
        mappedDataSource.put(MergeFieldConstants.STATECODE,this.getStateName() != null ? this.getStateName() : "");
        mappedDataSource.put(MergeFieldConstants.COUNTRY,this.getCountry() != null ? this.getCountry() : "");
        mappedDataSource.put(MergeFieldConstants.EMAILADDRESS,this.getEmailAddress() != null ? this.getEmailAddress() : "");
        mappedDataSource.put(MergeFieldConstants.TELEPHONENUMBER,this.getTelephoneNumber() != null ? this.getTelephoneNumber() : "");
        return mappedDataSource;
        
    }


}
