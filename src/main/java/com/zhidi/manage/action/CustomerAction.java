package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.vo.CustomerVO;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@ParentPackage("struts-default")
@Namespace("/manage/customer")
public class CustomerAction extends BaseAction {
    private CustomerVO customerVO;
    private String customerid;
    private String name;
    private String address;
    private String industryName;
    private Date createtimeStart;

    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    //    点击客户管理跳转到客户管理主页
    @Action(value = "CustomerAction_customer", results = {
            @Result(location = "list.jsp")
    })
    public String toPage() {
        return SUCCESS;
    }

    //    查询是否关注
    @Action(value = "islocked")
    public void islocked() throws IOException {

        customerVO = customerService.getByVo(customerid);
        if (customerVO.getIslocked()) {
            resultData = ResultData.buildSuccessResult();
            printJSONObject(resultData);
        } else {
            resultData = ResultData.buildFailureResult();
            printJSONObject(resultData);
        }
    }

    //    分页查询的数据
    @Action(value = "listByPage")
    public void listByPage() throws IOException {
        if (pager == null) {
            pager = new Pager();
            pager.setPageSize(rows);
            pager.setPageNumber(page);
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//        带参数的分页查询
        if (StringUtils.isNotEmpty(name)){
            criteria.add(Restrictions.like("name","%"+name+"%"));
        }
        if (StringUtils.isNotEmpty(industryName)){
            criteria.add(Restrictions.like("industry","%"+industryName+"%"));
        }
        if (StringUtils.isNotEmpty(address)){
            criteria.add(Restrictions.like("address","%"+address+"%"));
        }
        if (createtimeStart != null){
            criteria.add(Restrictions.ge("createtime",createtimeStart));
        }
        pager = customerService.listVoByPage(pager, criteria);
        resultData = ResultData.buildSuccessResult("获取成功", pager);
        printJSONObject(resultData);
    }
    @Action(value = "CustomerAction_findAll")
    public void CustomerAction_findAll() throws IOException{
        List<Customer> list = customerService.getAll();
        resultData = ResultData.buildSuccessResult("",list);
        printJSONObject(resultData,"userByCreatoruserid","userByOwneruserid","userByDeleteuserid",
                 "contactses","followUsers","businesses","businesses_1","leadses");
    }

    /**
     * 关注客户
     */
    @Action(value = "CustomerAction_follow")
    public void CustomerAction_follow() throws IOException{
        Customer customer = customerService.get(customerid);
        customer.setIslocked(true);
        customerService.update(customer);
        resultData = ResultData.buildSuccessResult();
        printJSONObject(resultData);
    }

    /**
     * 取消客户
     */
    @Action(value = "CustomerAction_unfollow")
    public void CustomerAction_unfollow() throws IOException{
        Customer customer = customerService.get(customerid);
        customer.setIslocked(false);
        customerService.update(customer);
        resultData = ResultData.buildSuccessResult();
        printJSONObject(resultData);
    }
    public CustomerVO getCustomerVO() {
        return customerVO;
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO = customerVO;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Date getCreatetimeStart() {
        return createtimeStart;
    }

    public void setCreatetimeStart(Date createtimeStart) {
        this.createtimeStart = createtimeStart;
    }
}
