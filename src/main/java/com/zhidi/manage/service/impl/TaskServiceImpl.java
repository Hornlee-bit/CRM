package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.TaskDao;
import com.zhidi.manage.entity.Task;
import com.zhidi.manage.service.TaskService;
import com.zhidi.manage.vo.TaskVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task,String > implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private void setTaskDao(TaskDao taskDao){
        super.setBaseDao(taskDao);
    }

    @Override
    public Pager getTaskListByPage(Integer pageNumber, Integer pageSize) {
        List<Task> taskList = taskDao.getTaskListByPage(pageNumber,pageSize);
        List<TaskVO> taskVOS = new ArrayList<>();
        if(taskList!=null&&!taskList.isEmpty()){
            for(Task task:taskList){
                 TaskVO taskVO = TaskVO.fromTask(task);
                 taskVOS.add(taskVO);
            }
        }
        Integer totalRows = taskDao.getSize();
        Pager pager = new Pager();
        pager.setList(taskVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }
}
