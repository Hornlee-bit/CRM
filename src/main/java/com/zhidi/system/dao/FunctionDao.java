package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface FunctionDao extends BaseDao<Function, String> {

    /**
     * 根据权限类型和角色id查询权限
     * @param funcType
     * @param ids
     * @return
     */
    List<Function> getFuncions(Integer funcType, String... ids);

    List<Function> getFunctionsByRole(Role role);
}
