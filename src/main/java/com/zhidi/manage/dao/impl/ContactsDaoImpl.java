package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.ContactsDao;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
@Repository
public class ContactsDaoImpl extends BaseDaoImpl<Contacts,String> implements ContactsDao {

    @Override
    public List<Contacts> getContactsListByCustomer(Customer customer) {
        String hql = "from Contacts c left join fetch c.customer cc where cc.customerid='"+customer.getCustomerid()+"'";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
