package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
public interface ContactsDao extends BaseDao<Contacts , String> {
    List<Contacts> getContactsListByCustomer(Customer customer);
}
