package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * ProductImages entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_PRODUCT_IMAGES"
    ,schema="REDTEA"
)

public class ProductImages  implements java.io.Serializable {


    // Fields    

     private String imagesid;
     private Product product;
     private Boolean ismain;
     private String name;
     private String savename;
     private String imagesize;
     private String path;
     private Date createtime;
     private Integer sortnum;


    // Constructors

    /** default constructor */
    public ProductImages() {
    }

	/** minimal constructor */
    public ProductImages(Product product, Boolean ismain, String path, Date createtime) {
        this.product = product;
        this.ismain = ismain;
        this.path = path;
        this.createtime = createtime;
    }
    
    /** full constructor */
    public ProductImages(Product product, Boolean ismain, String name, String savename, String imagesize, String path, Date createtime, Integer sortnum) {
        this.product = product;
        this.ismain = ismain;
        this.name = name;
        this.savename = savename;
        this.imagesize = imagesize;
        this.path = path;
        this.createtime = createtime;
        this.sortnum = sortnum;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="IMAGESID", unique=true, nullable=false, length=32)

    public String getImagesid() {
        return this.imagesid;
    }
    
    public void setImagesid(String imagesid) {
        this.imagesid = imagesid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PRODUCTID", nullable=false)

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Column(name="ISMAIN", nullable=false, precision=1, scale=0)

    public Boolean getIsmain() {
        return this.ismain;
    }
    
    public void setIsmain(Boolean ismain) {
        this.ismain = ismain;
    }
    
    @Column(name="NAME", length=500)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="SAVENAME", length=500)

    public String getSavename() {
        return this.savename;
    }
    
    public void setSavename(String savename) {
        this.savename = savename;
    }
    
    @Column(name="IMAGESIZE", length=500)

    public String getImagesize() {
        return this.imagesize;
    }
    
    public void setImagesize(String imagesize) {
        this.imagesize = imagesize;
    }
    
    @Column(name="PATH", nullable=false, length=500)

    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    @Column(name="CREATETIME", nullable=false)

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="SORTNUM", precision=10, scale=0)

    public Integer getSortnum() {
        return this.sortnum;
    }
    
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }
   








}