package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * SmsTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_SMS_TEMPLATE"
    ,schema="REDTEA"
)

public class SmsTemplate  implements java.io.Serializable {


    // Fields    

     private String templateid;
     private String templatecode;
     private String subject;
     private String templatecontent;
     private String orderid;


    // Constructors

    /** default constructor */
    public SmsTemplate() {
    }

    
    /** full constructor */
    public SmsTemplate(String templatecode, String subject, String templatecontent, String orderid) {
        this.templatecode = templatecode;
        this.subject = subject;
        this.templatecontent = templatecontent;
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
    
    @Column(name="TEMPLATECODE", nullable=false, length=10)

    public String getTemplatecode() {
        return this.templatecode;
    }
    
    public void setTemplatecode(String templatecode) {
        this.templatecode = templatecode;
    }
    
    @Column(name="SUBJECT", nullable=false, length=200)

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Column(name="TEMPLATECONTENT", nullable=false, length=500)

    public String getTemplatecontent() {
        return this.templatecontent;
    }
    
    public void setTemplatecontent(String templatecontent) {
        this.templatecontent = templatecontent;
    }
    
    @Column(name="ORDERID", nullable=false, length=32)

    public String getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
   








}