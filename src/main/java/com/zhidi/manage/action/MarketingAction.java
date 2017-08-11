package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Administrator on 2017-08-03.
 */
@ParentPackage("struts-default")
@Namespace("/manage/marketing")
public class MarketingAction extends BaseAction {
    @Action(value = "MarketingAction_email",results = {
            @Result(location = "email_marketing.jsp")
    })
    public String MarketingAction_email(){
        return SUCCESS;
    }

    @Action(value = "MarketingAction_sendemail",results = {
            @Result(location = "sendemail_marketing.jsp")
    })
    public String MarketingAction_sendemail(){
        return SUCCESS;
    }
    @Action(value = "MarketingAction_sendmsg",results = {
            @Result(location = "sendmsg_marketing.jsp")
    })
    public String marketingAction_sendmsg(){
        return SUCCESS;
    }
}
