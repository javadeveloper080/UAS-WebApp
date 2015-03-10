/**
 * 
 */
package org.edu.uams.client.dto;

import java.util.Date;


public class ForumSubscribersDTO  {
	
	private String comment;
	private String subscriberName;
	private Date commentedOn;
	

	public ForumSubscribersDTO() {
	}

	public ForumSubscribersDTO(String comment, String subscriberName) {
		super();
		this.subscriberName = subscriberName;
		this.comment = comment;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public void setCommentedOn(Date commentOn) {
		this.commentedOn=commentOn;
		
	}

	public Date getCommentedOn() {
		return commentedOn;
	}

	
}
