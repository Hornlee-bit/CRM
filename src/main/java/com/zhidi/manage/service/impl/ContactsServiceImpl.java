package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.ContactsDao;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
@Service
public class ContactsServiceImpl extends BaseServiceImpl<Contacts,String> implements ContactsService {
    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private void setContactsDao(ContactsDao contactsDao){
        super.setBaseDao(contactsDao);
    }

    @Override
    public List<Contacts> getContactsListByCustomer(Customer customer) {
        return contactsDao.getContactsListByCustomer(customer);
    }
}
