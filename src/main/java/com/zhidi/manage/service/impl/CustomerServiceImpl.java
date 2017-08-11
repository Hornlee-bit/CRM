package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.CustomerDao;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.service.CustomerService;
import com.zhidi.manage.vo.CustomerVO;
import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer,String> implements CustomerService{
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        super.setBaseDao(customerDao);
    }

    @Override
    public Pager listVoByPage(Pager pager, DetachedCriteria criteria) {
        Pager listPage = customerDao.getListByPage(pager,criteria);
        List<Customer> list = listPage.getList();
        List<CustomerVO> vos = new ArrayList<CustomerVO>();
        for (Customer customer : list){
            CustomerVO vo = CustomerVO.parseVoCustomer(customer);
            vos.add(vo);
        }
        listPage.setList(vos);
        return listPage;
    }

    @Override
    public CustomerVO getByVo(String customerid) {
        Customer customer = customerDao.get(customerid);
        return CustomerVO.parseVoCustomer(customer);
    }
}
