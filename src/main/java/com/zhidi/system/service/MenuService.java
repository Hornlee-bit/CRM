package com.zhidi.system.service;

import com.zhidi.system.entity.User;
import com.zhidi.system.vo.MenuVO;

import java.util.List;

/**
 * 菜单Service
 * Created by lx on 2017/7/24.
 */
public interface MenuService {

    /**
     * 查询出用户菜单
     * @param user
     * @return
     */
    List<MenuVO> getMenu(User user);
}
