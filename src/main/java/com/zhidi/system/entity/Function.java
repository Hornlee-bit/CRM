package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Function entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_SYSTEM_FUNCTION"
    ,schema="REDTEA"
, uniqueConstraints = @UniqueConstraint(columnNames="FUNCCODE")
)

public class Function  implements java.io.Serializable {


    // Fields    

     private String id;
     private User userByUpdateby;
     private Function function;
     private User userByCreateby;
     private Date createtime;
     private String funccode;
     private String funcname;
     private String funcnote;
     private Integer functype;
     private String funcurl;
     private String iconclass;
     private String iconurl;
     private Integer sortnum;
     private Integer status;
     private Date updatetime;
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<Function> functions = new HashSet<Function>(0);


    // Constructors

    /** default constructor */
    public Function() {
    }

	/** minimal constructor */
    public Function(String funccode, String funcname) {
        this.funccode = funccode;
        this.funcname = funcname;
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
        @JoinColumn(name="PARENTID")

    public Function getFunction() {
        return this.function;
    }
    
    public void setFunction(Function function) {
        this.function = function;
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
    
    @Column(name="FUNCCODE", unique=true, nullable=false, length=200)

    public String getFunccode() {
        return this.funccode;
    }
    
    public void setFunccode(String funccode) {
        this.funccode = funccode;
    }
    
    @Column(name="FUNCNAME", nullable=false, length=80)

    public String getFuncname() {
        return this.funcname;
    }
    
    public void setFuncname(String funcname) {
        this.funcname = funcname;
    }
    
    @Column(name="FUNCNOTE", length=1020)

    public String getFuncnote() {
        return this.funcnote;
    }
    
    public void setFuncnote(String funcnote) {
        this.funcnote = funcnote;
    }
    
    @Column(name="FUNCTYPE", precision=10, scale=0)

    public Integer getFunctype() {
        return this.functype;
    }
    
    public void setFunctype(Integer functype) {
        this.functype = functype;
    }
    
    @Column(name="FUNCURL", length=1020)

    public String getFuncurl() {
        return this.funcurl;
    }
    
    public void setFuncurl(String funcurl) {
        this.funcurl = funcurl;
    }
    
    @Column(name="ICONCLASS", length=1020)

    public String getIconclass() {
        return this.iconclass;
    }
    
    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }
    
    @Column(name="ICONURL", length=1020)

    public String getIconurl() {
        return this.iconurl;
    }
    
    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
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
    
    @Column(name="UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="functions")

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="function")

    public Set<Function> getFunctions() {
        return this.functions;
    }
    
    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }
   








}