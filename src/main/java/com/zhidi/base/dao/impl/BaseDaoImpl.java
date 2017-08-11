package com.zhidi.base.dao.impl;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *继承dao的实现
 * Created by lx on 2017/7/14.
 */
@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    //注入SessionFactory
    @Resource
    private SessionFactory sessionFactory;
    //实际类型的Class对象
    private Class<T> entityClass;

    public BaseDaoImpl() {
        Class clz = getClass();
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            //获取实际参数类型的数组
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            entityClass = (Class<T>) types[0];
        }
    }

    /**
     * 获取Session的方法
     * @return
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        Query query = getSession().createQuery("from " + entityClass.getName());//from Emp
        return (List<T>) query.list();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void delete(PK id) {
        T entity = get(id);
        getSession().delete(entity);
        getSession().flush();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria) {
        //Hibernate查询，1.HQL  2.Criteria  3.原生 DetachedCriteria
        if (pager == null) {
            pager = new Pager();
        }
        //总条数
        /*Integer totalRows = getAll().size();
        pager.setTotalRows(totalRows);
        //设置总页数
        pager.setTotalPage(pager.getTotalPage());

        Query query = getSession().createQuery("from " + entityClass.getName());
        //Criteria criteria = getSession().createCriteria(entityClass);
        //设置从哪里开始查询
        query.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
        //设置查询数量
        query.setMaxResults(pager.getPageSize());
        //数据集合
        List list = query.list();
        pager.setList(list);*/

        //通过Criteria来写分页条件查询
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());

        //查询总条数
        //select count(1) fomr emp
        Integer totalRows = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        //把Criteria对象中的Projection对象给去掉
        criteria.setProjection((Projection) null);

        criteria.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());//设置查询的起始位置
        criteria.setMaxResults(pager.getPageSize());//查询的条数
        List list = criteria.list();

        pager.setList(list);
        return pager;
    }

    @Override
    public List<T> getListByPage(Integer pageNumber, Integer pageSize, String hql, Object... args) {
        //from User where username=?
        Query query = getSession().createQuery(hql);
        if (args != null && args.length > 0) {
            //设置参数
            for (int i=0;i<args.length;i++) {
                query.setParameter(i, args[i]);
            }
        }
        if(pageNumber!=null&&pageSize!=null) {
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
        }
        return query.list();
    }

    @Override
    public Integer getSize(String hql) {
        Query query = getSession().createQuery(hql);
        return query.list().size();
    }

    @Override
    public Integer count() {
        String hql = "select count(1) from " + entityClass.getName();
        return Integer.parseInt(getSession().createQuery(hql).uniqueResult().toString());
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Pager getListByPage(Pager pager) {
        if (pager == null) {
            pager = new Pager();
        }
        //总条数
        Integer totalRows = getAll().size();
        pager.setTotalRows(totalRows);
        //设置总页数
        pager.setTotalPage(pager.getTotalPage());

        Query query = getSession().createQuery("from " + entityClass.getName());
        //Criteria criteria = getSession().createCriteria(entityClass);
        //设置从哪里开始查询
        query.setFirstResult((pager.getPageNumber() - 1) * pager.getPageSize());
        //设置查询数量
        query.setMaxResults(pager.getPageSize());
        //数据集合
        List<T> list = query.list();
        pager.setList(list);

        return pager;
    }
}
