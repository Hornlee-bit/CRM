package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.dao.UserDao;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.UserSerivce;
import com.zhidi.system.vo.QueryUserVO;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/7/24.
 */
@ParentPackage("struts-default")
@Namespace("/system/user")
public class UserAction extends BaseAction {

    private User user;
    private Integer rows;
    private Integer page;
    private UserVO userVO;
    private String ids;
    @Action(value = "login")
    public void login() throws IOException {
        //如果user对象为空
        if (user == null) {
            resultData = ResultData.buildFailureResult("用户名或密码为空！");
            printJSONObject(resultData);
            return;
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            resultData = ResultData.buildFailureResult("用户名为空!");
            printJSONObject(resultData);
            return;
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            resultData = ResultData.buildFailureResult("密码为空！");
            printJSONObject(resultData);
            return;
        }
        //如果用户名密码都填写了，就根据用户名查询用户信息
        User user2 = userSerivce.getUserByName(user.getUsername());
        if (user2 == null) {
            resultData = ResultData.buildFailureResult("用户不存在！");
            printJSONObject(resultData);
            return;
        }
        //如果用户存在就比较密码
        if (!user2.getPassword().equals(user.getPassword())) {
            resultData = ResultData.buildFailureResult("密码错误！");
            printJSONObject(resultData);
            return;
        }

        //将用户信息写入session
        getSession().setAttribute("user", user2);

        //留着待续


        //否则返回登录成功信息
        resultData = ResultData.buildSuccessResult("登录成功！");
        printJSONObject(resultData);
    }

    @Action(value = "logout", results = {
            @Result(type = "redirect", location = "/login.jsp")
    })
    public String logout() {
        //清除用户信息
        //getSession().invalidate();
        getSession().setAttribute("user", null);
        return SUCCESS;
    }


    @Action(value = "UserAction_list",results = {
            @Result(location = "list_user.jsp")
    })
    public String list(){
        return SUCCESS;
    }

    /**
     * 用户管理列表
     * @throws IOException
     */
    @Action(value = "UserAction_findByPage")
    public void userAction_findByPage() throws IOException{
        pager = userSerivce.getUserListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData);
    }

    /**
     * 新建用户和修改用户Action
     * @return
     */
    @Action(value = "UserAction_edit",results = {
            @Result(location = "edit_user.jsp")
    })
    public String userAction_edit(){
        if(user!=null){
            userVO = userSerivce.getUserVOById(user.getId());
        }
        return SUCCESS;
    }

    /**
     * 保存和修改用户
     * @throws IOException
     */
    @Action(value = "UserAction_saveOrUpdate")
    public void userAction_save() throws IOException{
        if(userVO.getId().length() !=0){
            user = userSerivce.get(userVO.getId());
            BeanUtils.copyProperties(userVO,user);
            user.setUserByUpdateby((User) getSession().getAttribute("user"));
            user.setUpdatetime(new Date());
            userSerivce.update(user);
            resultData = ResultData.buildSuccessResult();
            printJSONObject(resultData);
            return;
        }
        User user1 = new User();
        BeanUtils.copyProperties(userVO,user1);
        user1.setCreatetime(new Date());
        user1.setUserByCreateby((User) getSession().getAttribute("user"));
        userSerivce.save(user1);
        resultData = ResultData.buildSuccessResult();
        printJSONObject(resultData);
    }

    /**
     * 删除用户Action
     */
    @Action(value = "UserAction_remove")
    public void userAction_remove() throws IOException{
        boolean state = userSerivce.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    /**
     * 为用户分配角色Action
     * @return
     */
    @Action(value = "UserAction_assign",results = {
            @Result(location = "assign_user.jsp")
    })
    public String userAction_assign(){
        return SUCCESS;
    }

    /**
     * 更新用户的角色信息
     */
    @Action(value = "UserAction_updateRoles")
    public void userAction_updateRoles()throws IOException{
        userSerivce.updateUser_Roles(user.getId(),ids);
        resultData = ResultData.buildSuccessResult("更新成功");
        printJSONObject(resultData);
    }
    @Action(value = "UserAction_listUser")
    public void userList()throws IOException{
        List<QueryUserVO> list = userSerivce.getUserList();
        resultData = ResultData.buildSuccessResult("",list);
        printJSONObject(resultData);
    }

    /**
     * getter setter 方法
     * @return
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
