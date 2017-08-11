package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_MESSAGE"
    ,schema="REDTEA"
)

public class Message  implements java.io.Serializable {


    // Fields    

     private String messageid;
     private User userByTouserid;
     private User userByFromuserid;
     private String content;
     private Date readtime;
     private Date sendtime;
     private Boolean status;


    // Constructors

    /** default constructor */
    public Message() {
    }



   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="MESSAGEID", unique=true, nullable=false, length=32)

    public String getMessageid() {
        return this.messageid;
    }
    
    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="TOUSERID", nullable=false)

    public User getUserByTouserid() {
        return this.userByTouserid;
    }
    
    public void setUserByTouserid(User userByTouserid) {
        this.userByTouserid = userByTouserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="FROMUSERID", nullable=false)

    public User getUserByFromuserid() {
        return this.userByFromuserid;
    }
    
    public void setUserByFromuserid(User userByFromuserid) {
        this.userByFromuserid = userByFromuserid;
    }

    @Column(name="CONTENT", nullable=false)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="READTIME")

    public Date getReadtime() {
        return this.readtime;
    }
    
    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }
    
    @Column(name="SENDTIME")

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