package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.ContractDao;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.service.ContractService;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.manage.vo.DeptVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017-08-03.
 */
@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract,String> implements ContractService {
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private void setContractDao(ContractDao contractDao){
        super.setBaseDao(contractDao);
    }

    @Override
    public Pager getContractByPage(Integer pageNumber, Integer pageSize,String conditionOne ,String conditionTwo,String contractCondition) {
        List<Contract> contractList = contractDao.getContractByPage(pageNumber,pageSize, conditionOne ,conditionTwo, contractCondition);
        List<ContractVO> contractVOS = new ArrayList<>();
        if (contractList != null && !contractList.isEmpty()) {
            for (Contract contract : contractList) {
                ContractVO contractVO = ContractVO.fromContract(contract);
                contractVOS.add(contractVO);
            }
        }
        //查询数据总数
        Integer totalRows = contractDao.getSize(conditionOne,conditionTwo,contractCondition);
        Pager pager = new Pager();
        pager.setList(contractVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public List<ContractVO> getAllContract() {
        List<Contract> contractList = contractDao.getAll();
        List<ContractVO> list = new ArrayList<>();
        if(contractList!=null&&!contractList.isEmpty()){
            for(Contract contract:contractList){
                ContractVO contractVO = ContractVO.fromContract(contract);
                list.add(contractVO);
            }
            return list;
        }
        return null;
    }

    @Override
    public ContractVO getContractVOById(String id) {
        Contract contract = contractDao.get(id);
        return ContractVO.fromContract(contract);
    }
}
