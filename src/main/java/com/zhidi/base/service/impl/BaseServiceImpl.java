package com.zhidi.base.service.impl;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.base.service.BaseService;
import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/7/13.
 */
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    private BaseDao<T, PK> baseDao;

    public void setBaseDao(BaseDao<T, PK> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T get(PK id) {
        return baseDao.get(id);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public void delete(PK id) {
        baseDao.delete(id);
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    /**
     * 无参的分页查询
     *
     * @param pager
     * @return
     */
    @Override
    public Pager getListByPage(Pager pager) {
        return baseDao.getListByPage(pager);
    }

    @Override
    public Pager getListByPager(Pager pager, DetachedCriteria detachedCriteria) {
        return baseDao.getListByPage(pager, detachedCriteria);
    }

    @Override
    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public boolean deleteByIds(String ids) {
        boolean state;
        String[] idArray = ids.split(",");
        try{
            for(String id:idArray){
                baseDao.delete((PK)id);
            }
            state = true;
        }catch (Exception e){
            state = false;
        }
        return state;
    }

}
