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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "SessionMaster")
@Table(name = "session_master")
public class SessionMasterEntity implements Serializable {

	private static final long serialVersionUID = 5100354077037342691L;

	public static final String SESSIONMASTER_FIND_ALL = "SELECT s FROM SessionMaster s";
	public static final String SESSIONMASTER_FIND_BY_COURSE_ID = "SELECT s FROM SessionMaster s where s.courseId=:courseMasterEntity";
	public static final String FIND_BY_SESSION_TOPIC = "SELECT s FROM SessionMaster s where s.topic=:topic";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id", unique = true, nullable = false)
	private long sessionId;

	@ManyToOne(optional = false, targetEntity = CourseMasterEntity.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
	private CourseMasterEntity courseId;

	@Column(name = "topic_name", nullable = false, length = 200)
	private String topicName;

	@Column(name = "topic", nullable = false, length = 200)
	private String topic;
	
	@Column(name = "topic_content", nullable = false)
	private String topicContent;

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public CourseMasterEntity getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the topicContent
	 */
	public String getTopicContent() {
		return topicContent;
	}

	/**
	 * @param topicContent the topicContent to set
	 */
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	
	

}
