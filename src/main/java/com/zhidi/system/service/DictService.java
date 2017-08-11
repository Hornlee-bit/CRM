package com.zhidi.system.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.DictType;
import com.zhidi.system.vo.DictVO;
import com.zhidi.util.Pager;

import java.util.List;


/**
 * Created by Administrator on 2017-07-28.
 */
public interface DictService extends BaseService<Dict,String> {

    Pager findAllDictsByDictTypeId(Integer page, Integer rows, DictType dictType);

    DictVO getDictVOById(String id);

    List<DictVO> getDictVOByDictType(String typeCode);
}
