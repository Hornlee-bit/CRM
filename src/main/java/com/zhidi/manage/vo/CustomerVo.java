package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Customer;
import com.zhidi.util.DateUtil;

/**
 * Created by Administrator on 2017/8/2.
 */
public class CustomerVO {

    private String customerid;
    private String userByCreatorusername;
    private String userByOwnerusername;
    private String userByDeleteuserid;
    private String name;
    private String origin;
    private String address;
    private String zipcode;
    private String industry;
    private String annualrevenue;
    private String ownership;
    private String rating;
    private String createtime;
    private String updatetime;
    private Boolean isdeleted;
    private Boolean islocked;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getUserByCreatorusername() {
        return userByCreatorusername;
    }

    public void setUserByCreatorusername(String userByCreatorusername) {
        this.userByCreatorusername = userByCreatorusername;
    }

    public String getUserByOwnerusername() {
        return userByOwnerusername;
    }

    public void setUserByOwnerusername(String userByOwnerusername) {
        this.userByOwnerusername = userByOwnerusername;
    }

    public String setUserByDeleteuserid() {
        return userByDeleteuserid;
    }

    public String getUserByDeleteuserid() {
        return userByDeleteuserid;
    }

    public void setUserByDeleteuserid(String setUserByDeleteuserid) {
        this.userByDeleteuserid = setUserByDeleteuserid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAnnualrevenue() {
        return annualrevenue;
    }

    public void setAnnualrevenue(String annualrevenue) {
        this.annualrevenue = annualrevenue;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Boolean getIslocked() {
        return islocked;
    }

    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }

    public static CustomerVO parseVoCustomer(Customer customer){
        if (customer != null ){
            CustomerVO customerVO = new CustomerVO();
            customerVO.setName(customer.getName());
            customerVO.setAddress(customer.getAddress());
            customerVO.setAnnualrevenue(customer.getAnnualrevenue());
            customerVO.setCreatetime(DateUtil.formatDate(customer.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            customerVO.setCustomerid(customer.getCustomerid());
            customerVO.setIndustry(customer.getIndustry());
            customerVO.setIsdeleted(customer.getIsdeleted());
            customerVO.setIslocked(customer.getIslocked());
            customerVO.setOrigin(customer.getOrigin());
            customerVO.setOwnership(customer.getOwnership());
            customerVO.setRating(customer.getRating());
            customerVO.setUpdatetime(DateUtil.formatDate(customer.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            customerVO.setUserByCreatorusername(customer.getUserByCreatoruserid() == null ? null : customer.getUserByCreatoruserid().getUsername());
            customerVO.setUserByOwnerusername(customer.getUserByOwneruserid() == null ? null : customer.getUserByOwneruserid().getUsername());
            customerVO.setUserByDeleteuserid(customer.getUserByDeleteuserid() == null ? null : customer.getUserByDeleteuserid().getId());
            customerVO.setZipcode(customer.getZipcode());
            return customerVO;
        }
        return null;
    }
}
