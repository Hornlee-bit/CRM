package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.PositionDao;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.entity.Position;
import com.zhidi.manage.service.PositionService;
import com.zhidi.manage.vo.DeptVO;
import com.zhidi.manage.vo.PositionVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Service
public class PositionServiceImpl extends BaseServiceImpl<Position,String> implements PositionService {
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private void setPositionDao(PositionDao positionDao){
        super.setBaseDao(positionDao);
    }

    @Override
    public Pager getPositionListByPage(Integer pageNumber, Integer pageSize, String positionName) {
        if(positionName==null){
            positionName="";
        }
        List<Position> positionList = positionDao.getPostionListByPage(pageNumber,pageSize,positionName);
        List<PositionVO> positionVOS = new ArrayList<>();
        if (positionList != null && !positionList.isEmpty()) {
            for (Position p: positionList) {
                PositionVO positionVO = PositionVO.fromPosition(p);
                positionVOS.add(positionVO);
            }
        }
        //查询数据总数
        Integer totalRows = positionDao.getHqlSize(positionName);
        Pager pager = new Pager();
        pager.setList(positionVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public PositionVO getPositionVOById(String id) {
        Position position = positionDao.get(id);
        return PositionVO.fromPosition(position);
    }
}
