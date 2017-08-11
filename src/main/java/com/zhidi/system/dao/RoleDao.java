package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface RoleDao extends BaseDao<Role, String> {

    List<Role> getRoleByUser(User user);

    List<Role> getRoleListByPage(Integer pageNumber, Integer pageSize);


}
