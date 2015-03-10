package org.edu.uams.server.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity(name = "Document")
@Table(name = "document")
public class DocumentEntity implements Serializable  {
	
	public static final String FIND_BY_COURSEID = "SELECT d FROM Document d where d.courseId.id=:courseId";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Basic(optional = false)
	@Column(name = "file_name", nullable = false)
	@XmlElement(name = "fileName")
	private String fileName;
	

	@ManyToOne(optional = false, targetEntity = CourseMasterEntity.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
	private CourseMasterEntity courseId;

	@Basic(optional = false)
	@Column(name = "mime_type", nullable = false)
	@XmlElement(name = "mimeType")
	private String mimeType;
	
	@Lob
	@Column(name = "file_bytes", nullable = false)
	@XmlTransient
	private byte[] fileBytes;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getMimeType() {
		return mimeType;
	}


	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}


	public byte[] getFileBytes() {
		return fileBytes;
	}


	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}


	public CourseMasterEntity getCourseId() {
		return courseId;
	}


	public void setCourseId(CourseMasterEntity courseId) {
		this.courseId = courseId;
	}

	
}
