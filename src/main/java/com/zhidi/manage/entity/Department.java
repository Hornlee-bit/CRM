package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_DEPARTMENT"
    ,schema="REDTEA"
)

public class Department  implements java.io.Serializable {


    // Fields    

     private String departmentid;
     private Department department;
     private String name;
     private String description;
     private Set<Position> positions = new HashSet<Position>(0);//岗位
     private Set<Announcement> announcements = new HashSet<Announcement>(0);//公告
     private Set<Department> departments = new HashSet<Department>(0);//下级部门


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Department(Department department, String name, String description, Set<Position> positions, Set<Announcement> announcements, Set<Department> departments) {
        this.department = department;
        this.name = name;
        this.description = description;
        this.positions = positions;
        this.announcements = announcements;
        this.departments = departments;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="DEPARTMENTID", unique=true, nullable=false, length=32)

    public String getDepartmentid() {
        return this.departmentid;
    }
    
    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PARENTID")

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    @Column(name="NAME", nullable=false, length=50)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="DESCRIPTION", length=200)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")

    public Set<Position> getPositions() {
        return this.positions;
    }
    
    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")

    public Set<Announcement> getAnnouncements() {
        return this.announcements;
    }
    
    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")

    public Set<Department> getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

}