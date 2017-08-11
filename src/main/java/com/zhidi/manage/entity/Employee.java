package com.zhidi.manage.entity;
// default package

import com.zhidi.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_EMPLOYEE"
    ,schema="REDTEA"
)

public class Employee  implements java.io.Serializable {


    // Fields    

     private String empid;
     private Position position;
     private Integer status;
     private String name;
     private String img;
     private Byte sex;
     private String email;
     private String telephone;
     private String address;
     private Date createtime;
     private String createby;
     private Date updatetime;
     private String updateby;
     private User user;


    // Constructors

    /** default constructor */
    public Employee() {
    }

	/** minimal constructor */
    public Employee(Integer status, String name) {
        this.status = status;
        this.name = name;
    }
    
  
   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="EMPID", unique=true, nullable=false, length=32)

    public String getEmpid() {
        return this.empid;
    }
    
    public void setEmpid(String empid) {
        this.empid = empid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="POSITIONID")

    public Position getPosition() {
        return this.position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    @Column(name="STATUS",  precision=10, scale=0)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="NAME", length=20)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="IMG", length=100)

    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    @Column(name="SEX", precision=2, scale=0)

    public Byte getSex() {
        return this.sex;
    }
    
    public void setSex(Byte sex) {
        this.sex = sex;
    }
    
    @Column(name="EMAIL", length=30)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="TELEPHONE", length=20)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name="ADDRESS", length=100)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="CREATEBY", length=32)

    public String getCreateby() {
        return this.createby;
    }
    
    public void setCreateby(String createby) {
        this.createby = createby;
    }
    
    @Column(name="UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="UPDATEBY", length=32)

    public String getUpdateby() {
        return this.updateby;
    }
    
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }
    
    @ManyToOne(targetEntity=User.class)
	@JoinColumn(name="USERID",unique=true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
    







}