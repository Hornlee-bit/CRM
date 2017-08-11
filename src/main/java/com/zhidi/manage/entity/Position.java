package com.zhidi.manage.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Position entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_POSITION"
    ,schema="REDTEA"
)

public class Position  implements java.io.Serializable {


    // Fields    

     private String positionid;
     private Department department;
     private Position position;
     private String name;
     private String description;
     private Set<Employee> employees = new HashSet<Employee>(0);
     private Set<Position> positions = new HashSet<Position>(0);
     
     

    // Constructors

    /** default constructor */
    public Position() {
    }

	/** minimal constructor */
    public Position(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Position(Department department, Position position, String name, String description, Set<Employee> employees, Set<Position> positions) {
        this.department = department;
        this.position = position;
        this.name = name;
        this.description = description;
        this.employees = employees;
        this.positions = positions;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="POSITIONID", unique=true, nullable=false, length=32)

    public String getPositionid() {
        return this.positionid;
    }
    
    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DEPARTMENTID")

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PARENTID")

    public Position getPosition() {
        return this.position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    @Column(name="NAME", nullable=false, length=20)

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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="position")

    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="position")

    public Set<Position> getPositions() {
        return this.positions;
    }
    
    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
   








}