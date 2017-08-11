package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.EmployeeDao;
import com.zhidi.manage.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee,String> implements EmployeeDao{
}
