package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Employee;
import com.zhidi.manage.vo.EmployeeVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/31.
 */
@ParentPackage("struts-default")
@Namespace("/manage/employee")
public class EmployeeAction extends BaseAction{
    private String name;
    private Employee emp;
    private EmployeeVO empVo;
    private String ids;

    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    //    删除
    @Action(value = "remove")
    public void remove() throws IOException {
        boolean state = employeeService.deleteByIds(ids);
        if(state) {
            resultData = ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

//    更新保存
    @Action(value = "upDateOrSave")
    public void upDateOrSave() throws IOException {
        HttpSession httpSession = getSession();
        User user = (User) httpSession.getAttribute("user");
//        添加
        if(StringUtils.isEmpty(emp.getEmpid())){
            emp.setEmpid(null);
            emp.setCreateby(user.getUsername());
            emp.setCreatetime(new Date());
//            emp.setUser(user);
        }
        emp.setUpdateby(user.getUsername());
        emp.setUpdatetime(new Date());
        employeeService.saveOrUpdate(emp);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }

//    跳转到修改页面
    @Action(value = "edit",results = {
            @Result(location = "edit_employee.jsp")
    })
    public String edit(){
        empVo = employeeService.etitEmployee(emp.getEmpid());
        return SUCCESS;
    }
//    跳转到添加页面
    @Action(value = "add",results = {
            @Result(location = "add_employee.jsp")
    })
    public String add(){
        return SUCCESS;
    }

//    跳转到分页页面
    @Action(value = "EmployeeAction_list",results = {
            @Result(location = "list_employee.jsp")
    })
    public String toListPage(){
        return SUCCESS;
    }

//    获取分页查询数据
    @Action(value = "listByPage")
    public void listByPage() throws IOException {
        if (pager == null){
            pager = new Pager();
            pager.setPageSize(rows);
            pager.setPageNumber(page);
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        if (StringUtils.isNotEmpty(name)){
            criteria.add(Restrictions.like("name","%"+name+"%"));
        }
        Pager listByPager = employeeService.getListByPager(pager,criteria);
        resultData = ResultData.buildSuccessResult("获取成功",listByPager);
        printJSONObject(resultData,new String[]{"position","user"});
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public EmployeeVO getEmpVo() {
        return empVo;
    }

    public void setEmpVo(EmployeeVO empVo) {
        this.empVo = empVo;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
