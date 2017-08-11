package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Employee;
import com.zhidi.manage.vo.EmployeeVO;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface EmployeeService extends BaseService<Employee,String> {

    EmployeeVO etitEmployee(String empid);
}
