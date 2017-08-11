package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.TaskDao;
import com.zhidi.manage.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */
@Repository
public class TaskDaoImpl extends BaseDaoImpl<Task,String> implements TaskDao {

    @Override
    public List<Task> getTaskListByPage(Integer pageNumber, Integer pageSize) {
        StringBuffer hql = new StringBuffer("from Task t left join fetch t.userByCreatoruserid left join fetch t.userByOwneruserid " +
                "left join fetch t.userByDeleteuserid ");
        return this.getListByPage(pageNumber,pageSize,hql.toString(),new String[]{});
    }

    @Override
    public Integer getSize() {
        StringBuffer hql = new StringBuffer("from Task t left join fetch t.userByCreatoruserid left join fetch t.userByOwneruserid " +
                "left join fetch t.userByDeleteuserid ");
        return this.getSize(hql.toString());
    }
}
