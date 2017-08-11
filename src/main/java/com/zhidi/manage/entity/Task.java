package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_TASK"
    ,schema="REDTEA"
)

public class Task  implements java.io.Serializable {


    // Fields    

     private String taskid;
     private User userByCreatoruserid;
     private User userByOwneruserid;
     private User userByDeleteuserid;
     private String aboutUser;
     private String subject;
     private Date duedate;
     private String status;
     private String priority;
     private String sendemail;
     private byte[] description;
     private Date createdate;
     private Date updtadate;
     private Boolean isclose;
     private Boolean isdeleted;
     private Date deletetime;


    // Constructors

    /** default constructor */
    public Task() {
    }

	/** minimal constructor */
    public Task(User userByOwneruserid, String subject, Date createdate, Date updtadate) {
        this.userByOwneruserid = userByOwneruserid;
        this.subject = subject;
        this.createdate = createdate;
        this.updtadate = updtadate;
    }
    
    /** full constructor */
    public Task(User userByCreatoruserid, User userByOwneruserid, User userByDeleteuserid, String aboutUser, String subject, Date duedate, String status, String priority, String sendemail, byte[] description, Date createdate, Date updtadate, Boolean isclose, Boolean isdeleted, Date deletetime) {
        this.userByCreatoruserid = userByCreatoruserid;
        this.userByOwneruserid = userByOwneruserid;
        this.userByDeleteuserid = userByDeleteuserid;
        this.aboutUser = aboutUser;
        this.subject = subject;
        this.duedate = duedate;
        this.status = status;
        this.priority = priority;
        this.sendemail = sendemail;
        this.description = description;
        this.createdate = createdate;
        this.updtadate = updtadate;
        this.isclose = isclose;
        this.isdeleted = isdeleted;
        this.deletetime = deletetime;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="TASKID", unique=true, nullable=false, length=32)

    public String getTaskid() {
        return this.taskid;
    }
    
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CREATORUSERID")

    public User getUserByCreatoruserid() {
        return this.userByCreatoruserid;
    }
    
    public void setUserByCreatoruserid(User userByCreatoruserid) {
        this.userByCreatoruserid = userByCreatoruserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="OWNERUSERID", nullable=true)

    public User getUserByOwneruserid() {
        return this.userByOwneruserid;
    }
    
    public void setUserByOwneruserid(User userByOwneruserid) {
        this.userByOwneruserid = userByOwneruserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DELETEUSERID")

    public User getUserByDeleteuserid() {
        return this.userByDeleteuserid;
    }
    
    public void setUserByDeleteuserid(User userByDeleteuserid) {
        this.userByDeleteuserid = userByDeleteuserid;
    }
    
    @Column(name="ABOUT_USER", length=200)

    public String getAboutUser() {
        return this.aboutUser;
    }
    
    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }
    
    @Column(name="SUBJECT", nullable=false, length=100)

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Column(name="DUEDATE")

    public Date getDuedate() {
        return this.duedate;
    }
    
    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
    
    @Column(name="STATUS", length=20)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="PRIORITY", length=10)

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Column(name="SENDEMAIL", length=50)

    public String getSendemail() {
        return this.sendemail;
    }
    
    public void setSendemail(String sendemail) {
        this.sendemail = sendemail;
    }
    @Lob
    @Column(name="DESCRIPTION")

    public byte[] getDescription() {
        return this.description;
    }
    
    public void setDescription(byte[] description) {
        this.description = description;
    }
    
    @Column(name="CREATEDATE", nullable=false)

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    
    @Column(name="UPDTADATE", nullable=false)

    public Date getUpdtadate() {
        return this.updtadate;
    }
    
    public void setUpdtadate(Date updtadate) {
        this.updtadate = updtadate;
    }
    
    @Column(name="ISCLOSE", precision=1, scale=0)

    public Boolean getIsclose() {
        return this.isclose;
    }
    
    public void setIsclose(Boolean isclose) {
        this.isclose = isclose;
    }
    
    @Column(name="ISDELETED", precision=1, scale=0)

    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    @Column(name="DELETETIME")

    public Date getDeletetime() {
        return this.deletetime;
    }
    
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
   








}