package org.edu.uams.server.pojo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import org.edu.uams.server.api.HasId;



@Entity(name = "UserMaster")
@Table(name = "user_master",uniqueConstraints=
           @UniqueConstraint(columnNames = {"user_name", "email"}))
public class UserMasterEntity implements HasId  {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_USERNAME = "SELECT u from UserMaster u where u.userName = :userName";
    public static final String FIND_BY_EMAIL = "SELECT u from UserMaster u where u.email = :email";
    public static final  String  FIND_ALL="SELECT u FROM UserMaster u left join u.userType ut";
    public static final  String  FIND_BY_LOGIN_NAME_PWD="SELECT u FROM UserMaster u where u.userName=:userName and u.password=:passWord";
    public static String FIND_USER_NAME_OR_EMAIL="SELECT u FROM UserMaster u where ( u.userName=:userName or u.email=:email)";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "user_name", unique = true, nullable = false, length = 200)
    private String userName;
    
    @Column(name = "pass_word", nullable = false, length = 10)
    private String password;
    
    @Column(name = "email", unique = true,nullable = false, length = 100)
    private String email;
    
    @Column(name = "in_active_on", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inActiveOn;
    
    @ManyToOne(optional = false, targetEntity = UserMasterTypeEntity.class)
    @JoinColumn(name = "user_master_type_id", referencedColumnName = "id", nullable = false )
    private UserMasterTypeEntity userType;
    
    public UserMasterTypeEntity getUserType() {
        return userType;
    }
    
    public void setUserType(UserMasterTypeEntity userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getInActiveOn() {
        return inActiveOn;
    }

    public void setInActiveOn(Date inActiveOn) {
        this.inActiveOn = inActiveOn;
    }
    
}
