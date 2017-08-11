package com.zhidi.system.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.UserDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.UserSerivce;
import com.zhidi.system.vo.QueryUserVO;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/7/24.
 */
@Service
public class UserSerivceImp extends BaseServiceImpl<User, String> implements UserSerivce {

    @Autowired
    private UserDao userDao;

    private Pager pager = new Pager();
    @Autowired
    private void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public Pager getUserListByPage(Integer pageNumber, Integer pageSize) {
        //查询用户列表
        List<User> userList = userDao.getUserListByPage(pageNumber, pageSize);
        List<UserVO> userVOList = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                UserVO userVO = UserVO.fromUser(user);
                userVOList.add(userVO);
            }
        }
        //查询数据总数
        Integer totalRows = userDao.count();
        Pager pager = new Pager();
        pager.setList(userVOList);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public UserVO getUserVOById(String id) {
        User user = userDao.get(id);
        return UserVO.fromUser(user);
    }

    @Override
    public void updateUser_Roles(String userId, String ids) {
        User user = userDao.get(userId);
        user.getRoles().clear();
        if(ids!=null && ids.length()!=0) {
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                Role role = new Role();
                role.setId(id);
                user.getRoles().add(role);
            }
        }
    }

    @Override
    public List<QueryUserVO> getUserList() {
        List<User> userList = userDao.getAll();
        List<QueryUserVO> list = new ArrayList<>();
        if(userList!=null && !userList.isEmpty()){
            for(User user:userList){
                QueryUserVO queryUserVO = QueryUserVO.fromUser(user);
                list.add(queryUserVO);
            }
            return list;
        }
        return null;
    }
}
