package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
public interface BusinessService extends BaseService<Business,String> {
    Pager getBusinessByPage(Integer pageNumber,Integer pageSize,String condition,String searchText);
    List<BusinessVO> getAllBusiness();
}
