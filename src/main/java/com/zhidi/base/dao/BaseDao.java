package com.zhidi.base.dao;

import com.zhidi.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * 基础dao接口
 * Created by lx on 2017/7/14.
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * 根据主键进行查询
     * @param id
     * @return
     */
    public T get(PK id);

    /**
     * 查询所有
     * @return
     */
    public List<T> getAll();

    /**
     * 保存
     * @param entity
     */
    public void save(T entity);

    /**
     * 根据主键删除
     * @param id
     */
    public void delete(PK id);

    /**
     * 修改
     * @param entity
     */
    public void update(T entity);

    /**
     * 分页查询
     * @param pager
     * @return
     */
    Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria);

    /**
     * 无参的分页查询
     * @param pager
     * @return
     */
    Pager getListByPage(Pager pager);

    void saveOrUpdate(T entity);

    List<T> getListByPage(Integer pageNumber, Integer pageSize, String hql, Object... args);

    Integer count();

    Integer getSize(String hql);
}
