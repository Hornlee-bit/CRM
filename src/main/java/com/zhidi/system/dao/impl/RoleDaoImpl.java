package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.RoleDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, String> implements RoleDao {

    @Override
    public List<Role> getRoleByUser(User user) {
        String hql = "from Role r inner join fetch r.users u where u.id=:userId";
        Query query = getSession().createQuery(hql);
        query.setParameter("userId", user.getId());
        return query.list();
    }

    @Override
    public List<Role> getRoleListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from Role r left join fetch r.functions left join fetch r.userByUpdateby left join fetch r.userByCreateby order by r.sortnum";
        return this.getListByPage(pageNumber, pageSize, hql, new String[] {});
    }
}
