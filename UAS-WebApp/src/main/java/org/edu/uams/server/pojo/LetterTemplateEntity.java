package org.edu.uams.server.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.edu.uams.server.api.Type;


@Entity(name = "LetterTemplate")
@Table(name = "letter_template")
public class LetterTemplateEntity implements Type {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    
    public static final  String  FIND_ALL="SELECT f FROM LetterTemplate f";
    public static final  String  FIND_BY_CODE="SELECT f FROM LetterTemplate f where f.code = :code";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "code", unique = true, nullable = false, length = 20)
    private String code;
    
    @Column(name = "description", nullable = false, length =100)
    private String description;
    
    @Column(name = "document_id",nullable = false)
    private long documentId;
    
    
    
    public LetterTemplateEntity() {
    }
    
    public LetterTemplateEntity(String code, String description,long documentId) {
        this.description=description;
        this.code=code;
        this.documentId=documentId;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    
    
    
}
