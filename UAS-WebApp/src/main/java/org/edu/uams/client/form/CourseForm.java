/**
 * 
 */
package org.edu.uams.client.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * @author Syed Yaseer
 *
 */
public class CourseForm extends ActionForm {
	
	private String courseName;
	private String category;
	private Integer sessions;
	
	private String courseAddedMessage;
	
	private String courseContentMessage;
	
	private List courseList;
	
	private String pageName;
	
	private Long courId;
	
	private List sessList;
	
	private String topic;
	
	private String topicName;
	
	private Long sessionId;
	
	private String topicContent;
	
	private FormFile file;
	
	private String displayTopic;
	
	
	 
    public String getDisplayTopic() {
		return displayTopic;
	}

	public void setDisplayTopic(String displayTopic) {
		this.displayTopic = displayTopic;
	}

	public FormFile getFile() {
        return file;
    }
 
    public void setFile(FormFile file) {
        this.file = file;
    }
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the sessions
	 */
	public Integer getSessions() {
		return sessions;
	}
	/**
	 * @param sessions the sessions to set
	 */
	public void setSessions(Integer sessions) {
		this.sessions = sessions;
	}
	/**
	 * @return the courseAddedMessage
	 */
	public String getCourseAddedMessage() {
		return courseAddedMessage;
	}
	/**
	 * @param courseAddedMessage the courseAddedMessage to set
	 */
	public void setCourseAddedMessage(String courseAddedMessage) {
		this.courseAddedMessage = courseAddedMessage;
	}
	/**
	 * @return the courseList
	 */
	public List getCourseList() {
		return courseList;
	}
	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(List courseList) {
		this.courseList = courseList;
	}
	/**
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}
	/**
	 * @param pageName the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	/**
	 * @return the courId
	 */
	public Long getCourId() {
		return courId;
	}
	/**
	 * @param courId the courId to set
	 */
	public void setCourId(Long courId) {
		this.courId = courId;
	}
	/**
	 * @return the sessList
	 */
	public List getSessList() {
		return sessList;
	}
	/**
	 * @param sessList the sessList to set
	 */
	public void setSessList(List sessList) {
		this.sessList = sessList;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the sessionId
	 */
	public Long getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
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
	/**
	 * @return the courseContentMessage
	 */
	public String getCourseContentMessage() {
		return courseContentMessage;
	}
	/**
	 * @param courseContentMessage the courseContentMessage to set
	 */
	public void setCourseContentMessage(String courseContentMessage) {
		this.courseContentMessage = courseContentMessage;
	}
	/**
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}
	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
	

}
