package com.zhidi.system.entity;
// default package

import com.zhidi.manage.entity.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SYSTEM_USER"
        , schema = "REDTEA"
        , uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME")
)

public class User implements java.io.Serializable {


    // Fields    

    private String id;
    private User userByUpdateby;
    private User userByCreateby;
    private Date createtime;
    private String email;
    private String password;
    private String phone;
    private String salt;
    private Integer sortnum;
    private Integer status;
    private Date updatetime;
    private String usernote;
    private String username;
    private Set<Customer> followCustomers = new HashSet<Customer>();
    private Employee emp;
    private Set<Role> roles = new HashSet<Role>(0);
    private Set<Contacts> businessContactsesForDeleteuserid = new HashSet<Contacts>(0);
    private Set<EmailRecord> emailRecords = new HashSet<EmailRecord>(0);
    private Set<Product> products = new HashSet<Product>(0);
    private Set<Message> messagesForFromuserid = new HashSet<Message>(0);
    private Set<Business> businessesForCreatoruserid = new HashSet<Business>(0);
    private Set<Task> tasksForOwneruserid = new HashSet<Task>(0);
    private Set<Task> tasksForCreatoruserid = new HashSet<Task>(0);
    private Set<DictType> dictTypesForUpdateby = new HashSet<DictType>(0);
    private Set<Business> businessesForDeleteuserid = new HashSet<Business>(0);
    private Set<Task> tasksForDeleteuserid = new HashSet<Task>(0);
    private Set<Leads> leadsesForOwneruserid = new HashSet<Leads>(0);
    private Set<User> usersForUpdateby = new HashSet<User>(0);
    private Set<Leads> leadsesForTransformuserid = new HashSet<Leads>(0);
    private Set<Business> businessesForOwneruserid = new HashSet<Business>(0);
    private Set<Customer> customersForCreatoruserid = new HashSet<Customer>(0);
    private Set<Announcement> announcements = new HashSet<Announcement>(0);
    private Set<Function> functionsForUpdateby = new HashSet<Function>(0);
    private Set<Leads> leadsesForCreatoruserid = new HashSet<Leads>(0);
    private Set<DictType> dictTypesForCreateby = new HashSet<DictType>(0);
    private Set<User> usersForCreateby = new HashSet<User>(0);
    private Set<LoginHistory> loginHistories = new HashSet<LoginHistory>(0);
    private Set<Customer> customersForOwneruserid = new HashSet<Customer>(0);
    private Set<Role> rolesForCreateby = new HashSet<Role>(0);
    private Set<Business> businessesForUpdateuserid = new HashSet<Business>(0);
    private Set<Customer> customersForDeleteuserid = new HashSet<Customer>(0);
    private Set<Function> functionsForCreateby = new HashSet<Function>(0);
    private Set<Message> messagesForTouserid = new HashSet<Message>(0);
    private Set<SmsRecord> smsRecords = new HashSet<SmsRecord>(0);
    private Set<Leads> leadsesForDeleteuserid = new HashSet<Leads>(0);
    private Set<Role> rolesForUpdateby = new HashSet<Role>(0);
    private Set<Contacts> businessContactsesForCreatoruserid = new HashSet<Contacts>(0);


