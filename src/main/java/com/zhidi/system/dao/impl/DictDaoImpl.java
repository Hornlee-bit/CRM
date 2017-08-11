package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.DictDao;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.DictType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-07-28.
 */
@Repository
public class DictDaoImpl extends BaseDaoImpl<Dict ,String> implements DictDao {

    @Override
    public List<Dict> getAllDictsByDictTypeId(Integer page,Integer rows,DictType dictType) {
        String hql = null;
        if("allType".equals(dictType.getTypecode())){
            hql = "from Dict d inner join fetch d.dictType";
        }
        else {
            hql = "from Dict d left join fetch d.dictType dt where dt.typecode ='"+dictType.getTypecode()+"'";
        }

        return this.getListByPage(page,rows,hql,new String[]{});
    }

    @Override
    public List<Dict> getAllDictsByDictType(String typeCode) {
        String hql = "from Dict d left join fetch d.dictType dt where dt.typecode ='"+typeCode+"'";
        return getSession().createQuery(hql).list();
    }
}
