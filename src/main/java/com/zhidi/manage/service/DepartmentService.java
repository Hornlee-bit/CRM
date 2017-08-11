package com.zhidi.manage.service;


import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.vo.DeptVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-07-26.
 */

public interface DepartmentService extends BaseService<Department,String>{

    Pager getDeptListByPage(Integer page, Integer rows ,String name,String parentName);

    DeptVO getDeptVOById(String id);
}
