/**
 * 
 */
package org.edu.uams.client.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class QuestionForm extends ActionForm {

	private static final long serialVersionUID = 7881303192843867567L;

	private String questionId;

	private String choice1;

	private String choice2;

	private String choice3;

	private String choice4;


	private int answerNumber;

	private Integer courseId;

	private String courseKey;

	private String questionDescription;

	private List courseKeyList;

	private String questionAddedMessage;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
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

	public String getQuestionAddedMessage() {
		return questionAddedMessage;
	}

	public void setQuestionAddedMessage(String questionAddedMessage) {
		this.questionAddedMessage = questionAddedMessage;
	}

	public String getCourseKey() {
		return courseKey;
	}

	public void setCourseKey(String courseKey) {
		this.courseKey = courseKey;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public List getCourseKeyList() {
		return courseKeyList;
	}

	public void setCourseKeyList(List courseKeyList) {
		this.courseKeyList = courseKeyList;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}
	
	public void resetForm() {
		this.questionId = null;
		this.choice1 = null;
		this.choice2 = null;
		this.choice3 = null;
		this.choice4 = null;
		this.answerNumber = 0;
		this.courseId = null;
		this.courseKey = null;
		this.questionDescription = null;
	}

}
