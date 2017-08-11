package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_CUSTOMER"
    ,schema="REDTEA"
)

public class Customer  implements java.io.Serializable {


    // Fields    

     private String customerid;
     private User userByCreatoruserid;
     private User userByOwneruserid;
     private User userByDeleteuserid;
     private String name;
     private String origin;
     private String address;
     private String zipcode;
     private String industry;
     private String annualrevenue;
     private String ownership;
     private String rating;
     private Date createtime;
     private Date updatetime;
     private Boolean isdeleted;
     private Boolean islocked;
     private Date deletetime;
     private Set<Contacts> contactses=new HashSet<Contacts>();
     private Set<User> followUsers=new HashSet<User>();
     private Set<Business> businesses = new HashSet<Business>(0);
     private Set<Business> businesses_1 = new HashSet<Business>(0);
     private Set<Leads> leadses = new HashSet<Leads>(0);


    // Constructors

    /** default constructor */
    public Customer() {
    }

    

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="CUSTOMERID", unique=true, nullable=false, length=32)

    public String getCustomerid() {
        return this.customerid;
    }
    
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
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
        @JoinColumn(name="OWNERUSERID")

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
    
    @Column(name="NAME", nullable=false, length=333)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="ORIGIN", length=150)

    public String getOrigin() {
        return this.origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    @Column(name="ADDRESS", length=100)

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
    
    @Column(name="INDUSTRY", length=150)

    public String getIndustry() {
        return this.industry;
    }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    @Column(name="ANNUALREVENUE", length=20)

    public String getAnnualrevenue() {
        return this.annualrevenue;
    }
    
    public void setAnnualrevenue(String annualrevenue) {
        this.annualrevenue = annualrevenue;
    }
    
    @Column(name="OWNERSHIP", length=150)

    public String getOwnership() {
        return this.ownership;
    }
    
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    
    @Column(name="RATING", length=150)

    public String getRating() {
        return this.rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    @Column(name="CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="ISDELETED", nullable=false, precision=1, scale=0)

    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    @Column(name="ISLOCKED", nullable=false, precision=1, scale=0)

    public Boolean getIslocked() {
        return this.islocked;
    }
    
    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }
    
    @Column(name="DELETETIME")

    public Date getDeletetime() {
        return this.deletetime;
    }
    
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")

    public Set<Business> getBusinesses() {
        return this.businesses;
    }
    
    public void setBusinesses(Set<Business> businesses) {
        this.businesses = businesses;
    }
@ManyToMany()
    @JoinTable(name="TB_CRM_R_BUSINESS_CUSTOMER", schema="TEAM1", joinColumns = {
        @JoinColumn(name="CUSTOMERID", updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="BUSINESSID", updatable=false) })

    public Set<Business> getBusinesses_1() {
        return this.businesses_1;
    }
    
    public void setBusinesses_1(Set<Business> businesses_1) {
        this.businesses_1 = businesses_1;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")

    public Set<Leads> getLeadses() {
        return this.leadses;
    }
    
    public void setLeadses(Set<Leads> leadses) {
        this.leadses = leadses;
    }

    @ManyToMany()
    @JoinTable(name="TB_MID_CUSTOMER_USER", schema="TEAM1", joinColumns = {
        @JoinColumn(name="CUSTOMERID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="USERID", nullable=false, updatable=false) })

	public Set<User> getFollowUsers() {
		return followUsers;
	}


	public void setFollowUsers(Set<User> followUsers) {
		this.followUsers = followUsers;
	}
	@OneToMany(mappedBy="customer")
	public Set<Contacts> getContactses() {
		return contactses;
	}

	public void setContactses(Set<Contacts> contactses) {
		this.contactses = contactses;
	}


	
	
   








}