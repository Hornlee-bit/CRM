package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Task;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-08-07.
 */
public interface TaskService extends BaseService<Task,String> {

    Pager getTaskListByPage(Integer pageNumber , Integer pageSize);
}
