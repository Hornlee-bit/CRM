package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.BusinessStatus;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-04.
 */
public class BusinessVO {
    private String businessid;
    private String createById;
    private String createByName;
    private String businessStatusId;
    private String updateById;
    //private Contacts businessContacts;
    private String contactsId;
    private String contactsName;
    private String ownerId;
    private String ownerName;
    private String customerId;
    private String customerName;
    private String deleteById;
    private String name;
    private String origin;//信息来源
    private String type;//商机类型
    private Integer estimateprice;//预计成交价
    private Short gainrate;//赢单率
    private Integer totalamount;
    private Double subtotalval;
    private Double discountprice;
    private Double salesprice;//商机金额，售价
    private String duedate;
    private String createtime;
    private String updatetime;
    private Double totalprice;
    private String nextstep;//下次联系内容
    private String nextsteptime;//下次联系时间
    private Byte isdeleted;
    private String deletetime;
    private String contractaddress;
    private String description;
    public static BusinessVO fromBusiness(Business business){
        if(business!=null){
            BusinessVO businessVO = new BusinessVO();
            BeanUtils.copyProperties(business,businessVO);
            if(business.getUserByCreatoruserid()!=null){
                businessVO.setCreateById(business.getUserByCreatoruserid().getId());
                businessVO.setCreateByName(business.getUserByCreatoruserid().getUsername());
            }
            if(business.getBusinessStatus()!=null){
                businessVO.setBusinessStatusId(business.getBusinessStatus().getStatusid());
            }
            if(business.getUserByUpdateuserid()!=null){
                businessVO.setUpdateById(business.getUserByUpdateuserid().getId());
            }
            if(business.getBusinessContacts()!=null){
                businessVO.setContactsId(business.getBusinessContacts().getContactsid());
                businessVO.setContactsName(business.getBusinessContacts().getName());
            }
            if(business.getUserByOwneruserid()!=null){
                businessVO.setOwnerId(business.getUserByOwneruserid().getId());
                businessVO.setOwnerName(business.getUserByOwneruserid().getUsername());
            }
            if(business.getCustomer()!=null){
                businessVO.setCustomerId(business.getCustomer().getCustomerid());
                businessVO.setCustomerName(business.getCustomer().getName());
            }
            if(business.getUserByDeleteuserid()!=null){
                businessVO.setDeleteById(business.getUserByDeleteuserid().getId());
            }
            businessVO.setCreatetime(DateUtil.formatDate(business.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            businessVO.setUpdatetime(DateUtil.formatDate(business.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            businessVO.setNextsteptime(DateUtil.formatDate(business.getNextsteptime(),"yyyy-MM-dd HH:mm:ss"));
            businessVO.setDeletetime(DateUtil.formatDate(business.getDeletetime(),"yyyy-MM-dd HH:mm:ss"));
            return businessVO;
        }
        return null;
    }

    public static Business toBusiness(BusinessVO businessVO){
        if(businessVO!=null){
            Business business = new Business();
            BeanUtils.copyProperties(businessVO,business);
            if(!"".equals(businessVO.getBusinessStatusId())){
                BusinessStatus businessStatus = new BusinessStatus();
                businessStatus.setStatusid(businessVO.getBusinessStatusId());
                business.setBusinessStatus(businessStatus);
            }
            if(!"".equals(businessVO.getContactsId())){
                Contacts contacts = new Contacts();
                contacts.setContactsid(businessVO.getContactsId());
                business.setBusinessContacts(contacts);
            }
            if(!"".equals(businessVO.getOwnerId())){
                User user = new User();
                user.setId(businessVO.getOwnerId());
                business.setUserByOwneruserid(user);
            }
            if(!"".equals(businessVO.getCustomerId())){
                Customer customer = new Customer();
                customer.setCustomerid(businessVO.getCustomerId());
                business.setCustomer(customer);
            }
            if(!"".equals(businessVO.getDeleteById()) && businessVO.getDeleteById()!=null){
                User user = new User();
                user.setId(businessVO.getDeleteById());
                business.setUserByDeleteuserid(user);
            }
            if("".equals(businessVO.getBusinessid())){
                business.setCreatetime(new Date());
            }else{
                business.setCreatetime(DateUtil.parseDate(businessVO.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            }
            business.setUpdatetime(new Date());
            business.setNextsteptime(DateUtil.parseDate(businessVO.getNextsteptime(),"yyyy-MM-dd"));
            return business;
        }
        return null;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getBusinessStatusId() {
        return businessStatusId;
    }

    public void setBusinessStatusId(String businessStatusId) {
        this.businessStatusId = businessStatusId;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeleteById() {
        return deleteById;
    }

    public void setDeleteById(String deleteById) {
        this.deleteById = deleteById;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEstimateprice() {
        return estimateprice;
    }

    public void setEstimateprice(Integer estimateprice) {
        this.estimateprice = estimateprice;
    }

    public Short getGainrate() {
        return gainrate;
    }

    public void setGainrate(Short gainrate) {
        this.gainrate = gainrate;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    public Double getSubtotalval() {
        return subtotalval;
    }

    public void setSubtotalval(Double subtotalval) {
        this.subtotalval = subtotalval;
    }

    public Double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    public Double getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
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

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getNextstep() {
        return nextstep;
    }

    public void setNextstep(String nextstep) {
        this.nextstep = nextstep;
    }

    public String getNextsteptime() {
        return nextsteptime;
    }

    public void setNextsteptime(String nextsteptime) {
        this.nextsteptime = nextsteptime;
    }

    public Byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }

    public String getContractaddress() {
        return contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }
}
