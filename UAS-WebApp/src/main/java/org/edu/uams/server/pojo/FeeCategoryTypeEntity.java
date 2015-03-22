package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "FeeCategoryType")
@Table(name = "fee_category_type")
public class FeeCategoryTypeEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static final  String  FIND_ALL="SELECT f FROM FeeCategoryType f";
    public static final  String  FIND_BY_CODE="SELECT f FROM FeeCategoryType f where f.code = :code";



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "code", unique = true, nullable = false, length = 10)
	private String code;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
}
