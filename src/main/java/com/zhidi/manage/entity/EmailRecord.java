package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * EmailRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_EMAIL_RECORD"
    ,schema="REDTEA"
)

public class EmailRecord  implements java.io.Serializable {


    // Fields    

     private String emailrecordid;
     private User user;
     private String toaddr;
     private String subject;
     private byte[] content;
     private Date sendtime;
     private Boolean status;


    // Constructors

    /** default constructor */
    public EmailRecord() {
    }



   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="EMAILRECORDID", unique=true, nullable=false, length=32)

    public String getEmailrecordid() {
        return this.emailrecordid;
    }
    
    public void setEmailrecordid(String emailrecordid) {
        this.emailrecordid = emailrecordid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="USERID", nullable=false)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="TOADDR", nullable=false, length=800)

    public String getToaddr() {
        return this.toaddr;
    }
    
    public void setToaddr(String toaddr) {
        this.toaddr = toaddr;
    }
    
    @Column(name="SUBJECT", nullable=false, length=200)

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Lob
    @Column(name="CONTENT", nullable=false)

    public byte[] getContent() {
        return this.content;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    @Column(name="SENDTIME", nullable=false)

    public Date getSendtime() {
        return this.sendtime;
    }
    
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
    
    @Column(name="STATUS", nullable=false, precision=1, scale=0)

    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
   








}