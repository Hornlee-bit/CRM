package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
@ParentPackage("struts-default")
@Namespace("/manage/contract")
public class ContractAction extends BaseAction {
    private Integer page;
    private Integer rows;
    private String ids;
    private String conditionOne; //1表示客户 2 表示联系人 3 表示负责人
    private String conditionTwo; //1表示包含字段，模糊查询 2 表示精确查询
    private String contractCondition;
    private ContractVO contractVO;
    @Action(value = "ContractAction_findAll")
    public void contractAction_findAll() throws IOException{
        List<ContractVO> list = contractService.getAllContract();
        resultData = ResultData.buildSuccessResult("success",list);
        printJSONObject(resultData);
    }
    /**
     * 合同
     * @return
     */
    @Action(value = "ContractAction_list",results = {
            @Result(location = "list_contract.jsp")
    })
    public String contractAction_list(){
        return SUCCESS;
    }

    @Action(value = "ContractAction_findByPage")
    public void contractAction_findByPage() throws IOException{
        pager = contractService.getContractByPage(page,rows,conditionOne,conditionTwo,contractCondition);
        resultData = ResultData.buildSuccessResult("success",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到新增和修改界面
     */
    @Action(value = "ContractAction_edit",results = {
            @Result(location = "edit_contract.jsp")
    })
    public String ContractAction_edit(){
        if(contractVO!=null){
            contractVO = contractService.getContractVOById(contractVO.getContractid());
        }

        return SUCCESS;
    }

    @Action(value = "ContractAction_saveOrUpdate")
    public void contractAction_saveOrUpdate() throws IOException{
        if(!"".equals(contractVO.getContractid())){
            Contract contract = ContractVO.toContract(contractVO);
            contractService.update(contract);
            resultData = ResultData.buildSuccessResult("修改成功");
            printJSONObject(resultData);
            return;
        }
        //新增
        Contract contract = ContractVO.toContract(contractVO);
        contract.setCreateUser((User) getSession().getAttribute("user"));
        contractService.save(contract);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }
    /**
     * 删除合同
     */
    @Action(value = "ContractAction_delete")
    public void contractAction_delete() throws IOException{
        boolean state = contractService.deleteByIds(ids);
        if(state){
            resultData = ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData = ResultData.buildFailureResult("删除失败");
        }
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getConditionTwo() {
        return conditionTwo;
    }

    public void setConditionTwo(String conditionTwo) {
        this.conditionTwo = conditionTwo;
    }

    public String getContractCondition() {
        return contractCondition;
    }

    public void setContractCondition(String contractCondition) {
        this.contractCondition = contractCondition;
    }

    public String getConditionOne() {
        return conditionOne;
    }

    public void setConditionOne(String conditionOne) {
        this.conditionOne = conditionOne;
    }

    public ContractVO getContractVO() {
        return contractVO;
    }

    public void setContractVO(ContractVO contractVO) {
        this.contractVO = contractVO;
    }
}
