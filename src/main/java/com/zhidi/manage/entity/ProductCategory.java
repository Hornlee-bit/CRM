package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * ProductCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_PRODUCT_CATEGORY"
    ,schema="REDTEA"
)

public class ProductCategory  implements java.io.Serializable {


    // Fields    

     private String categoryid;
     private ProductCategory productCategory;
     private String name;
     private String description;
     private Set<Product> products = new HashSet<Product>(0);
     private Set<ProductCategory> productCategories = new HashSet<ProductCategory>(0);


    // Constructors

    /** default constructor */
    public ProductCategory() {
    }

	/** minimal constructor */
    public ProductCategory(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public ProductCategory(ProductCategory productCategory, String name, String description, Set<Product> products, Set<ProductCategory> productCategories) {
        this.productCategory = productCategory;
        this.name = name;
        this.description = description;
        this.products = products;
        this.productCategories = productCategories;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="CATEGORYID", unique=true, nullable=false, length=32)

    public String getCategoryid() {
        return this.categoryid;
    }
    
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PARENTID")

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }
    
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    @Column(name="NAME", nullable=false, length=30)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="DESCRIPTION", length=100)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productCategory")

    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productCategory")

    public Set<ProductCategory> getProductCategories() {
        return this.productCategories;
    }
    
    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }
   








}