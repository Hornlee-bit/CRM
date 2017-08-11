package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Leads entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_LEADS"
    ,schema="REDTEA"
)

public class Leads  implements java.io.Serializable {


    // Fields    

     private String leadsid;
     private User userByCreatoruserid;
     private User userByTransformuserid;
     private Contacts businessContacts;
     private User userByOwneruserid;
     private Business business;
     private Customer customer;
     private User userByDeleteuserid;
     private String name;
     private String position;
     private String contactsname;
     private String saltname;
     private String mobile;
     private String email;
     private Date createtime;
     private Date updatetime;
     private Byte isdeleted;
     private Date deletetime;
     private Byte istransformed;
     private String nextstep;
     private Date nextsteptime;
     private Date havetime;
     private String address;
     private String source;
     private String leadnote;


    // Constructors

    /** default constructor */
    public Leads() {
    }


    
  
   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="LEADSID", unique=true, nullable=false, length=32)

    public String getLeadsid() {
        return this.leadsid;
    }
    
    public void setLeadsid(String leadsid) {
        this.leadsid = leadsid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CREATORUSERID", nullable=false)

    public User getUserByCreatoruserid() {
        return this.userByCreatoruserid;
    }
    
    public void setUserByCreatoruserid(User userByCreatoruserid) {
        this.userByCreatoruserid = userByCreatoruserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="TRANSFORMUSERID")

    public User getUserByTransformuserid() {
        return this.userByTransformuserid;
    }
    
    public void setUserByTransformuserid(User userByTransformuserid) {
        this.userByTransformuserid = userByTransformuserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CONTACTSID")

    public Contacts getBusinessContacts() {
        return this.businessContacts;
    }
    
    public void setBusinessContacts(Contacts businessContacts) {
        this.businessContacts = businessContacts;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="OWNERUSERID", nullable=false)

    public User getUserByOwneruserid() {
        return this.userByOwneruserid;
    }
    
    public void setUserByOwneruserid(User userByOwneruserid) {
        this.userByOwneruserid = userByOwneruserid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="BUSINESSID")

    public Business getBusiness() {
        return this.business;
    }
    
    public void setBusiness(Business business) {
        this.business = business;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CUSTOMERID")

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DELETEUSERID")

    public User getUserByDeleteuserid() {
        return this.userByDeleteuserid;
    }
    
    public void setUserByDeleteuserid(User userByDeleteuserid) {
        this.userByDeleteuserid = userByDeleteuserid;
    }
    
    @Column(name="NAME", nullable=false)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="POSITION", length=20)

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    @Column(name="CONTACTSNAME")

    public String getContactsname() {
        return this.contactsname;
    }
    
    public void setContactsname(String contactsname) {
        this.contactsname = contactsname;
    }
    
    @Column(name="SALTNAME")

    public String getSaltname() {
        return this.saltname;
    }
    
    public void setSaltname(String saltname) {
        this.saltname = saltname;
    }
    
    @Column(name="MOBILE")

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="EMAIL", length=5)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="CREATETIME", nullable=false)

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="UPDATETIME", nullable=false)

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="ISDELETED", nullable=false, precision=2, scale=0)

    public Byte getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    @Column(name="DELETETIME")

    public Date getDeletetime() {
        return this.deletetime;
    }
    
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
    
    @Column(name="ISTRANSFORMED", precision=2, scale=0)

    public Byte getIstransformed() {
        return this.istransformed;
    }
    
    public void setIstransformed(Byte istransformed) {
        this.istransformed = istransformed;
    }
    
    @Column(name="NEXTSTEP", length=50)

    public String getNextstep() {
        return this.nextstep;
    }
    
    public void setNextstep(String nextstep) {
        this.nextstep = nextstep;
    }
    
    @Column(name="NEXTSTEPTIME")

    public Date getNextsteptime() {
        return this.nextsteptime;
    }
    
    public void setNextsteptime(Date nextsteptime) {
        this.nextsteptime = nextsteptime;
    }
    
    @Column(name="HAVETIME", nullable=false)

    public Date getHavetime() {
        return this.havetime;
    }
    
    public void setHavetime(Date havetime) {
        this.havetime = havetime;
    }
    
    @Column(name="ADDRESS", length=500)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="SOURCE", length=500)

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    @Column(name="LEADNOTE")

    public String getLeadnote() {
        return this.leadnote;
    }
    
    public void setLeadnote(String leadnote) {
        this.leadnote = leadnote;
    }
   








}