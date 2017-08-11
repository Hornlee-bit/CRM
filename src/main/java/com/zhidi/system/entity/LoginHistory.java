package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * LoginHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_LOGIN_HISTORY"
    ,schema="REDTEA"
)

public class LoginHistory  implements java.io.Serializable {


    // Fields    

     private String loginid;
     private User user;
     private Date logintime;
     private String loginip;
     private String loginstatus;


    // Constructors

    /** default constructor */
    public LoginHistory() {
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="LOGINID", unique=true, nullable=false, length=32)

    public String getLoginid() {
        return this.loginid;
    }
    
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="USERID", nullable=false)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="LOGINTIME", nullable=false)

    public Date getLogintime() {
        return this.logintime;
    }
    
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
    
    @Column(name="LOGINIP", length=50)

    public String getLoginip() {
        return this.loginip;
    }
    
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }
    
    @Column(name="LOGINSTATUS", nullable=false, length=6)

    public String getLoginstatus() {
        return this.loginstatus;
    }
    
    public void setLoginstatus(String loginstatus) {
        this.loginstatus = loginstatus;
    }
   








}