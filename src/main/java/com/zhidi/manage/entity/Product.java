package com.zhidi.manage.entity;
// default package


import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_PRODUCT"
    ,schema="REDTEA"
)

public class Product  implements java.io.Serializable {


    // Fields    

     private String productid;
     private User user;
     private ProductCategory productCategory;
     private String name;
     private Double costprice;
     private Double suggestedprice;
     private String developmentteam;
     private Date developmenttime;
     private String link;
     private Date createtime;
     private Date updatetime;
     private String description;
     private Set<BusinessProduct> businessProducts = new HashSet<BusinessProduct>(0);
     private Set<ProductImages> productImageses = new HashSet<ProductImages>(0);


    // Constructors

    /** default constructor */
    public Product() {
    }

	/** minimal constructor */
    public Product(User user, String name, Date createtime, Date updatetime) {
        this.user = user;
        this.name = name;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }
    
    /** full constructor */

    public Product(User user, ProductCategory productCategory, String name, Double costprice, Double suggestedprice, String developmentteam, Date developmenttime, String link, Date createtime, Date updatetime, String description, Set<BusinessProduct> businessProducts, Set<ProductImages> productImageses) {

        this.user = user;
        this.productCategory = productCategory;
        this.name = name;
        this.costprice = costprice;
        this.suggestedprice = suggestedprice;
        this.developmentteam = developmentteam;
        this.developmenttime = developmenttime;
        this.link = link;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.description = description;
        this.businessProducts = businessProducts;
        this.productImageses = productImageses;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="PRODUCTID", unique=true, nullable=false, length=32)

    public String getProductid() {
        return this.productid;
    }
    
    public void setProductid(String productid) {
        this.productid = productid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CREATORUSERID", nullable=false)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CATEGORYID")

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }
    
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    @Column(name="NAME", nullable=false, length=200)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="COSTPRICE", precision=10)

    public Double getCostprice() {
        return this.costprice;
    }
    
    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }
    
    @Column(name="SUGGESTEDPRICE", precision=10)

    public Double getSuggestedprice() {
        return this.suggestedprice;
    }
    
    public void setSuggestedprice(Double suggestedprice) {
        this.suggestedprice = suggestedprice;
    }
    
    @Column(name="DEVELOPMENTTEAM")

    public String getDevelopmentteam() {
        return this.developmentteam;
    }
    
    public void setDevelopmentteam(String developmentteam) {
        this.developmentteam = developmentteam;
    }
    
    @Column(name="DEVELOPMENTTIME")

    public Date getDevelopmenttime() {
        return this.developmenttime;
    }
    
    public void setDevelopmenttime(Date developmenttime) {
        this.developmenttime = developmenttime;
    }
    
    @Column(name="LINK", length=200)

    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
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
    
    @Column(name="DESCRIPTION", length=200)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")

    public Set<BusinessProduct> getBusinessProducts() {
        return this.businessProducts;
    }
    
    public void setBusinessProducts(Set<BusinessProduct> businessProducts) {
        this.businessProducts = businessProducts;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")

    public Set<ProductImages> getProductImageses() {
        return this.productImageses;
    }
    
    public void setProductImageses(Set<ProductImages> productImageses) {
        this.productImageses = productImageses;
    }

	
   








}