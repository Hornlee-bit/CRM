package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * EmailTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_EMAIL_TEMPLATE"
    ,schema="REDTEA"
)

public class EmailTemplate  implements java.io.Serializable {


    // Fields    

     private String templateid;
     private String subject;
     private String title;
     private String content;
     private Integer orderid;


    // Constructors

    /** default constructor */
    public EmailTemplate() {
    }

    
    /** full constructor */
    public EmailTemplate(String subject, String title, String content, Integer orderid) {
        this.subject = subject;
        this.title = title;
        this.content = content;
        this.orderid = orderid;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="TEMPLATEID", unique=true, nullable=false, length=32)

    public String getTemplateid() {
        return this.templateid;
    }
    
    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }
    
    @Column(name="SUBJECT", nullable=false, length=200)

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Column(name="TITLE", nullable=false, length=100)

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="CONTENT", nullable=false, length=500)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="ORDERID", nullable=false, precision=10, scale=0)

    public Integer getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
   








}