package com.zhidi.system.vo;

import com.zhidi.system.entity.Message;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-01.
 */
public class MessageVO {
    private String messageid;
    private String userByTouserId;//收件人id
    private String userByTousername;//收件人姓名
    private String userByFromuserId;
    private String userByFromusername;//发件人姓名
    private String content;
    private String readtime;
    private String sendtime;
    private Boolean status;

    public static MessageVO fromMessage(Message message){
        if(message!=null){
            MessageVO messageVO = new MessageVO();
            messageVO.setMessageid(message.getMessageid());
            messageVO.setContent(message.getContent());
            messageVO.setReadtime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            messageVO.setSendtime(DateUtil.formatDate(message.getSendtime(),"yyyy-MM-dd HH:mm:ss"));
            messageVO.setStatus(message.getStatus());
            if(message.getUserByTouserid()!=null){
                messageVO.setUserByTousername(message.getUserByTouserid().getUsername());
                messageVO.setUserByTouserId(message.getUserByTouserid().getId());
            }
            if(message.getUserByFromuserid()!=null){
                messageVO.setUserByFromusername(message.getUserByFromuserid().getUsername());
                messageVO.setUserByFromuserId(message.getUserByFromuserid().getId());
            }
            return messageVO;
        }
        return null;
    }
    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getUserByTousername() {
        return userByTousername;
    }

    public void setUserByTousername(String userByTousername) {
        this.userByTousername = userByTousername;
    }

    public String getUserByFromusername() {
        return userByFromusername;
    }

    public void setUserByFromusername(String userByFromusername) {
        this.userByFromusername = userByFromusername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReadtime() {
        return readtime;
    }

    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUserByTouserId() {
        return userByTouserId;
    }

    public void setUserByTouserId(String userByTouserId) {
        this.userByTouserId = userByTouserId;
    }

    public String getUserByFromuserId() {
        return userByFromuserId;
    }

    public void setUserByFromuserId(String userByFromuserId) {
        this.userByFromuserId = userByFromuserId;
    }
}
