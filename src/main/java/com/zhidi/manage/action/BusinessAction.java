package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
@ParentPackage("struts-default")
@Namespace("/manage/business")
public class BusinessAction extends BaseAction {

    private Integer page;
    private Integer rows;
    private String conditionOne;
    private String searchText;
    private BusinessVO busiVO;

    @Action(value = "BusinessAction_findAll")
    public void BusinessAction_findAll() throws IOException{
        List<BusinessVO> list = businessService.getAllBusiness();
        resultData = ResultData.buildSuccessResult("success",list);
        printJSONObject(resultData);
    }
    @Action(value = "BusinessAction_index",results = {
            @Result(location = "index_business.jsp")
    })
    public String businessAction_index(){
        return SUCCESS;
    }

    @Action(value = "BusinessAction_list",results = {
            @Result(location = "list_business.jsp")
    })
    public String businessAction_list(){
        return SUCCESS;
    }
    /**
     * 分页查询商机信息
     */
    @Action(value = "BusinessAction_findByPage")
    public void businessAction_findByPage() throws IOException{
        pager = businessService.getBusinessByPage(page,rows,conditionOne,searchText);
        resultData = ResultData.buildSuccessResult("成功",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到新增界面
     * @return
     */
    @Action(value = "BusinessAction_edit",results = {
            @Result(location = "edit_business.jsp")
    })
    public String BusinessAction_edit(){
        return SUCCESS;
    }
    /**
     * 保存
     */
    @Action(value = "BusinessAction_saveOrUpdate")
    public void businessAction_saveOrUpdate() throws IOException{
        Business business = BusinessVO.toBusiness(busiVO);
        business.setCreatetime(new Date());
        business.setUserByCreatoruserid((User)getSession().getAttribute("user"));
        businessService.save(business);
        resultData = ResultData.buildSuccessResult();
        printJSONObject(resultData);
    }


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

    public String getConditionOne() {
        return conditionOne;
    }

    public void setConditionOne(String conditionOne) {
        this.conditionOne = conditionOne;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public BusinessVO getBusiVO() {
        return busiVO;
    }

    public void setBusiVO(BusinessVO busiVO) {
        this.busiVO = busiVO;
    }
}
