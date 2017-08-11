package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DictType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_SYSTEM_DICT_TYPE"
    ,schema="REDTEA"
, uniqueConstraints = @UniqueConstraint(columnNames="TYPECODE")
)

public class DictType  implements java.io.Serializable {


    // Fields    

     private String id;
     private String typename;
     private String typecode;
     private String typenote;
     private Integer sortnum;
     private Integer status;
     private User userByCreateby;
     private User userByUpdateby;
     private Date createtime;
     private Date updatetime;
     private Integer version;
     private Set<Dict> dicts = new HashSet<Dict>(0);


    // Constructors

    /** default constructor */
    public DictType() {
    }

	/** minimal constructor */
    public DictType(String typecode, String typename) {
        this.typecode = typecode;
        this.typename = typename;
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
        @JoinColumn(name="UPDATEBY")

    public User getUserByUpdateby() {
        return this.userByUpdateby;
    }
    
    public void setUserByUpdateby(User userByUpdateby) {
        this.userByUpdateby = userByUpdateby;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CREATEBY")

    public User getUserByCreateby() {
        return this.userByCreateby;
    }
    
    public void setUserByCreateby(User userByCreateby) {
        this.userByCreateby = userByCreateby;
    }
    
    @Column(name="CREATETIME")

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
    
    @Column(name="STATUS", precision=10, scale=0)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="TYPECODE", unique=true, nullable=false, length=200)

    public String getTypecode() {
        return this.typecode;
    }
    
    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }
    
    @Column(name="TYPENAME", nullable=false, length=200)

    public String getTypename() {
        return this.typename;
    }
    
    public void setTypename(String typename) {
        this.typename = typename;
    }
    
    @Column(name="TYPENOTE", length=800)

    public String getTypenote() {
        return this.typenote;
    }
    
    public void setTypenote(String typenote) {
        this.typenote = typenote;
    }
    
    @Column(name="UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="VERSION", precision=10, scale=0)

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
@OneToMany(mappedBy="dictType")

    public Set<Dict> getDicts() {
        return this.dicts;
    }
    
    public void setDicts(Set<Dict> dicts) {
        this.dicts = dicts;
    }
   








}