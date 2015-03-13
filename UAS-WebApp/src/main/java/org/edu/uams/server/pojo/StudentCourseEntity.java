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


@Entity(name = "StudentCourse")
@Table(name = "student_course")
public class StudentCourseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4781688245002267614L;


	public static final  String  STUDENTCOURSE_FIND_ALL="SELECT s FROM StudentCourse s";


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

//	@ManyToOne(optional=false,targetEntity=UserMasterEntity.class) 
//	@JoinColumn(name = "user_master_id", referencedColumnName="id",nullable=false, updatable=false)
//	private UserMasterEntity userMaster;

	@ManyToOne(optional=false,targetEntity=CourseMasterEntity.class) 
	@JoinColumn(name = "course_id", referencedColumnName="id",nullable=false, updatable=false)
	private CourseMasterEntity courseId;
	
	@Column(name = "current_session", nullable = true, length =2)
	private long currentSession;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public UserMasterEntity getUserMaster() {
//		return userMaster;
//	}
//
//	public void setUserName(UserMasterEntity userMaster) {
//		this.userMaster = userMaster;
//	}

	public CourseMasterEntity getCourseId() {
		return courseId;
	}

	public void setCourse_id(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

	public long getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(long currentSession) {
		this.currentSession = currentSession;
	}



}
