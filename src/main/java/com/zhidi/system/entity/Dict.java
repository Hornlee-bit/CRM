package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Dict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_SYSTEM_DICT"
    ,schema="REDTEA"
)

public class Dict implements java.io.Serializable {


    // Fields    

     private String id;
     private DictType dictType;
     private String dictcode;
     private String dictname;
     private String dictnote;
     private String dictvalue;


    // Constructors

    /** default constructor */
    public Dict() {
    }

	/** minimal constructor */
    public Dict(String dictcode, String dictname, String dictvalue) {
        this.dictcode = dictcode;
        this.dictname = dictname;
        this.dictvalue = dictvalue;
    }
    
    /** full constructor */
    public Dict(DictType dictType, String dictcode, String dictname, String dictnote, String dictvalue) {
        this.dictType = dictType;
        this.dictcode = dictcode;
        this.dictname = dictname;
        this.dictnote = dictnote;
        this.dictvalue = dictvalue;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ID", unique=true, nullable=false, length=1020)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="TYPEID")

    public DictType getDictType() {
        return this.dictType;
    }
    
    public void setDictType(DictType dictType) {
        this.dictType = dictType;
    }
    
    @Column(name="DICTCODE", nullable=false, length=200)

    public String getDictcode() {
        return this.dictcode;
    }
    
    public void setDictcode(String dictcode) {
        this.dictcode = dictcode;
    }
    
    @Column(name="DICTNAME", nullable=false, length=200)

    public String getDictname() {
        return this.dictname;
    }
    
    public void setDictname(String dictname) {
        this.dictname = dictname;
    }
    
    @Column(name="DICTNOTE", length=800)

    public String getDictnote() {
        return this.dictnote;
    }
    
    public void setDictnote(String dictnote) {
        this.dictnote = dictnote;
    }
    
    @Column(name="DICTVALUE", nullable=false, length=200)

    public String getDictvalue() {
        return this.dictvalue;
    }
    
    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue;
    }
   








}