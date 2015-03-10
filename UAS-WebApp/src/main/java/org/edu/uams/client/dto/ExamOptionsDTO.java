package org.edu.uams.client.dto;


public class ExamOptionsDTO {
	
	
	public ExamOptionsDTO(){
		
	}
	
	
	public ExamOptionsDTO(int answerNumber, String answer) {
		super();
		this.answerNumber = answerNumber;
		this.answer = answer;
	}

	private int answerNumber;

	private String answer;

	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


}
