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

@Entity(name = "ResultMaster")
@Table(name = "result_master")
public class ResultMasterEntity implements Serializable {

	private static final long serialVersionUID = 2581293899852124378L;

	public static final String RESULTMASTER_FIND_ALL = "SELECT e FROM ResultMaster e";

	public static final String USERMASTERID = "SELECT e FROM ResultMaster e where e.userName.id=:userMasterId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@ManyToOne(optional = false, targetEntity = CourseMasterEntity.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
	private CourseMasterEntity courseId;

//	@ManyToOne(optional=false,targetEntity=UserMasterEntity.class) 
//	@JoinColumn(name = "user_name_id", referencedColumnName="id",nullable=false, updatable=false)
//	private UserMasterEntity userName;
	
	@Column(name = "percentage", nullable = false, length =4)
	private double percentage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CourseMasterEntity getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

//	public UserMasterEntity getUserName() {
//		return userName;
//	}
//
//	public void setUserName(UserMasterEntity userName) {
//		this.userName = userName;
//	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	

}
