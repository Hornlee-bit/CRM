package com.zhidi.system.service.impl;


import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.RoleDao;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.RoleService;
import com.zhidi.system.vo.RoleVO;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-27.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,String> implements RoleService {
     @Autowired
     private RoleDao roleDao;

     @Autowired
     public void setRoleDao(RoleDao roleDao){
          super.setBaseDao(roleDao);
     }

     @Override
     public List<Role> findRolesByUserId(String userId) {
          User user = new User();
          user.setId(userId);
          return roleDao.getRoleByUser(user);
     }

     @Override
     public Pager getRoleListByPage(Integer pageNumber, Integer pageSize) {
          List<Role> roleList = roleDao.getRoleListByPage(pageNumber, pageSize);
          List<RoleVO> roleVOList = new ArrayList<>();
          if (roleList != null && !roleList.isEmpty()) {
               for (Role role : roleList) {
                    RoleVO roleVO = RoleVO.fromRole(role);
                    roleVOList.add(roleVO);
               }
          }
          //查询数据总数
          Integer totalRows = roleDao.count();
          Pager pager = new Pager();
          pager.setList(roleVOList);
          pager.setPageNumber(pageNumber);
          pager.setPageSize(pageSize);
          pager.setTotalRows(totalRows);
          pager.setTotalPage(pager.getTotalPage());
          return pager;
     }

     @Override
     public RoleVO getRoleVOById(String id) {
          Role role = roleDao.get(id);
          return RoleVO.fromRole(role);
     }

     @Override
     public void updateRole_Functions(String roleId, String ids) {
          Role role = roleDao.get(roleId);
          role.getFunctions().clear();
          if(ids!=null && ids.length()!=0) {
               String[] idArray = ids.split(",");
               for (String id : idArray) {
                    Function function = new Function();
                    function.setId(id);
                    role.getFunctions().add(function);
               }
          }
     }
}
