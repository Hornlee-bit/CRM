package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.entity.Position;
import com.zhidi.manage.vo.DeptVO;
import com.zhidi.manage.vo.PositionVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;


/**
 * Created by Administrator on 2017-07-26.
 */
@ParentPackage("struts-default")
@Namespace("/manage/position")
public class PositionAction extends BaseAction {

    private Integer page;
    private Integer rows;
    private DeptVO deptVO;
    private List<Department> list;
    private List<Position> pl;
    private String ids;
    private PositionVO positionVO;
    //检索条件
    private String name;
    private String parentName;
    private String positionName;
    @Action(value = "DepartmentAction_list",results = {
            @Result(location = "list_dept.jsp")
    })
    public String list(){
        return SUCCESS;
    }
    /**
     * 获取部门列表分页查询
     * @return
     */
    @Action(value = "DepartmentAction_findByPage")
    public void departmentAction_findByPage() throws IOException{
        pager = departmentService.getDeptListByPage(page,rows,name,parentName);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData);
    }
    /**
     * 新建部门 修改部门信息 Action
     * @return
     */

    @Action(value = "DepartmentAction_edit",results = {
            @Result(location = "edit_dept.jsp")
    })
    public String departmentAction_edit() {
        //修改
        if(deptVO!=null){
            deptVO = departmentService.getDeptVOById(deptVO.getDepartmentid());
        }
        //新建
        list = departmentService.getAll();
        return SUCCESS;
    }

    /**
     * 保存修改和新建部门信息Action
     * @throws IOException
     */
    @Action(value = "DepartmentAction_saveOrUpdate")
    public void departmentAction_saveOrUpdate() throws IOException{
        //修改
        Department department = new Department();
        if(deptVO.getDepartmentid().length()>0){
            BeanUtils.copyProperties(deptVO,department);
            department.setDepartment(departmentService.get(deptVO.getDeptParentId()));
            departmentService.saveOrUpdate(department);
            resultData = ResultData.buildSuccessResult("修改成功");
            printJSONObject(resultData);
            return;
        }
        BeanUtils.copyProperties(deptVO,department);
        department.setDepartment(departmentService.get(deptVO.getDeptParentId()));
        departmentService.save(department);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }

    @Action("DepartmentAction_delete")
    public void DepartmentAction_delete() throws IOException{
        boolean state = departmentService.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    /**
     * 跳转到岗位管理页面
     * @return
     */
    @Action(value = "PositionAction_list" ,results = {
            @Result(location = "list_position.jsp")
    })
    public String positionAction_list(){
        return SUCCESS;
    }

    /**
     * 分页查询岗位
     * @return
     */
    @Action(value = "PositionAction_findByCondition")
    public void positionAction_findByCondition() throws IOException{
        pager = positionService.getPositionListByPage(page,rows,positionName);
        resultData = ResultData.buildSuccessResult("success",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到新增和修改岗位信息页面
     * @return
     */
    @Action(value = "PositionAction_edit",results = {
            @Result(location = "edit_position.jsp")
    })
    public String positionAction_edit(){
        if(positionVO!=null){
            positionVO = positionService.getPositionVOById(positionVO.getPositionid());
        }
        list = departmentService.getAll();
        pl = positionService.getAll();
        return SUCCESS;
    }

    /**
     * 新增和修改岗位信息
     */
    @Action(value = "PositionAction_saveOrUpdate")
    public void positionAction_saveOrUpdate() throws IOException{
        //修改
        Position position = new Position();
        if(positionVO.getPositionid().length()>0){
            BeanUtils.copyProperties(positionVO,position);
            //添加上级部门
            Department department = new Department();
            department.setDepartmentid(positionVO.getDepartmentParentId());
            position.setDepartment(department);
            //添加上级岗位
            Position position1 = new Position();
            position1.setPositionid(positionVO.getPositionParentId());
            position.setPosition(position1);

            positionService.update(position);
            resultData = ResultData.buildSuccessResult("修改成功");
            printJSONObject(resultData);
            return;
        }
        BeanUtils.copyProperties(positionVO,position);
        //添加上级部门
        Department department = new Department();
        department.setDepartmentid(positionVO.getDepartmentParentId());
        position.setDepartment(department);
        //添加上级岗位
        Position position1 = new Position();
        position1.setPositionid(positionVO.getPositionParentId());
        position.setPosition(position1);

        positionService.save(position);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }
    /**
     * 删除岗位
     */
    @Action(value = "PositionAction_delete")
    public void positionAction_delete() throws IOException{
        boolean state = positionService.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

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

    public DeptVO getDeptVO() {
        return deptVO;
    }

    public void setDeptVO(DeptVO deptVO) {
        this.deptVO = deptVO;
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

    public void setList(List<Department> list) {
        this.list = list;
    }

    public List<Department> getList() {
        return list;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public PositionVO getPositionVO() {
        return positionVO;
    }

    public void setPositionVO(PositionVO positionVO) {
        this.positionVO = positionVO;
    }

    public List<Position> getPl() {
        return pl;
    }

    public void setPl(List<Position> pl) {
        this.pl = pl;
    }
}
