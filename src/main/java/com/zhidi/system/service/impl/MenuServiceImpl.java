package com.zhidi.system.service.impl;

import com.zhidi.system.dao.FunctionDao;
import com.zhidi.system.dao.RoleDao;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.MenuService;
import com.zhidi.system.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private FunctionDao functionDao;

    @Override
    public List<MenuVO> getMenu(User user) {
        //根据用户查询出对应的角色
        List<Role> roles = roleDao.getRoleByUser(user);
        //如果用户没有对应的角色就直接返回null
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        //把角色对应的id取出来,放到数组中
        String[] roleIds = new String[roles.size()];
        for (int i=0;i<roles.size();i++) {
            roleIds[i] = roles.get(i).getId();
        }

        //通过角色id查询出对应的权限
        List<Function> functionList = functionDao.getFuncions(1, roleIds);

        //将权限集合转化成对应的MenuVo
        List<MenuVO> menuList = new ArrayList<MenuVO>();
        if (functionList != null && !functionList.isEmpty()) {
            for (Function func : functionList) {
                MenuVO menuVO = new MenuVO();
                menuVO.setId(func.getId());
                menuVO.setName(func.getFuncname());
                menuVO.setUrl(func.getFuncurl());
                if (func.getFunction() != null) {
                    menuVO.setpId(func.getFunction().getId());
                } else {
                    menuVO.setpId(null);
                    menuVO.setOpen(true);
                }
                menuList.add(menuVO);
            }
        }
        return menuList;
    }
}
