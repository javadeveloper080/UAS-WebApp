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

@Entity(name = "ExamMaster")
@Table(name = "exam_master")
public class ExamMasterEntity implements Serializable {

	private static final long serialVersionUID = 1697959046486884851L;

	public static final String EXAMMASTER_FIND_ALL = "SELECT e FROM ExamMaster e";

	public static final String FIND_BY_USERMASTER_ID = "SELECT e FROM ExamMaster e where e.userMaster.userId=:userMasterId";
	
	public static final String FIND_BY_QUESTION_ID = "SELECT e FROM ExamMaster e where e.questionMaster.id=:questionMasterId";

	public static final String FIND_BY_COURSEID = "SELECT e FROM ExamMaster e where e.questionMaster.courseId.id=:courseId";

	public static final String FIND_BY_COURSE_USERID = "SELECT e FROM ExamMaster e where e.questionMaster.courseId.id=:courseId and userMaster.userId=:userId";
	
	public static final String GET_COUNT_BY_COURSEID = "SELECT count(e) FROM ExamMaster e where e.questionMaster.courseId.id=:courseId and userMaster.userId=:userId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@ManyToOne(optional = false, targetEntity = QuestionMasterEntity.class)
	@JoinColumn(name = "question_Id", referencedColumnName = "id", nullable = false, updatable = false)
	private QuestionMasterEntity questionMaster;
	
	@ManyToOne(optional = false, targetEntity = UserMasterEntity.class)
	@JoinColumn(name = "user_master_id", referencedColumnName = "id", nullable = false, updatable = false)
	private UserMasterEntity userMaster;

	@Column(name = "answer_number", nullable = false, length = 1)
	private int answerNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuestionMasterEntity getQuestionMaster() {
		return questionMaster;
	}

	public void setQuestionMaster(QuestionMasterEntity questionMaster) {
		this.questionMaster = questionMaster;
	}

	public UserMasterEntity getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMasterEntity userMaster) {
		this.userMaster = userMaster;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}
	
	

}
