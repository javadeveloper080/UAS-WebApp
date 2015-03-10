package org.edu.uams.server.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "ForumMaster")
@Table(name = "forum_master")
public class ForumMasterEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "SELECT e FROM ForumMaster e";

	public static final String FIND_BY_USER_ID = "SELECT e FROM ForumMaster e where e.owner.userId=:userId";

	public static final String FIND_BY_COURSE_ID = "SELECT e FROM ForumMaster e where e.courseId.id=:courseId";
	
	public static final String FIND_BY_COURSE_USERID = "SELECT e FROM ForumMaster e where courseId.id=:courseId and owner.userId=:userId";


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "forum_name", nullable = false,length=100)
	private String forumName;

	@ManyToOne(optional = false, targetEntity = CourseMasterEntity.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
	private CourseMasterEntity courseId;


	@ManyToOne(optional=false,targetEntity=UserMasterEntity.class) 
	@JoinColumn(name = "owner", referencedColumnName="id",nullable=false, updatable=false)
	private UserMasterEntity owner;

	@Column(name = "topic", nullable = false,length=1024)
	private String topic;
	
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public CourseMasterEntity getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

	public UserMasterEntity getOwner() {
		return owner;
	}

	public void setOwner(UserMasterEntity owner) {
		this.owner = owner;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


}
