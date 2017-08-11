package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.ProductDao;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.entity.Product;
import com.zhidi.manage.service.ProductService;
import com.zhidi.manage.vo.AnnouncementVO;
import com.zhidi.manage.vo.ProductVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-02.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,String> implements ProductService {
   @Autowired
   private ProductDao productDao;
   @Autowired
   private void setProductDao(ProductDao productDao){
       super.setBaseDao(productDao);
   }

   @Override
   public Pager getProductListByPage(Integer pageNumber, Integer pageSize, ProductVO productVO) {
      List<Product> productList = productDao.getProductListByPage(pageNumber,pageSize,productVO);
      List<ProductVO> productVOS = new ArrayList<>();
      if (productList != null && !productList.isEmpty()) {
         for (Product product : productList) {
            ProductVO pVO = ProductVO.fromProduct(product);
            productVOS.add(pVO);
         }
      }
      //查询数据总数
      Integer totalRows = productDao.getSize(productVO);
      Pager pager = new Pager();
      pager.setList(productVOS);
      pager.setPageNumber(pageNumber);
      pager.setPageSize(pageSize);
      pager.setTotalRows(totalRows);
      pager.setTotalPage(pager.getTotalPage());
      return pager;
   }

   @Override
   public ProductVO getProductVOById(String id) {
      Product product = productDao.get(id);
      return ProductVO.fromProduct(product);
   }
}
