package com.zhidi.system.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.QueryUserVO;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface UserSerivce extends BaseService<User, String> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 获取用户列表
     * @param page
     * @param rows
     * @return
     */
    Pager getUserListByPage(Integer page, Integer rows);

    /**
     * 通过用户id获取临时实体类userVO
     * @param id
     * @return
     */
    UserVO getUserVOById(String id);

    /**
     * 更新用户的角色信息
     * @param userId
     * @param ids
     */
    void updateUser_Roles(String userId,String ids);

    List<QueryUserVO> getUserList();

}
