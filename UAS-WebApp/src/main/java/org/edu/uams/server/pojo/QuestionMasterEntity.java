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

@Entity(name = "QuestionMaster")
@Table(name = "question_master")
public class QuestionMasterEntity implements Serializable {

	private static final long serialVersionUID = 1697959046486884851L;

	public static final String FIND_ALL = "SELECT e FROM QuestionMaster e";

	public static final String FIND_BY_QUESTION_ID = "SELECT e FROM QuestionMaster e where e.questionId=:questionId";

	public static final String FIND_BY_COURSE_ID = "SELECT e FROM QuestionMaster e where e.courseId.id=:courseId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "question_id", unique = true, nullable = false)
	private String questionId;

	@ManyToOne(optional = false, targetEntity = CourseMasterEntity.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
	private CourseMasterEntity courseId;

	@Column(name = "question", nullable = false,length=1024)
	private String question;


	
	@Column(name = "choice1", nullable = false,length=1024)
	private String choice1;


	@Column(name = "choice2", nullable = false,length=1024)
	private String choice2;


	@Column(name = "choice3", nullable = false,length=1024)
	private String choice3;


	@Column(name = "choice4", nullable = false,length=1024)
	private String choice4;

	@Column(name = "answer_number", nullable = false,length=2)
	private int answerNumber;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public CourseMasterEntity getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;

	}

	public int getAnswerNumber() {
		return answerNumber;

	}

}
