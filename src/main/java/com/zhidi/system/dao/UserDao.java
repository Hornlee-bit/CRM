package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface UserDao extends BaseDao<User, String> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    List<User> getUserListByPage(Integer pageNumber, Integer pageSize);
}
