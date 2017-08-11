package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Contract;

import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
public interface ContractDao extends BaseDao<Contract ,String>{

    List<Contract> getContractByPage(Integer pageNumber,Integer pageSize,String conditionOne ,String conditionTwo,String contractCondition);
    Integer getSize(String conditionOne ,String conditionTwo,String contractCondition);
}
