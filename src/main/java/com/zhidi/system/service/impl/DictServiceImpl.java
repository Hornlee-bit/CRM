package com.zhidi.system.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.DictDao;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.DictType;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.DictService;
import com.zhidi.system.vo.DictVO;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-28.
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict , String> implements DictService {
    @Autowired
    private DictDao dictDao;
    @Autowired
    private void setDictDao(DictDao dictDao){
        super.setBaseDao(dictDao);
    }

    @Override
    public Pager findAllDictsByDictTypeId(Integer page, Integer rows, DictType dictType) {

        List<Dict> dictList = dictDao.getAllDictsByDictTypeId(page,rows,dictType);
        List<DictVO> dictVOS = new ArrayList<>();
        if (dictList != null && !dictList.isEmpty()) {
            for (Dict dict : dictList) {
                DictVO dictVO = DictVO.fromDict(dict);
                dictVOS.add(dictVO);
            }
        }
        //查询数据总数
        Integer totalRows = dictDao.count();
        Pager pager = new Pager();
        pager.setList(dictVOS);
        if(page!=null&&rows!=null) {
            pager.setPageNumber(page);
            pager.setPageSize(rows);
            pager.setTotalRows(totalRows);
            pager.setTotalPage(pager.getTotalPage());
        }
        return pager;
    }

    @Override
    public DictVO getDictVOById(String id) {
        Dict dict = dictDao.get(id);
        return DictVO.fromDict(dict);
    }

    @Override
    public List<DictVO> getDictVOByDictType(String typeCode) {
        List<Dict> list =  dictDao.getAllDictsByDictType(typeCode);
        List<DictVO> dictVOS = new ArrayList<>();
        if(list!=null&&!list.isEmpty()){
            for(Dict dict:list){
                DictVO dictVO = DictVO.fromDict(dict);
                dictVOS.add(dictVO);
            }
            return dictVOS;
        }
        return null;
    }
}
