package com.zhidi.system.entity;
// default package

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SYSTEM_ROLE"
        , schema = "REDTEA"
        , uniqueConstraints = @UniqueConstraint(columnNames = "ROLENAME")
)

public class Role implements java.io.Serializable {


    // Fields    

    private String id;
    private User userByUpdateby;
    private User userByCreateby;
    private Date createtime;
    private String rolename;
    private String rolenote;
    private Integer sortnum;
    private Integer status;
    private Date updatetime;
    private Set<Function> functions = new HashSet<Function>(0);
    private Set<User> users = new HashSet<User>(0);


    // Constructors

    /**
     * default constructor
     */
    public Role() {
    }

    /**
     * minimal constructor
     */
    public Role(String rolename) {
        this.rolename = rolename;
    }


    // Property accessors
    @GenericGenerator(name = "generator", strategy = "uuid")
    @Id
    @GeneratedValue(generator = "generator")

    @Column(name = "ID", unique = true, nullable = false, length = 1020)

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATEBY")

    public User getUserByUpdateby() {
        return this.userByUpdateby;
    }

    public void setUserByUpdateby(User userByUpdateby) {
        this.userByUpdateby = userByUpdateby;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATEBY")

    public User getUserByCreateby() {
        return this.userByCreateby;
    }

    public void setUserByCreateby(User userByCreateby) {
        this.userByCreateby = userByCreateby;
    }

    @Column(name = "CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "ROLENAME", unique = true, nullable = false, length = 80)

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Column(name = "ROLENOTE", length = 1020)

    public String getRolenote() {
        return this.rolenote;
    }

    public void setRolenote(String rolenote) {
        this.rolenote = rolenote;
    }

    @Column(name = "SORTNUM", precision = 10, scale = 0)

    public Integer getSortnum() {
        return this.sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    @Column(name = "STATUS", precision = 22, scale = 0)

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @ManyToMany()
    @JoinTable(name = "TB_SYSTEM_ROLE_FUNCTION", schema = "REDTEA", joinColumns = {
            @JoinColumn(name = "ROLEID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "FUNCID", nullable = false, updatable = false)})

    public Set<Function> getFunctions() {
        return this.functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}