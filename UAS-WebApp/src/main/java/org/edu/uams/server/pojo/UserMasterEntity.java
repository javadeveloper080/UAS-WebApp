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
    @NamedQuery(name = UserMasterEntity.FIND_ALL, query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = UserMasterEntity.FIND_BY_LOGIN_NAME_PWD, query = "SELECT u FROM UserMaster u")
})
@Table(name = "user_master")
public class UserMasterEntity implements Serializable  {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_USERNAME = "SELECT u from UserMaster u where u.userName = :userName";
    public static final  String  FIND_ALL="SELECT u FROM UserMaster u";
    public static final  String  FIND_BY_LOGIN_NAME_PWD="SELECT u FROM UserMaster u where u.userName=:userName and u.passWord=:passWord";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "user_name", unique = true, nullable = false, length = 200)
    private String userName;
    
    @Column(name = "pass_word", nullable = false, length = 10)
    private String passWord;
    
    @ManyToOne(optional = false, targetEntity = UserMasterTypeEntity.class)
    @JoinColumn(name = "users_role_type_id", referencedColumnName = "id", nullable = false )
    private UserMasterTypeEntity userMasterTypeEntity;
    
    public UserMasterTypeEntity getUserMasterTypeEntity() {
        return userMasterTypeEntity;
    }
    
    public void setUserMasterTypeEntity(UserMasterTypeEntity userMasterTypeEntity) {
        this.userMasterTypeEntity = userMasterTypeEntity;
    }
    
    
    public long getUserId() {
        return id;
    }
    
    
    public void setUserId(long userId) {
        this.id = userId;
    }
    
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getPassWord() {
        return passWord;
    }
    
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
