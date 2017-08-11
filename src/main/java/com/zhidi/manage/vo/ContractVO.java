package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-03.
 */
public class ContractVO {
    private String contractid;
    private String businessid;//
    private String businessCustomerId;
    private String businessCustomerName;
    private String contractnumber;
    private Double price;
    private String duetime;//
    private String ownerUserId;//
    private String ownerUserName;//
    private String createUserId;//
    private String businessConnectionId;//
    private String businessConnectionName;//
    //private byte[] contractcontent;
    private String contractcontent;
    private String description;
    private String createtime;//
    private String updatetime;//
    private String startdate;//
    private String enddate;//
    private String status;
    private Boolean isdeleted;
    private String deleteUserId;
    public static Contract toContract(ContractVO contractVO){
        if(contractVO != null){
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractVO,contract);
            Business business = new Business();
            business.setBusinessid(contractVO.getBusinessid());
            contract.setBusiness(business);
            User user = new User();
            user.setId(contractVO.getOwnerUserId());
            contract.setOwnerUser(user);
            contract.setUpdatetime(new Date());
            contract.setDuetime(DateUtil.parseDate(contractVO.getDuetime(),"yyyy-MM-dd HH:mm:sss"));
            contract.setStartdate(DateUtil.parseDate(contractVO.getStartdate(),"yyyy-MM-dd HH:mm:ss"));
            contract.setEnddate(DateUtil.parseDate(contractVO.getEnddate(),"yyyy-MM-dd HH:mm:ss"));
            if(contractVO.getContractid()!=null && !"".equals(contractVO.getContractid())){
                contract.setCreatetime(DateUtil.parseDate(contractVO.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
                User user1 = new User();
                user1.setId(contractVO.getCreateUserId());
                contract.setCreateUser(user1);
            }else{
                contract.setCreatetime(new Date());
            }
            if(!"".equals(contractVO.getContractcontent())){
                contract.setContractcontent(contractVO.getContractcontent().getBytes());
            }
            return contract;
        }
        return null;
    }
    public static ContractVO fromContract(Contract contract){
        if(contract!=null){
            ContractVO contractVO = new ContractVO();
            BeanUtils.copyProperties(contract,contractVO);
            if(contract.getContractcontent()!=null){
                contractVO.setContractcontent(new String(contract.getContractcontent()));
            }
            if(contract.getBusiness()!=null){
                contractVO.setBusinessid(contract.getBusiness().getBusinessid());
                if(contract.getBusiness().getCustomer()!=null){
                    contractVO.setBusinessCustomerId(contract.getBusiness().getCustomer().getCustomerid());
                    contractVO.setBusinessCustomerName(contract.getBusiness().getCustomer().getName());
                }
            }
            contractVO.setDuetime(DateUtil.formatDate(contract.getDuetime(),"yyyy-MM-dd HH:mm:ss"));
            contractVO.setCreatetime(DateUtil.formatDate(contract.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            contractVO.setUpdatetime(DateUtil.formatDate(contract.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            contractVO.setStartdate(DateUtil.formatDate(contract.getStartdate(),"yyyy-MM-dd HH:mm:ss"));
            contractVO.setEnddate(DateUtil.formatDate(contract.getEnddate(),"yyyy-MM-dd HH:mm:ss"));
            if(contract.getOwnerUser()!=null){
                contractVO.setOwnerUserId(contract.getOwnerUser().getId());
                contractVO.setOwnerUserName(contract.getOwnerUser().getUsername());
            }
            if(contract.getCreateUser()!=null){
                contractVO.setCreateUserId(contract.getCreateUser().getId());

            }
            if(contract.getBusiness()!=null){
                if(contract.getBusiness().getBusinessContacts()!=null){
                    contractVO.setBusinessConnectionId(contract.getBusiness().getBusinessContacts().getContactsid());
                    contractVO.setBusinessConnectionName(contract.getBusiness().getBusinessContacts().getName());
                }
            }

            if(contract.getDeleteUser()!=null){
                contractVO.setDeleteUserId(contract.getDeleteUser().getId());
            }
            return contractVO;
        }
        return null;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDuetime() {
        return duetime;
    }

    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getBusinessConnectionId() {
        return businessConnectionId;
    }

    public void setBusinessConnectionId(String businessConnectionId) {
        this.businessConnectionId = businessConnectionId;
    }

    public String getBusinessConnectionName() {
        return businessConnectionName;
    }

    public void setBusinessConnectionName(String businessConnectionName) {
        this.businessConnectionName = businessConnectionName;
    }

    public String getContractcontent() {
        return contractcontent;
    }

    public void setContractcontent(String contractcontent) {
        this.contractcontent = contractcontent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeleteUserId() {
        return deleteUserId;
    }

    public void setDeleteUserId(String deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    public String getBusinessCustomerName() {
        return businessCustomerName;
    }

    public void setBusinessCustomerName(String businessCustomerName) {
        this.businessCustomerName = businessCustomerName;
    }

    public String getBusinessCustomerId() {
        return businessCustomerId;
    }

    public void setBusinessCustomerId(String businessCustomerId) {
        this.businessCustomerId = businessCustomerId;
    }
}
