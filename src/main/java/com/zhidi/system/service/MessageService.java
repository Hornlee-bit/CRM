package com.zhidi.system.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.system.entity.Message;
import com.zhidi.system.vo.MessageVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface MessageService extends BaseService<Message,String> {

    Pager getMessageListByPage(Integer pageNumber ,Integer pageSize);

    void saveMessageVO(MessageVO messageVO);
}
