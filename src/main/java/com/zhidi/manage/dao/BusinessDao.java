package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Business;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
public interface BusinessDao extends BaseDao<Business,String>{
    List<Business> getBusinessListByPage(Integer pageNumber,Integer pageSize,String condition,String searchText);
    Integer getSize(String condition ,String searchText);
}
