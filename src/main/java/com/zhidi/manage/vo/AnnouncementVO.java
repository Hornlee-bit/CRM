package com.zhidi.manage.vo;


import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.entity.Department;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-01.
 */
public class AnnouncementVO {
    private String announcementid;
    private String departmentid;
    private String departmentname;
    private String userid;
    private String username;
    private Integer orderid;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private String color;
    private Boolean status;
    private Boolean isshow;

    public static Announcement toAnnoucement(AnnouncementVO announcementVO){
        if(announcementVO!=null){
            Announcement announcement = new Announcement();
            BeanUtils.copyProperties(announcementVO,announcement);
            User user = new User();
            user.setId(announcementVO.getUserid());
            Department department = new Department();
            department.setDepartmentid(announcementVO.getDepartmentid());
            announcement.setUser(user);
            announcement.setDepartment(department);
            if(announcement.getCreatetime()!=null){
                announcement.setCreatetime(DateUtil.parseDate(announcementVO.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            }else{
                announcement.setCreatetime(new Date());
            }
            announcement.setUpdatetime(new Date());
            return announcement;
        }
        return null;
    }
    public static AnnouncementVO fromAnnoucement(Announcement announcement){
        if(announcement!=null){
            AnnouncementVO announcementVO = new AnnouncementVO();
            announcementVO.setAnnouncementid(announcement.getAnnouncementid());
            announcementVO.setOrderid(announcement.getOrderid());
            announcementVO.setTitle(announcement.getTitle());
            announcementVO.setContent(announcement.getContent());
            announcementVO.setCreatetime(DateUtil.formatDate(announcement.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            announcementVO.setUpdatetime(DateUtil.formatDate(announcement.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            announcementVO.setColor(announcement.getColor());
            announcementVO.setStatus(announcement.getStatus());
            announcementVO.setIsshow(announcement.getIsshow());
            if(announcement.getUser()!=null){
                announcementVO.setUserid(announcement.getUser().getId());
                announcementVO.setUsername(announcement.getUser().getUsername());
            }
            if(announcement.getDepartment()!=null){
                announcementVO.setDepartmentid(announcement.getDepartment().getDepartmentid());
                announcementVO.setDepartmentname(announcement.getDepartment().getName());
            }
            return announcementVO;
        }
        return null;
    }
    public String getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(String announcementid) {
        this.announcementid = announcementid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsshow() {
        return isshow;
    }

    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }
}
