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

@Entity(name = "ForumSubscriber")
@Table(name = "forum_subscriber")
public class ForumSubscribersEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1697959046486884851L;

	public static final String FIND_ALL = "SELECT e FROM ForumSubscriber e";

	public static final String FIND_BY_SUBSCRIBER_ID = "SELECT e FROM ForumSubscriber e where e.subscriber.userId=:userId";

	public static final String FIND_BY_FORUM_MASTER = "SELECT e FROM ForumSubscriber e where e.forumMasterId.id=:forumMasterId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;


	@ManyToOne(optional=false,targetEntity=UserMasterEntity.class) 
	@JoinColumn(name = "subscriber", referencedColumnName="id",nullable=false, updatable=false)
	private UserMasterEntity subscriber;

	@ManyToOne(optional = false, targetEntity = ForumMasterEntity.class)
	@JoinColumn(name = "forum_master_id", referencedColumnName = "id", nullable = false, updatable = false)
	private ForumMasterEntity forumMasterId;

	@Column(name = "comment", nullable = false,length=160)
	private String comment;
	
	@Column(name = "comment_on", nullable = false)
	private Date commentOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserMasterEntity getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(UserMasterEntity subscriber) {
		this.subscriber = subscriber;
	}

	public ForumMasterEntity getForumMasterId() {
		return forumMasterId;
	}

	public void setForumMasterId(ForumMasterEntity forumMasterId) {
		this.forumMasterId = forumMasterId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentOn() {
		return commentOn;
	}

	public void setCommentOn(Date commentOn) {
		this.commentOn = commentOn;
	}

	

}
