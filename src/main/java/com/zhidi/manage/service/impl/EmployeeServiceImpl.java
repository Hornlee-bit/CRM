package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.EmployeeDao;
import com.zhidi.manage.entity.Employee;
import com.zhidi.manage.service.EmployeeService;
import com.zhidi.manage.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,String> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        super.setBaseDao(employeeDao);
    }

    @Override
    public EmployeeVO etitEmployee(String empid) {
        Employee employee = employeeDao.get(empid);
        EmployeeVO empVo = EmployeeVO.parseEmployee(employee);
        return empVo;
    }
}
