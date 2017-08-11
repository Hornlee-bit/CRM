package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.DepartmentDao;
import com.zhidi.manage.entity.Department;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department,String> implements DepartmentDao{

    @Override
    public List<Department> getDeptListByPage(Integer pageNumber, Integer pageSize,String name,String parentName) {

        if("".equals(parentName)){
            String hql = "from Department d where d.name like '%"+name+"%'";
            return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
        }
        String hql = "from Department d where d.name like '%"+name+"%' and d.department.name like '%"+parentName+"%'";
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }

    @Override
    public Integer getSize(String name, String parentName) {
        String hql;
        if("".equals(parentName)){
            hql = "from Department d where d.name like '%"+name+"%'";
        }else {
            hql = "from Department d where d.name like '%" + name + "%' and d.department.name like '%" + parentName + "%'";
        }
        return  this.getSize(hql);
    }
}