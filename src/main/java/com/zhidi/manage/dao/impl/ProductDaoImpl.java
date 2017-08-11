package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.ProductDao;
import com.zhidi.manage.entity.Product;
import com.zhidi.manage.vo.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-02.
 */
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product,String> implements ProductDao{

    @Override
    public List<Product> getProductListByPage(Integer pageNumber, Integer pageSize, ProductVO product) {
        String hql ;
        if(product==null){
            hql = "from Product p left join fetch p.user left join fetch p.productCategory";
        }
        else if (product.getSuggestedprice()==null){
            hql = "from Product p left join fetch p.user left join fetch p.productCategory where p.name like '%"+product.getName()+"%'";
        }else{
            hql = "from Product p left join fetch p.user left join fetch p.productCategory where p.name like '%"+product.getName()+"%' and p.suggestedprice ="+product.getSuggestedprice();
        }
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }

    @Override
    public Integer getSize(ProductVO product) {
        String hql ;
        if(product==null){
            hql = "from Product p left join fetch p.user left join fetch p.productCategory";
        }
        else if (product.getSuggestedprice()==null){
            hql = "from Product p left join fetch p.user left join fetch p.productCategory where p.name like '%"+product.getName()+"%'";
        }else{
            hql = "from Product p left join fetch p.user left join fetch p.productCategory where p.name like '%"+product.getName()+"%' and p.suggestedprice ="+product.getSuggestedprice();
        }
        return this.getSize(hql);
    }
}
