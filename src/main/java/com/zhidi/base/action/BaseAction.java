package com.zhidi.base.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhidi.manage.service.*;
import com.zhidi.system.service.*;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lx on 2017/7/24.
 */
public class BaseAction extends ActionSupport {

    @Autowired
    protected UserSerivce userSerivce;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected MenuService menuService;
    @Autowired
    protected DepartmentService departmentService;
    @Autowired
    protected FunctionService functionService;
    @Autowired
    protected DictService dictService;
    @Autowired
    protected DictTypeService dictTypeService;
    @Autowired
    protected MessageService messageService;
    @Autowired
    protected PositionService positionService;
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected TaskService taskService;
    @Autowired
    protected BusinessService businessService;
    @Autowired
    protected AnnouncementService announcementService;
    @Autowired
    protected ContractService contractService;
    @Autowired
    protected ProductService productService;
    @Autowired
    protected ContactsService contactsService;

    protected Pager pager;
    protected ResultData resultData;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    /**
     * 获取HttpSession
     * @return
     */
    protected HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 把对象转换为json格式并且输出至客户端
     * @param obj
     * @throws IOException
     */
    protected void printJSONObject(Object obj) throws IOException{
        printJSONObject(obj, new String[]{});
    }

    /**
     * 将对象转换为json格式并且输出至客户端
     * @param obj
     * @param excludeProperties -将会被配置属性
     * @throws IOException
     */
    protected void printJSONObject(Object obj, String... excludeProperties) throws IOException{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();

        JsonConfig config = new JsonConfig();
        config.setExcludes(excludeProperties);

        JSONObject json = JSONObject.fromObject(obj, config);

        out.print(json.toString());
        out.flush();
    }
}
