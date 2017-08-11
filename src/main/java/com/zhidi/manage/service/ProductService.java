package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Product;
import com.zhidi.manage.vo.ProductVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-08-02.
 */
public interface ProductService extends BaseService<Product , String>{

    Pager getProductListByPage(Integer pageNumber, Integer pageSize, ProductVO productVO);
    ProductVO getProductVOById(String id);
}
