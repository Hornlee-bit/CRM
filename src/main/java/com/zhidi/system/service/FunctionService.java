package com.zhidi.system.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.system.entity.Function;
import com.zhidi.system.vo.FunctionVO;

import java.util.List;

/**
 * Created by Administrator on 2017-07-28.
 */
public interface FunctionService extends BaseService<Function, String> {

    List<FunctionVO> getAllFunctionVO();
    List<Function> findFunctionsByRoleId(String roleId);
    FunctionVO getFunctionVOById(String id);
}
