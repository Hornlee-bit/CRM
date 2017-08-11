package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.RoleVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-07-27.
 */
@ParentPackage("struts-default")
@Namespace("/system/role")
public class RoleAction extends BaseAction {

    private Integer page;
    private Integer rows;
    private RoleVO roleVO;
    private String userId;
    private String ids;
    /**
     * 获取所有角色信息
     */
    @Action(value = "RoleAction_findAll")
    public void roleAction_findAll() throws IOException{
        List<Role> list = roleService.getAll();
        resultData = ResultData.buildSuccessResult("获取成功",list);
        printJSONObject(resultData,new String[]{"userByUpdateby","userByCreateby","functions","users"});
    }

    /**
     * 通过用户id获取角色集合
     * @throws IOException
     */
    @Action(value = "RoleAction_findByUserId")
    public void roleAction_findByUserId() throws IOException{
        List<Role> list = roleService.findRolesByUserId(userId);
        resultData = ResultData.buildSuccessResult("成功",list);
        printJSONObject(resultData,new String[]{"userByUpdateby","userByCreateby","functions","users"});
    }

    /**
     * 转到role角色列表页
     * @return
     */
    @Action(value = "RoleAction_list",results = {
            @Result(location = "list_role.jsp")
    })
    public String roleAction_list(){
        return SUCCESS;
    }
    @Action(value = "RoleAction_findByPage")
    public void roleAction_findByPage()throws IOException{
        pager = roleService.getRoleListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("成功",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到role修改和新增页
     * @return
     */
    @Action(value = "RoleAction_edit",results = {
            @Result(location = "edit_role.jsp")
    })
    public String roleAction_edit(){
        if(roleVO!=null){
            roleVO = roleService.getRoleVOById(roleVO.getId());
        }
        return SUCCESS;
    }

    /**
     * 角色role信息新增和保存
     */
    @Action(value = "RoleAction_saveOrUpdate")
    public void roleAction_saveOrUpdate() throws IOException{
        //id不为空字符串时,更新操作
        Role role = new Role();
        if(roleVO.getId().length()!=0){
            role = roleService.get(roleVO.getId());
            BeanUtils.copyProperties(roleVO,role);
            role.setUpdatetime(new Date());
            role.setUserByUpdateby((User) getSession().getAttribute("user"));
            roleService.update(role);
            resultData = ResultData.buildSuccessResult("修改成功");
        }
        //否则是新增操作
        else {
            BeanUtils.copyProperties(roleVO,role);
            role.setCreatetime(new Date());
            role.setUserByCreateby((User) getSession().getAttribute("user"));
            roleService.save(role);
            resultData = ResultData.buildSuccessResult("保存成功");
        }
        printJSONObject(resultData);
    }
    /**
     * 角色role信息删除
     */
    @Action(value = "RoleAction_remove")
    public void roleAction_remove() throws IOException{
        boolean state = roleService.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    /**
     * 转到分配角色页面
     * @return
     */
    @Action(value = "RoleAction_assign",results = {
            @Result(location = "assign_role.jsp")
    })
    public String roleAction_assign(){
        return SUCCESS;
    }

    /**
     * 给角色赋予权限Action
     */
    @Action(value = "RoleAction_updateFunctions")
    public void roleAction_updateFunctions() throws IOException{
        roleService.updateRole_Functions(roleVO.getId(),ids);
        resultData = ResultData.buildSuccessResult("分配权限成功 ");
        printJSONObject(resultData);
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RoleVO getRoleVO() {
        return roleVO;
    }

    public void setRoleVO(RoleVO roleVO) {
        this.roleVO = roleVO;
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
