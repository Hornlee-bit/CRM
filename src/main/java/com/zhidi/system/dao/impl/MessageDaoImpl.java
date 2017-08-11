package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.MessageDao;
import com.zhidi.system.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message,String> implements MessageDao {

    @Override
    public List<Message> getRoleListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from Message m left join fetch m.userByTouserid left join fetch m.userByFromuserid";
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }
}
