package com.zhidi.base.service;

import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/7/13.
 */
public interface BaseService<T, PK extends Serializable> {

    T get(PK id);

    List<T> getAll();

    void delete(PK id);

    void save(T entity);

    void update(T entity);

    Pager getListByPager(Pager pager, DetachedCriteria detachedCriteria);

    /**
     * 无参的分页查询
     * @param pager
     * @return
     */
    Pager getListByPage(Pager pager);

    void saveOrUpdate(T entity);

    boolean deleteByIds(String ids);

}
