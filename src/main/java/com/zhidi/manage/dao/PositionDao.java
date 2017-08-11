package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Position;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface PositionDao extends BaseDao<Position ,String > {

    List<Position> getPostionListByPage(Integer pageNumber, Integer pageSize, String positionName);
    Integer getHqlSize(String positionName);
}
