package com.zhidi.system.service.impl;


import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.DictTypeDao;
import com.zhidi.system.entity.DictType;
import com.zhidi.system.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-07-31.
 */
@Service
public class DictTypeServiceImpl extends BaseServiceImpl<DictType,String> implements DictTypeService {

    @Autowired
    private DictTypeDao dictTypeDao;

    @Autowired
    private void setDictTypeService(DictTypeDao dictTypeDao){
        super.setBaseDao(dictTypeDao);
    }
}
