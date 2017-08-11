package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.MenuVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@ParentPackage("struts-default")
@Namespace("/system")
public class IndexAction extends BaseAction {

    @Action(value = "index", results = {
            @Result(location = "index.jsp")
    })
    public String index() {
        return SUCCESS;
    }

    /**
     * 根据用户查询出菜单
     */
    @Action(value = "menu")
    public void menu() throws IOException {
        User user = (User) getSession().getAttribute("user");
        List<MenuVO> menuList = menuService.getMenu(user);
        resultData = ResultData.buildSuccessResult("获取菜单成功", menuList);
        printJSONObject(resultData);
    }

}
