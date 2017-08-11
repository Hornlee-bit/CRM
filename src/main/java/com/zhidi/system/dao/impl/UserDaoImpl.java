package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.UserDao;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

    @Override
    public User getUserByName(String username) {
        Query query = getSession().createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getUserListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from User u left join fetch u.roles left join fetch u.userByUpdateby left join fetch u.userByCreateby order by u.sortnum";
        return this.getListByPage(pageNumber, pageSize, hql, new String[] {});
    }
}
