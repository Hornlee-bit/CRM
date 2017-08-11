package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_ANNOUNCEMENT"
    ,schema="REDTEA"
)

public class Announcement  implements java.io.Serializable {


    // Fields    

     private String announcementid;
     private Department department;
     private User user;
     private Integer orderid;
     private String title;
     private String content;
     private Date createtime;
     private Date updatetime;
     private String color;
     private Boolean status;
     private Boolean isshow;


    // Constructors

    /** default constructor */
    public Announcement() {
    }

     
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ANNOUNCEMENTID", unique=true, nullable=false, length=32)

    public String getAnnouncementid() {
        return this.announcementid;
    }
    
    public void setAnnouncementid(String announcementid) {
        this.announcementid = announcementid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DEPARTMENT", nullable=true)

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="USERID", nullable=true)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="ORDERID", nullable=true, precision=10, scale=0)

    public Integer getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    
    @Column(name="TITLE", nullable=false, length=50)

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
  
    @Column(name="CONTENT", nullable=false)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="CREATETIME", nullable=true)

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="UPDATETIME", nullable=true)

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="COLOR", nullable=true, length=50)

    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Column(name="STATUS", nullable=false, precision=1, scale=0)

    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    @Column(name="ISSHOW", nullable=false, precision=1, scale=0)

    public Boolean getIsshow() {
        return this.isshow;
    }
    
    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }
   








}