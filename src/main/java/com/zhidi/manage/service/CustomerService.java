package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.vo.CustomerVO;
import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface CustomerService extends BaseService<Customer,String> {
    /**
     * 分页查询
     * @param pager
     * @param criteria
     * @return
     */
    Pager listVoByPage(Pager pager, DetachedCriteria criteria);

    /**
     * 把实体转化为Vo类
     * @param customerid
     * @return
     */
    CustomerVO getByVo(String customerid);
}
