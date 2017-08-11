package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.CustomerDao;
import com.zhidi.manage.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/8/2.
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer,String> implements CustomerDao {
}
