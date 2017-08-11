package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
@ParentPackage("struts-default")
@Namespace("/manage/contacts")
public class ContactsAction extends BaseAction {

    private Customer customer;
    @Action(value = "ContactsAction_findByCustomer")
    public void contactsAction_findByCustomer() throws IOException{
        List<Contacts> list =contactsService.getContactsListByCustomer(customer);
        resultData = ResultData.buildSuccessResult("",list);
        printJSONObject(resultData,"customer","userByCreatoruserid","userByDeleteuserid","businesses","leadses");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
