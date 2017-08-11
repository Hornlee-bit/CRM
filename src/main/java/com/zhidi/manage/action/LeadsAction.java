package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Administrator on 2017-08-02.
 */
@ParentPackage("struts-default")
@Namespace("/manage/leads")
public class LeadsAction extends BaseAction{

    @Action(value = "LeadAction_list" ,results = {
            @Result(location = "index.jsp")
    })
    public String leadAction_list(){
        return SUCCESS;
    }
}
