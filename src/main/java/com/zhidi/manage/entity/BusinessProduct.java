package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * BusinessProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_R_BUSINESS_PRODUCT"
    ,schema="REDTEA"
)

public class BusinessProduct  implements java.io.Serializable {


    // Fields    

     private String id;
     private Business business;
     private Product product;
     private Double salesprice;
     private Double estimateprice;
     private Integer amount;
     private Short discountrate;
     private Short taxrrate;
     private Double unitprice;
     private Double subtotal;
     private String description;
     private Double subtotalval;
     private Double discountprice;


    // Constructors

    /** default constructor */
    public BusinessProduct() {
    }

    
    /** full constructor */
    public BusinessProduct(Business business, Product product, Double salesprice, Double estimateprice, Integer amount, Short discountrate, Short taxrrate, Double unitprice, Double subtotal, String description, Double subtotalval, Double discountprice) {
        this.business = business;
        this.product = product;
        this.salesprice = salesprice;
        this.estimateprice = estimateprice;
        this.amount = amount;
        this.discountrate = discountrate;
        this.taxrrate = taxrrate;
        this.unitprice = unitprice;
        this.subtotal = subtotal;
        this.description = description;
        this.subtotalval = subtotalval;
        this.discountprice = discountprice;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ID", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
        @JoinColumn(name="PRODUCTID")

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Column(name="SALESPRICE", precision=10)

    public Double getSalesprice() {
        return this.salesprice;
    }
    
    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }
    
    @Column(name="ESTIMATEPRICE", precision=10)

    public Double getEstimateprice() {
        return this.estimateprice;
    }
    
    public void setEstimateprice(Double estimateprice) {
        this.estimateprice = estimateprice;
    }
    
    @Column(name="AMOUNT", precision=10, scale=0)

    public Integer getAmount() {
        return this.amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    @Column(name="DISCOUNTRATE", precision=4, scale=0)

    public Short getDiscountrate() {
        return this.discountrate;
    }
    
    public void setDiscountrate(Short discountrate) {
        this.discountrate = discountrate;
    }
    
    @Column(name="TAXRRATE", precision=4, scale=0)

    public Short getTaxrrate() {
        return this.taxrrate;
    }
    
    public void setTaxrrate(Short taxrrate) {
        this.taxrrate = taxrrate;
    }
    
    @Column(name="UNITPRICE", precision=10)

    public Double getUnitprice() {
        return this.unitprice;
    }
    
    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }
    
    @Column(name="SUBTOTAL", precision=10)

    public Double getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    @Column(name="DESCRIPTION", length=200)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="SUBTOTALVAL", precision=10)

    public Double getSubtotalval() {
        return this.subtotalval;
    }
    
    public void setSubtotalval(Double subtotalval) {
        this.subtotalval = subtotalval;
    }
    
    @Column(name="DISCOUNTPRICE", precision=10)

    public Double getDiscountprice() {
        return this.discountprice;
    }
    
    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }
   








}