package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.ContractDao;
import com.zhidi.manage.entity.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract,String> implements ContractDao {
    @Override
    public List<Contract> getContractByPage(Integer pageNumber, Integer pageSize,String conditionOne ,String conditionTwo,String contractCondition) {
        StringBuffer hql = new StringBuffer("from Contract c left join fetch c.business b left join fetch c.ownerUser co "+
        "left join fetch c.createUser cc left join fetch c.deleteUser left join fetch " +
                "b.customer bc left join fetch b.businessContacts bbc ");
        if("1".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where bc.name like '%"+contractCondition+"%'");
        }else if("1".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where bc.name = '" +contractCondition+"'");

        }else if("2".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where bbc.name like '%"+contractCondition+"%'");
        }else if("2".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where bbc.name = '"+contractCondition+"'");

        }else if("3".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where co.username like '%"+contractCondition+"%'");
        }else if("3".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where co.username = '"+contractCondition+"'");
        }

        return this.getListByPage(pageNumber,pageSize,hql.toString(),new String[]{});
    }

    @Override
    public Integer getSize(String conditionOne, String conditionTwo, String contractCondition) {
        StringBuffer hql = new StringBuffer("from Contract c left join fetch c.business b left join fetch c.ownerUser co "+
                "left join fetch c.createUser cc left join fetch c.deleteUser left join fetch " +
                "b.customer bc left join fetch b.businessContacts bbc ");
        if("1".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where bc.name like '%"+contractCondition+"%'");
        }else if("1".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where bc.name = '" +contractCondition+"'");

        }else if("2".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where bbc.name like '%"+contractCondition+"%'");
        }else if("2".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where bbc.name = '"+contractCondition+"'");

        }else if("3".equals(conditionOne)&&"1".equals(conditionTwo)){
            hql = hql.append("where co.username like '%"+contractCondition+"%'");
        }else if("3".equals(conditionOne)&&"2".equals(conditionTwo)){
            hql = hql.append("where co.username = '"+contractCondition+"'");
        }
        return this.getSize(hql.toString());
    }
}
