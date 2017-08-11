package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.MessageVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@ParentPackage("struts-default")
@Namespace("/system/message")
public class MessageAction extends BaseAction{

    private Integer page;
    private Integer rows;
    private List<User> list;
    private MessageVO messageVO;
    /**
     * 转到message页面
     * @return
     */
    @Action(value = "MessageAction_list",results = {
            @Result(location = "list_message.jsp")
    })
    public String messageAction_list(){
        return SUCCESS;
    }
    @Action(value = "MessageAction_findByPage")
    public void messageAction_findByPage() throws IOException{
        pager = messageService.getMessageListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("成功",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到写信界面
     * @return
     */
    @Action(value = "MessageAction_edit",results = {
            @Result(location = "write_message.jsp")
    })
    public String messageAction_edit(){
        list = userSerivce.getAll();
        return SUCCESS;
    }

    @Action(value = "MessageAction_save")
    public void messageAction_save() throws IOException{
        messageVO.setUserByFromuserId(((User)getSession().getAttribute("user")).getId());
        messageService.saveMessageVO(messageVO);
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

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public MessageVO getMessageVO() {
        return messageVO;
    }

    public void setMessageVO(MessageVO messageVO) {
        this.messageVO = messageVO;
    }
}
