package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.BusinessDao;
import com.zhidi.manage.entity.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
@Repository
public class BusinessDaoImpl extends BaseDaoImpl<Business,String> implements BusinessDao {
    @Override
    public List<Business> getBusinessListByPage(Integer pageNumber, Integer pageSize ,String condition,String searchText) {
        StringBuffer hql = new StringBuffer("from Business b left join fetch b.userByCreatoruserid left join fetch b.businessStatus " +
                "left join fetch b.userByUpdateuserid left join fetch b.businessContacts " +
                "left join fetch b.userByOwneruserid left join fetch b.customer bc " +
                "left join fetch b.userByDeleteuserid ");
        if("1".equals(condition)){
            hql.append("where bc.name like '%"+searchText+"%'");
        }
        if("2".equals(condition)){
            hql.append("where b.name like '%"+searchText+"%'");
        }
        if("3".equals(condition)){
            hql.append("where b.origin like '%"+searchText+"%'");
        }
        if("4".equals(condition)){
            hql.append("where b.nextstep like '%"+searchText+"%'");
        }
        return this.getListByPage(pageNumber,pageSize,hql.toString(),new String[]{});
    }

    @Override
    public Integer getSize(String condition, String searchText) {
        StringBuffer hql = new StringBuffer("from Business b left join fetch b.userByCreatoruserid left join fetch b.businessStatus " +
                "left join fetch b.userByUpdateuserid left join fetch b.businessContacts " +
                "left join fetch b.userByOwneruserid left join fetch b.customer bc " +
                "left join fetch b.userByDeleteuserid ");
        if("1".equals(condition)){
            hql.append("where bc.name like '%"+searchText+"%'");
        }
        if("2".equals(condition)){
            hql.append("where b.name like '%"+searchText+"%'");
        }
        if("3".equals(condition)){
            hql.append("where b.origin like '%"+searchText+"%'");
        }
        if("4".equals(condition)){
            hql.append("where b.nextstep like '%"+searchText+"%'");
        }
        return this.getSize(hql.toString());
    }
}
