package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
public interface ContractService extends BaseService<Contract,String>  {
    Pager getContractByPage(Integer pageNumber,Integer pageSize,String conditionOne ,String conditionTwo,String contractCondition);
    List<ContractVO> getAllContract();
    ContractVO getContractVOById(String id);
}
