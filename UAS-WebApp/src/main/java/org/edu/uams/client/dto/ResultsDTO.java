/**
 * 
 */
package org.edu.uams.client.dto;


public class ResultsDTO  {

	public ResultsDTO() {
	}

	public ResultsDTO(String courseKey, String courseName, String category,
			String percentage) {
		super();
		this.courseKey = courseKey;
		this.courseName = courseName;
		this.category = category;
		this.percentage = percentage;
	}

	private String courseKey;
	private String courseName;

	private String category;

	private String percentage;

	public String getCourseKey() {
		return courseKey;
	}

	public void setCourseKey(String courseKey) {
		this.courseKey = courseKey;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}