    // Constructors

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * minimal constructor
     */
    public User(String password, String username) {
        this.password = password;
        this.username = username;
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

    @Column(name = "EMAIL", length = 200)

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD", nullable = false, length = 128)

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "PHONE", length = 52)

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "SALT", length = 128)

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "SORTNUM", precision = 10, scale = 0)

    public Integer getSortnum() {
        return this.sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    @Column(name = "STATUS", precision = 10, scale = 0)

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

    @Column(name = "USERNOTE", length = 1020)

    public String getUsernote() {
        return this.usernote;
    }

    public void setUsernote(String usernote) {
        this.usernote = usernote;
    }

    @Column(name = "USERNAME", unique = true, nullable = false, length = 80)

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany()
    @JoinTable(name = "TB_SYSTEM_USER_ROLE", schema = "REDTEA", joinColumns = {
            @JoinColumn(name = "USERID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "ROLEID", nullable = false, updatable = false)})

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByDeleteuserid")

    public Set<Contacts> getBusinessContactsesForDeleteuserid() {
        return this.businessContactsesForDeleteuserid;
    }

    public void setBusinessContactsesForDeleteuserid(Set<Contacts> businessContactsesForDeleteuserid) {
        this.businessContactsesForDeleteuserid = businessContactsesForDeleteuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<EmailRecord> getEmailRecords() {
        return this.emailRecords;
    }

    public void setEmailRecords(Set<EmailRecord> emailRecords) {
        this.emailRecords = emailRecords;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByFromuserid")

    public Set<Message> getMessagesForFromuserid() {
        return this.messagesForFromuserid;
    }

    public void setMessagesForFromuserid(Set<Message> messagesForFromuserid) {
        this.messagesForFromuserid = messagesForFromuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreatoruserid")

    public Set<Business> getBusinessesForCreatoruserid() {
        return this.businessesForCreatoruserid;
    }

    public void setBusinessesForCreatoruserid(Set<Business> businessesForCreatoruserid) {
        this.businessesForCreatoruserid = businessesForCreatoruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByOwneruserid")

    public Set<Task> getTasksForOwneruserid() {
        return this.tasksForOwneruserid;
    }

    public void setTasksForOwneruserid(Set<Task> tasksForOwneruserid) {
        this.tasksForOwneruserid = tasksForOwneruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreatoruserid")

    public Set<Task> getTasksForCreatoruserid() {
        return this.tasksForCreatoruserid;
    }

    public void setTasksForCreatoruserid(Set<Task> tasksForCreatoruserid) {
        this.tasksForCreatoruserid = tasksForCreatoruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUpdateby")

    public Set<DictType> getDictTypesForUpdateby() {
        return this.dictTypesForUpdateby;
    }

    public void setDictTypesForUpdateby(Set<DictType> dictTypesForUpdateby) {
        this.dictTypesForUpdateby = dictTypesForUpdateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByDeleteuserid")

    public Set<Business> getBusinessesForDeleteuserid() {
        return this.businessesForDeleteuserid;
    }

    public void setBusinessesForDeleteuserid(Set<Business> businessesForDeleteuserid) {
        this.businessesForDeleteuserid = businessesForDeleteuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByDeleteuserid")

    public Set<Task> getTasksForDeleteuserid() {
        return this.tasksForDeleteuserid;
    }

    public void setTasksForDeleteuserid(Set<Task> tasksForDeleteuserid) {
        this.tasksForDeleteuserid = tasksForDeleteuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByOwneruserid")

    public Set<Leads> getLeadsesForOwneruserid() {
        return this.leadsesForOwneruserid;
    }

    public void setLeadsesForOwneruserid(Set<Leads> leadsesForOwneruserid) {
        this.leadsesForOwneruserid = leadsesForOwneruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUpdateby")

    public Set<User> getUsersForUpdateby() {
        return this.usersForUpdateby;
    }

    public void setUsersForUpdateby(Set<User> usersForUpdateby) {
        this.usersForUpdateby = usersForUpdateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByTransformuserid")

    public Set<Leads> getLeadsesForTransformuserid() {
        return this.leadsesForTransformuserid;
    }

    public void setLeadsesForTransformuserid(Set<Leads> leadsesForTransformuserid) {
        this.leadsesForTransformuserid = leadsesForTransformuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByOwneruserid")

    public Set<Business> getBusinessesForOwneruserid() {
        return this.businessesForOwneruserid;
    }

    public void setBusinessesForOwneruserid(Set<Business> businessesForOwneruserid) {
        this.businessesForOwneruserid = businessesForOwneruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreatoruserid")

    public Set<Customer> getCustomersForCreatoruserid() {
        return this.customersForCreatoruserid;
    }

    public void setCustomersForCreatoruserid(Set<Customer> customersForCreatoruserid) {
        this.customersForCreatoruserid = customersForCreatoruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<Announcement> getAnnouncements() {
        return this.announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUpdateby")

    public Set<Function> getFunctionsForUpdateby() {
        return this.functionsForUpdateby;
    }

    public void setFunctionsForUpdateby(Set<Function> functionsForUpdateby) {
        this.functionsForUpdateby = functionsForUpdateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreatoruserid")

    public Set<Leads> getLeadsesForCreatoruserid() {
        return this.leadsesForCreatoruserid;
    }

    public void setLeadsesForCreatoruserid(Set<Leads> leadsesForCreatoruserid) {
        this.leadsesForCreatoruserid = leadsesForCreatoruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreateby")

    public Set<DictType> getDictTypesForCreateby() {
        return this.dictTypesForCreateby;
    }

    public void setDictTypesForCreateby(Set<DictType> dictTypesForCreateby) {
        this.dictTypesForCreateby = dictTypesForCreateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreateby")

    public Set<User> getUsersForCreateby() {
        return this.usersForCreateby;
    }

    public void setUsersForCreateby(Set<User> usersForCreateby) {
        this.usersForCreateby = usersForCreateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<LoginHistory> getLoginHistories() {
        return this.loginHistories;
    }

    public void setLoginHistories(Set<LoginHistory> loginHistories) {
        this.loginHistories = loginHistories;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByOwneruserid")

    public Set<Customer> getCustomersForOwneruserid() {
        return this.customersForOwneruserid;
    }

    public void setCustomersForOwneruserid(Set<Customer> customersForOwneruserid) {
        this.customersForOwneruserid = customersForOwneruserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreateby")

    public Set<Role> getRolesForCreateby() {
        return this.rolesForCreateby;
    }

    public void setRolesForCreateby(Set<Role> rolesForCreateby) {
        this.rolesForCreateby = rolesForCreateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUpdateuserid")

    public Set<Business> getBusinessesForUpdateuserid() {
        return this.businessesForUpdateuserid;
    }

    public void setBusinessesForUpdateuserid(Set<Business> businessesForUpdateuserid) {
        this.businessesForUpdateuserid = businessesForUpdateuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByDeleteuserid")

    public Set<Customer> getCustomersForDeleteuserid() {
        return this.customersForDeleteuserid;
    }

    public void setCustomersForDeleteuserid(Set<Customer> customersForDeleteuserid) {
        this.customersForDeleteuserid = customersForDeleteuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreateby")

    public Set<Function> getFunctionsForCreateby() {
        return this.functionsForCreateby;
    }

    public void setFunctionsForCreateby(Set<Function> functionsForCreateby) {
        this.functionsForCreateby = functionsForCreateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByTouserid")

    public Set<Message> getMessagesForTouserid() {
        return this.messagesForTouserid;
    }

    public void setMessagesForTouserid(Set<Message> messagesForTouserid) {
        this.messagesForTouserid = messagesForTouserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<SmsRecord> getSmsRecords() {
        return this.smsRecords;
    }

    public void setSmsRecords(Set<SmsRecord> smsRecords) {
        this.smsRecords = smsRecords;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByDeleteuserid")

    public Set<Leads> getLeadsesForDeleteuserid() {
        return this.leadsesForDeleteuserid;
    }

    public void setLeadsesForDeleteuserid(Set<Leads> leadsesForDeleteuserid) {
        this.leadsesForDeleteuserid = leadsesForDeleteuserid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUpdateby")

    public Set<Role> getRolesForUpdateby() {
        return this.rolesForUpdateby;
    }

    public void setRolesForUpdateby(Set<Role> rolesForUpdateby) {
        this.rolesForUpdateby = rolesForUpdateby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByCreatoruserid")

    public Set<Contacts> getBusinessContactsesForCreatoruserid() {
        return this.businessContactsesForCreatoruserid;
    }

    public void setBusinessContactsesForCreatoruserid(Set<Contacts> businessContactsesForCreatoruserid) {
        this.businessContactsesForCreatoruserid = businessContactsesForCreatoruserid;
    }

    @OneToOne(mappedBy = "user")
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @ManyToMany(mappedBy = "followUsers")
    public Set<Customer> getFollowCustomers() {
        return followCustomers;
    }

    public void setFollowCustomers(Set<Customer> followCustomers) {
        this.followCustomers = followCustomers;
    }


}