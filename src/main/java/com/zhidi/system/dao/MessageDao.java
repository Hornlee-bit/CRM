package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface MessageDao extends BaseDao<Message,String> {

    List<Message> getRoleListByPage(Integer pageNumber , Integer pageSize);
}
