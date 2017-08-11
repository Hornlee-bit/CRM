package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.FunctionDao;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function, String> implements FunctionDao {

    @Override
    public List<Function> getFuncions(Integer funcType, String... ids) {
        String hql = "from Function f inner join fetch f.roles r " +
                "where f.status=1 and f.functype=:funcType and r.id in (:ids) order by f.sortnum";
        Query query = getSession().createQuery(hql);
        query.setParameter("funcType", funcType);
        query.setParameterList("ids", ids);
        return query.list();
    }

    @Override
    public List<Function> getFunctionsByRole(Role role) {
        String hql = "from Function f inner join fetch f.roles r where r.id=:roleId";
        Query query = getSession().createQuery(hql);
        query.setParameter("roleId", role.getId());
        return query.list();
    }
}
