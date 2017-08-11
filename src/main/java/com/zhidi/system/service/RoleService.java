package com.zhidi.system.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.system.entity.Role;
import com.zhidi.system.vo.RoleVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017-07-27.
 */
public interface RoleService extends BaseService<Role, String>{

    List<Role> findRolesByUserId(String userId);

    Pager getRoleListByPage(Integer pageNumber ,Integer pageSize);

    RoleVO getRoleVOById(String id);

    void updateRole_Functions(String roleId,String ids);
}
