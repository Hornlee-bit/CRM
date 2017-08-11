package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * BusinessStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_BUSINESS_STATUS"
    ,schema="REDTEA"
)

public class BusinessStatus  implements java.io.Serializable {


    // Fields    

     private String statusid;
     private String name;
     private Integer orderid;
     private Boolean isend;
     private String description;
     private Set<Business> businesses = new HashSet<Business>(0);


    // Constructors

    /** default constructor */
    public BusinessStatus() {
    }

	/** minimal constructor */
    public BusinessStatus(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public BusinessStatus(String name, Integer orderid, Boolean isend, String description, Set<Business> businesses) {
        this.name = name;
        this.orderid = orderid;
        this.isend = isend;
        this.description = description;
        this.businesses = businesses;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="STATUSID", unique=true, nullable=false, length=32)

    public String getStatusid() {
        return this.statusid;
    }
    
    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }
    
    @Column(name="NAME", nullable=false, length=20)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="ORDERID", precision=10, scale=0)

    public Integer getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    
    @Column(name="ISEND", precision=1, scale=0)

    public Boolean getIsend() {
        return this.isend;
    }
    
    public void setIsend(Boolean isend) {
        this.isend = isend;
    }
    
    @Column(name="DESCRIPTION", length=200)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="businessStatus")

    public Set<Business> getBusinesses() {
        return this.businesses;
    }
    
    public void setBusinesses(Set<Business> businesses) {
        this.businesses = businesses;
    }
   








}