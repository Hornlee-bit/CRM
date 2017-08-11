package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Department;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
public interface DepartmentDao extends BaseDao<Department,String> {

    List<Department> getDeptListByPage(Integer pageNumber, Integer pageSize,String name,String parentName);
    Integer getSize(String name,String parentName);
}
