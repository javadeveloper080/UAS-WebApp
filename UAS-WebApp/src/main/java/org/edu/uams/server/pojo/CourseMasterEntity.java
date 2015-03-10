package org.edu.uams.server.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "CourseMaster")
@Table(name = "course_master")

public class CourseMasterEntity implements Serializable {

	private static final long serialVersionUID = 7356106754219694386L;


	public static final  String  COURSEMASTER_FIND_ALL="SELECT c FROM CourseMaster c";
	public static final  String  COURSEMASTER_FIND_COURSEKEY="SELECT c FROM CourseMaster c where c.courseKey=:courseKey";
	public static final String FIND_BY_COURSE_NAME = "SELECT c FROM CourseMaster c where c.courseName=:courseName";


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "course_key", unique = true, nullable = false,length=255)
	private String courseKey;

	@Column(name = "course_name", nullable = false,length=255)
	private String courseName;
	
	@Column(name = "category", unique = false, nullable = false,length=255)
	private String category;

	@Column(name = "number_of_sessions", nullable = false, length =2)
	private long numberOfSessions;
	
	@OneToMany(targetEntity=QuestionMasterEntity.class,mappedBy="courseId",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<QuestionMasterEntity> questionMasters;
	
	@OneToMany(targetEntity=ResultMasterEntity.class,mappedBy="courseId",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ResultMasterEntity> resultMasters;
	
	@OneToMany(targetEntity=SessionMasterEntity.class,mappedBy="courseId",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<SessionMasterEntity> sessionMasters;
	
	@OneToMany(targetEntity=StudentCourseEntity.class,mappedBy="courseId",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<StudentCourseEntity> studentCourses;


	public String getCourseKey() {
		return courseKey;
	}

	public void setCourseKey(String courseKey) {
		this.courseKey = courseKey;
	}

	public String getCourseName() {
		return courseName;
	}

	public long getNumberOfSessions() {
		return numberOfSessions;
	}

	public void setNumberOfSessions(long numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<QuestionMasterEntity> getQuestionMasters() {
		return questionMasters;
	}

	public void setQuestionMasters(List<QuestionMasterEntity> questionMasters) {
		this.questionMasters = questionMasters;
	}

	public List<ResultMasterEntity> getResultMasters() {
		return resultMasters;
	}

	public void setResultMasters(List<ResultMasterEntity> resultMasters) {
		this.resultMasters = resultMasters;
	}

	public List<SessionMasterEntity> getSessionMasters() {
		return sessionMasters;
	}

	public void setSessionMasters(List<SessionMasterEntity> sessionMasters) {
		this.sessionMasters = sessionMasters;
	}

	public List<StudentCourseEntity> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourseEntity> studentCourses) {
		this.studentCourses = studentCourses;
	}


}
