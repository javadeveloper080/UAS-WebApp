package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "UserMasterType")
@Table(name = "users_role_type")
public class UserMasterTypeEntity implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    
    public static final  String  FIND_ALL="SELECT urt FROM UserMasterType urt";
    public static final  String  FIND_BY_CODE="SELECT urt FROM UserMasterType urt where urt.code = :code";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    
    public UserMasterTypeEntity() {
    }
    
    public UserMasterTypeEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    @Column(name = "code", unique = true, nullable = false, length = 20)
    private String code;
    
    @Column(name = "description", nullable = false, length = 200)
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
