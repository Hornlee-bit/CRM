package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.PositionDao;
import com.zhidi.manage.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position,String> implements PositionDao {

    @Override
    public List<Position> getPostionListByPage(Integer pageNumber, Integer pageSize, String positionName) {
        String hql = "from Position d left join fetch d.department left join fetch d.position where d.name like '%"+positionName+"%'";
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }

    @Override
    public Integer getHqlSize(String positionName) {
        String hql = "from Position d left join fetch d.department left join fetch d.position where d.name like '%"+positionName+"%'";
        return this.getSize(hql);
    }
}
