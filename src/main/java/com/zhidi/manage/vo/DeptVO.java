package com.zhidi.manage.vo;


import com.zhidi.manage.entity.Department;
import org.springframework.beans.BeanUtils;

/**
 * Created by Administrator on 2017-07-26.
 */
public class DeptVO {

    private String departmentid;
    private String name;
    private String deptParentId;
    private String parentName;
    private String description;

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(String deptParentId) {
        this.deptParentId = deptParentId;
    }

    public static DeptVO fromDepartment(Department department){
        if(department!=null){
            DeptVO deptVO = new DeptVO();
            BeanUtils.copyProperties(department,deptVO);
            if(department.getDepartment()!=null) {
                deptVO.setParentName(department.getDepartment().getName());
                deptVO.setDeptParentId(department.getDepartment().getDepartmentid());
            }
            return deptVO;
        }
        return null;
    }
}
