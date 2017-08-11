package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Task;

import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */
public interface TaskDao extends BaseDao<Task,String> {
    List<Task> getTaskListByPage(Integer pageNumber , Integer pageSize);
    Integer getSize();
}
