package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity(name = "UserMaster")
@NamedQueries( {
    @NamedQuery(name = UserMasterEntity.FIND_BY_USERNAME, query = "SELECT u from UserMaster u where u.userName = :userName"),
    @NamedQuery(name = UserMasterEntity.FIND_ALL, query = "SELECT u FROM UserMaster u left join u.userTypeList ut"),
    @NamedQuery(name = UserMasterEntity.FIND_BY_LOGIN_NAME_PWD, query = "SELECT u FROM UserMaster u")
})
@Table(name = "user_master")
public class UserMasterEntity implements Serializable  {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_USERNAME = "SELECT u from UserMaster u where u.userName = :userName";
    public static final  String  FIND_ALL="SELECT u FROM UserMaster u left join u.userTypeList ut";
    public static final  String  FIND_BY_LOGIN_NAME_PWD="SELECT u FROM UserMaster u where u.userName=:userName and u.password=:passWord";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "user_name", unique = true, nullable = false, length = 200)
    private String userName;
    
    @Column(name = "pass_word", nullable = false, length = 10)
    private String password;
    
    @ManyToOne(optional = false, targetEntity = UserMasterTypeEntity.class)
    @JoinColumn(name = "user_master_type_id", referencedColumnName = "id", nullable = false )
    private UserMasterTypeEntity userTypeList;
    
    public UserMasterTypeEntity getUserTypeList() {
        return userTypeList;
    }
    
    public void setUserTypeList(UserMasterTypeEntity userTypeList) {
        this.userTypeList = userTypeList;
    }
    
    
    public long getId() {
        return id;
    }
    
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
