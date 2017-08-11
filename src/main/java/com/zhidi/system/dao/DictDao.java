package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.DictType;

import java.util.List;

/**
 * Created by Administrator on 2017-07-28.
 */
public interface DictDao extends BaseDao<Dict ,String> {
    List<Dict> getAllDictsByDictTypeId(Integer page,Integer rows,DictType dictType);
    List<Dict> getAllDictsByDictType(String typeCode);
}
