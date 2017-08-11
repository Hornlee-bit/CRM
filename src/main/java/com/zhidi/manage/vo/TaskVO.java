package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Task;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-07.
 */
public class TaskVO {
    private String taskid;
    private String creatorUsername;
    private String creatorUserid;
    private String ownerUserid;
    private String ownerUsername;
    private String deleteUserid;
    private String deleteUsername;
    private String aboutUser;
    private String subject;
    private String duedate;
    private String status;
    private String priority;
    private String sendemail;
    private String description;
    //private byte[] description;
    private String createdate;
    private String updtadate;
    private Boolean isclose;
    private Boolean isdeleted;
    private String deletetime;

    public static TaskVO fromTask(Task task){
        if(task!=null){
            TaskVO taskVO = new TaskVO();
            BeanUtils.copyProperties(task,taskVO);
            if(task.getUserByCreatoruserid()!=null){
                taskVO.setCreatorUserid(task.getUserByCreatoruserid().getId());
                taskVO.setCreatorUsername(task.getUserByCreatoruserid().getUsername());
            }
            if(task.getUserByOwneruserid()!=null){
                taskVO.setOwnerUserid(task.getUserByOwneruserid().getId());
                taskVO.setOwnerUsername(task.getUserByOwneruserid().getUsername());
            }
            if(task.getUserByDeleteuserid()!=null){
                taskVO.setDeleteUserid(task.getUserByDeleteuserid().getId());
                taskVO.setDeleteUsername(task.getUserByDeleteuserid().getUsername());
            }
            taskVO.setCreatedate(DateUtil.formatDate(task.getCreatedate(),"yyyy-MM-dd HH:mm:ss"));
            taskVO.setUpdtadate(DateUtil.formatDate(task.getUpdtadate(),"yyyy-MM-dd HH:mm:ss"));
            taskVO.setDeletetime(DateUtil.formatDate(task.getDeletetime(),"yyyy-MM-dd HH:mm:ss"));
            taskVO.setDuedate(DateUtil.formatDate(task.getDuedate(),"yyyy-MM-dd HH:mm:ss"));
            if(task.getDescription()!=null) {
                taskVO.setDescription(new String(task.getDescription()));
            }
            return taskVO;
        }
        return null;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public String getCreatorUserid() {
        return creatorUserid;
    }

    public void setCreatorUserid(String creatorUserid) {
        this.creatorUserid = creatorUserid;
    }

    public String getOwnerUserid() {
        return ownerUserid;
    }

    public void setOwnerUserid(String ownerUserid) {
        this.ownerUserid = ownerUserid;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getDeleteUserid() {
        return deleteUserid;
    }

    public void setDeleteUserid(String deleteUserid) {
        this.deleteUserid = deleteUserid;
    }

    public String getDeleteUsername() {
        return deleteUsername;
    }

    public void setDeleteUsername(String deleteUsername) {
        this.deleteUsername = deleteUsername;
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSendemail() {
        return sendemail;
    }

    public void setSendemail(String sendemail) {
        this.sendemail = sendemail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdtadate() {
        return updtadate;
    }

    public void setUpdtadate(String updtadate) {
        this.updtadate = updtadate;
    }

    public Boolean getIsclose() {
        return isclose;
    }

    public void setIsclose(Boolean isclose) {
        this.isclose = isclose;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }
}
