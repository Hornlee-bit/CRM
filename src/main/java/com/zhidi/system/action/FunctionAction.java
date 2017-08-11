package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.FunctionVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-28.
 */
@ParentPackage("struts-default")
@Namespace("/system/function")
public class FunctionAction extends BaseAction{

    private String ids;
    private List<FunctionVO> list;
    private FunctionVO funcVO;
    private String id;
    private List<Function> functionList;
    /**
     * 转到权限管理页面Action
     * @return
     */
    @Action(value = "FunctionAction_list",results = {
            @Result(location = "list_function.jsp")
    })
    public String functionAction_list(){
        return SUCCESS;
    }

    /**
     * 转到新增和修改页面Action
     */
    @Action(value = "FunctionAction_edit",results = {
            @Result(location = "edit_function.jsp")
    })
    public String functionAction_edit(){
         if(funcVO!=null){
             funcVO = functionService.getFunctionVOById(funcVO.getId());
         }
         functionList = functionService.getAll();
         return SUCCESS;
    }

    /**
     * 新增和修改权限Action
     */
    @Action(value = "FunctionAction_saveOrUpdate")
    public void functionAction_saveOrUpdate() throws IOException{
        if(funcVO.getId().length()!=0){
            Function function = functionService.get(funcVO.getId());
            BeanUtils.copyProperties(FunctionVO.toFunction(funcVO),function);
            Function function1 = new Function();
            if(!"-1".equals(funcVO.getParentId())){
                function1.setId(funcVO.getParentId());
                function.setFunction(function1);
            }
            function.setUserByUpdateby((User) getSession().getAttribute("user"));
            function.setUpdatetime(new Date());
            functionService.update(function);
            resultData = ResultData.buildSuccessResult("修改成功");
            printJSONObject(resultData);
            return;
        }
        Function function = FunctionVO.toFunction(funcVO);
        function.setUserByCreateby((User) getSession().getAttribute("user"));
        function.setCreatetime(new Date());
        Function function1 = new Function();
        if(!"-1".equals(funcVO.getParentId())){
            function1.setId(funcVO.getParentId());
            function.setFunction(function1);
        }
        functionService.save(function);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }
    /**
     * 删除权限Action
     */
    @Action(value = "FunctionAction_remove")
    public void functionAction_remove() throws IOException{
        boolean state = functionService.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }
    /**
     * 获取所有FunctionVO
     * @throws IOException
     */
    @Action(value = "FunctionAction_findAll")
    public void functionAction_findAll() throws IOException{
        list = functionService.getAllFunctionVO();
        resultData = ResultData.buildSuccessResult("成功",list);
        printJSONObject(resultData);
    }

    /**
     * 根据角色的id获取到当前角色的所有权限信息
     */
    @Action(value = "FunctionAction_findByRoleIds")
    public void functionAction_findByRoleIds() throws IOException{
        functionList = functionService.findFunctionsByRoleId(ids);
        resultData = ResultData.buildSuccessResult("success",functionList);
        printJSONObject(resultData,new String[]{"userByUpdateby","userByCreateby","roles","functions"});
    }


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<FunctionVO> getList() {
        return list;
    }

    public void setList(List<FunctionVO> list) {
        this.list = list;
    }

    public FunctionVO getFuncVO() {
        return funcVO;
    }

    public void setFuncVO(FunctionVO funcVO) {
        this.funcVO = funcVO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Function> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<Function> functionList) {
        this.functionList = functionList;
    }
}
