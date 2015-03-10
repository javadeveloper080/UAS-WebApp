/**
 * 
 */
package org.edu.uams.client.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.edu.uams.client.dto.ExamOptionsDTO;

public class ExamForm extends ActionForm {

	private Long questionKey;

	private String questionId;

	private String questionDescription;

	private int answerNumber;

	private List<ExamOptionsDTO> options;

	private Integer courseId;

	private List courseKeyList;

	private String noQuestionsAttempted;

	private String noQuestionsPending;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}

	public List<ExamOptionsDTO> getOptions() {
		return options;
	}

	public void setOptions(List<ExamOptionsDTO> options) {
		this.options = options;
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

	public Long getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(Long questionKey) {
		this.questionKey = questionKey;
	}

	public String getNoQuestionsPending() {
		return noQuestionsPending;
	}

	public void setNoQuestionsPending(String noQuestionsPending) {
		this.noQuestionsPending = noQuestionsPending;
	}

	public String getNoQuestionsAttempted() {
		return noQuestionsAttempted;
	}

	public void setNoQuestionsAttempted(String noQuestionsAttempted) {
		this.noQuestionsAttempted = noQuestionsAttempted;
	}

}
