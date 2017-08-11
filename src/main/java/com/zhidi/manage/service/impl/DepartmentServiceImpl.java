package com.zhidi.manage.service.impl;


import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.DepartmentDao;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.service.DepartmentService;
import com.zhidi.manage.vo.DeptVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,String> implements DepartmentService{
    @Resource
    private DepartmentDao departmentDao;

    @Autowired
    private void setDepartmentDao(DepartmentDao departmentDao){
        super.setBaseDao(departmentDao);
    }

    @Override
    public Pager getDeptListByPage(Integer pageNumber, Integer pageSize,String name ,String parentName) {
        if(name==null){
            name="";
        }
        if(parentName==null){
            parentName="";
        }
        List<Department> deptList = departmentDao.getDeptListByPage(pageNumber,pageSize,name,parentName);
        List<DeptVO> userVOList = new ArrayList<>();
        if (deptList != null && !deptList.isEmpty()) {
            for (Department department : deptList) {
                DeptVO deptVO = DeptVO.fromDepartment(department);
                userVOList.add(deptVO);
            }
        }
        //查询数据总数
        Integer totalRows = departmentDao.getSize(name,parentName);
        Pager pager = new Pager();
        pager.setList(userVOList);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public DeptVO getDeptVOById(String id) {
        Department department = departmentDao.get(id);
        DeptVO deptVO = DeptVO.fromDepartment(department);
        return deptVO;
    }
}
