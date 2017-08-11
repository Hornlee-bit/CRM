package com.zhidi.system.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.FunctionDao;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.service.FunctionService;
import com.zhidi.system.vo.FunctionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-28.
 */
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function,String> implements FunctionService {
    @Autowired
    private FunctionDao functionDao;
    @Autowired
    private void setFunctionDao(FunctionDao functionDao){
        super.setBaseDao(functionDao);
    }
    @Override
    public List<FunctionVO> getAllFunctionVO() {
        List<Function> functionList = functionDao.getAll();
        List<FunctionVO> list = new ArrayList<>();
        for(Function function : functionList){
            FunctionVO functionVO = FunctionVO.fromFunction(function);
            list.add(functionVO);
        }
        return list;
    }

    @Override
    public List<Function> findFunctionsByRoleId(String roleId) {
        Role role = new Role();
        role.setId(roleId);
        return functionDao.getFunctionsByRole(role);
    }

    @Override
    public FunctionVO getFunctionVOById(String id) {
        Function function = functionDao.get(id);
        return FunctionVO.fromFunction(function);
    }
}
