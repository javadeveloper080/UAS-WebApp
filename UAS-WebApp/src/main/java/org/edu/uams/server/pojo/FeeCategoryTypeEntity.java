package org.edu.uams.server.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.edu.uams.server.api.Type;


@Entity(name = "FeeCategoryType")
@Table(name = "fee_category_type")
public class FeeCategoryTypeEntity implements Type {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final  String  FIND_ALL="SELECT f FROM FeeCategoryType f";
    public static final  String  FIND_BY_CODE="SELECT f FROM FeeCategoryType f where f.code = :code";
    
    //FeeCategoryType :Transport/Hostel/Others/Semester/Yearly/Examination
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "code", unique = true, nullable = false, length = 10)
    private String code;
    
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    
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
    
    
}
