package org.edu.uams.server.pojo;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "GeneratedLetter")
@Table(name = "generated_letter")
public class GeneratedLetterEntity implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    
    public static final  String  FIND_ALL="SELECT f FROM GeneratedLetter f";
    public static final  String  FIND_BY_LETTER_TEMPLATE="SELECT f FROM GeneratedLetter f join f.letterTemplate l where l.id = :lettertemplateId";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    

    
    @Column(name = "document_id",nullable = false)
    private long documentId;
    
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = LetterTemplateEntity.class)
    @JoinColumn(name = "letter_template_id", referencedColumnName = "id", nullable = false )
    private LetterTemplateEntity letterTemplate;
    
    @Basic(optional = false)
    @ManyToOne(optional = false, targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false )
    private StudentEntity student;
    
    
    
    public GeneratedLetterEntity() {
    }



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getDocumentId() {
		return documentId;
	}



	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}



	public LetterTemplateEntity getLetterTemplate() {
		return letterTemplate;
	}



	public void setLetterTemplate(LetterTemplateEntity letterTemplate) {
		this.letterTemplate = letterTemplate;
	}



	public StudentEntity getStudent() {
		return student;
	}



	public void setStudent(StudentEntity student) {
		this.student = student;
	}
    
   
    
    
}
