package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;

/**
 * Created by Administrator on 2017-08-03.
 */
@ParentPackage("struts-default")
@Namespace("/manage/task")
public class TaskAction extends BaseAction{

    private Integer page;
    private Integer rows;
    private String ids;
    @Action(value = "TaskAction_list",results = {
            @Result(location = "list_task.jsp")
    })
    public String taskAction_list(){
        return SUCCESS;
    }

    @Action(value = "TaskAction_findByPage")
    public void taskAction_findByPage() throws IOException{
        pager = taskService.getTaskListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("success",pager);
        printJSONObject(resultData);
    }
    @Action(value = "TaskAction_del")
    public void taskAction_del() throws IOException{
        boolean state = taskService.deleteByIds(ids);
        if(state){
            resultData = ResultData.buildSuccessResult("删除成功");
        }else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    /**
     * 转到修改和新增界面
     * @return
     */
    @Action(value = "TaskAction_edit",results = {
            @Result(location = "edit_task.jsp")
    })
    public String taskAction_edit(){
        return SUCCESS;
    }

    /**
     * 保存和修改
     */
    @Action(value = "TaskAction_saveOrUpdate")
    public void taskAction_saveOrUpdate(){

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
}
