/**
 * 
 */
package org.edu.uams.client.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.edu.uams.client.dto.ForumSubscribersDTO;

public class ForumMasterForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Long forumId;

	private String forumName;

	private String topic;

	private Long courseId;

	private String courseKey;

	private List courseKeyList;

	private List<ForumSubscribersDTO> forumSubscribersDTOList;

	private String ownerName;
	
	private String comment;
	
	private List forumMasterList;

	private Date createdOn;

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseKey() {
		return courseKey;
	}

	public void setCourseKey(String courseKey) {
		this.courseKey = courseKey;
	}

	public List getCourseKeyList() {
		return courseKeyList;
	}

	public void setCourseKeyList(List courseKeyList) {
		this.courseKeyList = courseKeyList;
	}

	public void setForumSubscribersDTOList(List<ForumSubscribersDTO> forumSubscribersDTOList) {
		this.forumSubscribersDTOList=forumSubscribersDTOList;		
	}

	public List<ForumSubscribersDTO> getForumSubscribersDTOList() {
		return forumSubscribersDTOList;
	}

	public void seOwnerName(String ownerName) {
		this.ownerName=ownerName;		
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List getForumMasterList() {
		return forumMasterList;
	}

	public void setForumMasterList(List forumMasterList) {
		this.forumMasterList = forumMasterList;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn=createdOn;
		
	}

	public Date getCreatedOn() {
		return createdOn;
	}



}
