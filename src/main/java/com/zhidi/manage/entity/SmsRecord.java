package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * SmsRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_SMS_RECORD"
    ,schema="REDTEA"
)

public class SmsRecord  implements java.io.Serializable {


    // Fields    

     private String smsrecordid;
     private User user;
     private String telephone;
     private byte[] recordcontent;
     private Date sendtime;


    // Constructors

    /** default constructor */
    public SmsRecord() {
    }

	/** minimal constructor */
    public SmsRecord(String telephone, byte[] recordcontent, Date sendtime) {
        this.telephone = telephone;
        this.recordcontent = recordcontent;
        this.sendtime = sendtime;
    }
    
    /** full constructor */
    public SmsRecord(User user, String telephone, byte[] recordcontent, Date sendtime) {
        this.user = user;
        this.telephone = telephone;
        this.recordcontent = recordcontent;
        this.sendtime = sendtime;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="SMSRECORDID", unique=true, nullable=false, length=32)

    public String getSmsrecordid() {
        return this.smsrecordid;
    }
    
    public void setSmsrecordid(String smsrecordid) {
        this.smsrecordid = smsrecordid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="USERID")

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="TELEPHONE", nullable=false, length=800)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @Lob
    @Column(name="RECORDCONTENT", nullable=false)

    public byte[] getRecordcontent() {
        return this.recordcontent;
    }
    
    public void setRecordcontent(byte[] recordcontent) {
        this.recordcontent = recordcontent;
    }
    
    @Column(name="SENDTIME", nullable=false)

    public Date getSendtime() {
        return this.sendtime;
    }
    
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
   








}