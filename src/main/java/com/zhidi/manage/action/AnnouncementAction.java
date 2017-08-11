package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.vo.AnnouncementVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@ParentPackage("struts-default")
@Namespace("/manage/announcement")
public class AnnouncementAction extends BaseAction{

    private List<Department> list;
    private Integer page;
    private Integer rows;
    private String ids;
    private AnnouncementVO announcementVO;
    @Action(value = "AnnouncementAction_list",results = {
            @Result(location = "list_announcement.jsp")
    })
    public String announcementAction_list(){
        return SUCCESS;
    }

    /**
     * 分页查询公告信息
     */
    @Action(value = "AnnouncementAction_findByPage")
    public void announcementAction_findByPage() throws IOException{
         pager = announcementService.getAnnouncementListByPage(page,rows,announcementVO);
         resultData = ResultData.buildSuccessResult("成功",pager);
         printJSONObject(resultData);
    }

    /**
     * 转到修改和新增页面
     * @return
     */
    @Action(value = "AnnouncementAction_edit",results = {
            @Result(location = "edit_announcement.jsp")
    })
    public String announcementAction_edit(){
        list = departmentService.getAll();
        //修改
        if(announcementVO!=null){
            announcementVO = announcementService.getAnnouncementById(announcementVO.getAnnouncementid());
        }
        return SUCCESS;
    }

    @Action(value = "AnnouncementAction_saveOrUpdate")
    public void announcementAction_saveOrUpdate() throws IOException{
        Announcement announcement = AnnouncementVO.toAnnoucement(announcementVO);
        if(announcement.getAnnouncementid().length()==0) {
            announcement.setUser((User)getSession().getAttribute("user"));
            announcementService.save(announcement);
            resultData = ResultData.buildSuccessResult("保存成功");
        }else {
            announcementService.update(announcement);
            resultData = ResultData.buildSuccessResult("修改成功");
        }
        printJSONObject(resultData);
    }
    /**
     * 删除公告信息
     */
    @Action(value = "AnnouncementAction_remove")
    public void announcementAction_remove() throws IOException{
        boolean state = announcementService.deleteByIds(ids);
        if(state){
            resultData = ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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

    public AnnouncementVO getAnnouncementVO() {
        return announcementVO;
    }

    public void setAnnouncementVO(AnnouncementVO announcementVO) {
        this.announcementVO = announcementVO;
    }

    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
    }
}
