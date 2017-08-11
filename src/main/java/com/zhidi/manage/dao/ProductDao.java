package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Product;
import com.zhidi.manage.vo.ProductVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017-08-02.
 */
public interface ProductDao extends BaseDao<Product,String> {

    List<Product> getProductListByPage(Integer pageNumber , Integer pageSize , ProductVO product);
    Integer getSize(ProductVO product);
}
