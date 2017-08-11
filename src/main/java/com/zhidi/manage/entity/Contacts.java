package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * BusinessContacts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_CONTACTS"
    ,schema="REDTEA"
)

public class Contacts  implements java.io.Serializable {


    // Fields    

     private String contactsid;
     private Customer customer;
     private Boolean isFirst;
     private User userByCreatoruserid;
     private User userByDeleteuserid;
     private String name;
     private String post;
     private String department;
     private Boolean sex;
     private String saltname;
     private String telephone;
     private String email;
     private String qqno;
     private String address;
     private String zipcode;
     private String description;
     private Date createtime;
     private Date updatdtime;
     private Boolean isdeleted;
     private Date deletetime;
     private Set<Business> businesses = new HashSet<Business>(0);
     private Set<Leads> leadses = new HashSet<Leads>(0);
     

    // Constructors

    /** default constructor */
    public Contacts() {
    }


    

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="CONTACTSID", unique=true, nullable=false, length=32)

    public String getContactsid() {
        return this.contactsid;
    }
    
    public void setContactsid(String contactsid) {
        this.contactsid = contactsid;
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
        @JoinColumn(name="DELETEUSERID")

    public User getUserByDeleteuserid() {
        return this.userByDeleteuserid;
    }
    
    public void setUserByDeleteuserid(User userByDeleteuserid) {
        this.userByDeleteuserid = userByDeleteuserid;
    }
    
    @Column(name="NAME", length=50)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="POST", length=20)

    public String getPost() {
        return this.post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    
    @Column(name="DEPARTMENT", length=20)

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Column(name="SEX", precision=1, scale=0)

    public Boolean getSex() {
        return this.sex;
    }
    
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    
    @Column(name="SALTNAME", length=20)

    public String getSaltname() {
        return this.saltname;
    }
    
    public void setSaltname(String saltname) {
        this.saltname = saltname;
    }
    
    @Column(name="TELEPHONE", length=20)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name="EMAIL", length=50)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="QQNO", length=50)

    public String getQqno() {
        return this.qqno;
    }
    
    public void setQqno(String qqno) {
        this.qqno = qqno;
    }
    
    @Column(name="ADDRESS", length=50)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="ZIPCODE", length=20)

    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    @Column(name="DESCRIPTION", length=100)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="UPDATDTIME")

    public Date getUpdatdtime() {
        return this.updatdtime;
    }
    
    public void setUpdatdtime(Date updatdtime) {
        this.updatdtime = updatdtime;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="businessContacts")

    public Set<Business> getBusinesses() {
        return this.businesses;
    }
    
    public void setBusinesses(Set<Business> businesses) {
        this.businesses = businesses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="businessContacts")

    public Set<Leads> getLeadses() {
        return this.leadses;
    }
    
    public void setLeadses(Set<Leads> leadses) {
        this.leadses = leadses;
    }
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerid")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}
   








}