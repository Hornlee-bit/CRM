package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Position;
import com.zhidi.manage.vo.PositionVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface PositionService extends BaseService<Position,String> {

    Pager getPositionListByPage(Integer pageNumber ,Integer pageSize ,String positionName);
    PositionVO getPositionVOById(String id);
}
