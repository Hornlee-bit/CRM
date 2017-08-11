package com.zhidi.system.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.MessageDao;
import com.zhidi.system.entity.Message;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.MessageService;
import com.zhidi.system.vo.MessageVO;
import com.zhidi.system.vo.RoleVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message,String> implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private void setMessageDao(MessageDao messageDao){
        super.setBaseDao(messageDao);
    }

    @Override
    public Pager getMessageListByPage(Integer pageNumber, Integer pageSize) {
        List<Message> messageList = messageDao.getRoleListByPage(pageNumber, pageSize);
        List<MessageVO> messageVOS = new ArrayList<>();
        if (messageList != null && !messageList.isEmpty()) {
            for (Message message : messageList) {
                MessageVO messageVO = MessageVO.fromMessage(message);
                messageVOS.add(messageVO);
            }
        }
        //查询数据总数
        Integer totalRows = messageDao.count();
        Pager pager = new Pager();
        pager.setList(messageVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public void saveMessageVO(MessageVO messageVO) {
        Message message = new Message();
        message.setContent(messageVO.getContent());
        message.setSendtime(new Date());
        User touser = new User();
        User fromuser = new User();
        touser.setId(messageVO.getUserByTouserId());
        fromuser.setId(messageVO.getUserByFromuserId());
        message.setUserByFromuserid(fromuser);
        message.setUserByTouserid(touser);
        message.setStatus(true);
        messageDao.save(message);
    }
}
