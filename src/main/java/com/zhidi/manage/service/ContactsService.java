package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
public interface ContactsService extends BaseService<Contacts,String> {

    List<Contacts> getContactsListByCustomer(Customer customer);
}
