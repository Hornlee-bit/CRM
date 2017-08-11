package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Product;
import com.zhidi.manage.entity.ProductCategory;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by Administrator on 2017-08-02.
 */
public class ProductVO {

    private String productid;
    private String userid;
    private String username;
    private String name;
    private Double costprice;
    private Double suggestedprice;
    private String developmentteam;
    private String developmenttime;
    private String link;
    private String createtime;
    private String updatetime;
    private String description;
    private String categoryid;

    public static ProductVO fromProduct(Product product){
        if(product!=null) {
            ProductVO productVO = new ProductVO();
            productVO.setProductid(product.getProductid());
            productVO.setName(product.getName());
            productVO.setCostprice(product.getCostprice());
            productVO.setSuggestedprice(product.getSuggestedprice());
            productVO.setDevelopmentteam(product.getDevelopmentteam());
            productVO.setDevelopmenttime(DateUtil.formatDate(product.getDevelopmenttime(),"yyyy-MM-dd HH:mm:ss"));
            productVO.setLink(product.getLink());
            productVO.setCreatetime(DateUtil.formatDate(product.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            productVO.setUpdatetime(DateUtil.formatDate(product.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            productVO.setDescription(product.getDescription());
            if(product.getProductCategory()!=null) {
                productVO.setCategoryid(product.getProductCategory().getCategoryid());
            }
            if(product.getUser()!=null){
                productVO.setUserid(product.getUser().getId());
                productVO.setUsername(product.getUser().getUsername());
            }
            return productVO;
        }
        return null;
    }

    public static Product toProduct(ProductVO productVO){
        if(productVO!=null){
            Product product = new Product();
            BeanUtils.copyProperties(productVO,product);
            if("".equals(productVO.getProductid())){
                product.setCreatetime(new Date());
                product.setUpdatetime(new Date());
            }
            else {
                product.setUpdatetime(new Date());
                product.setCreatetime(DateUtil.parseDate(productVO.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            }
            if(!"".equals(productVO.getUserid())){
                User user =new User();
                user.setId(productVO.getUserid());
                product.setUser(user);
            }
            if(!"".equals(productVO.getCategoryid())){
                ProductCategory productCategory = new ProductCategory();
                productCategory.setCategoryid(productVO.getCategoryid());
                product.setProductCategory(productCategory);
            }
           return product;
        }
        return null;
    }
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public Double getSuggestedprice() {
        return suggestedprice;
    }

    public void setSuggestedprice(Double suggestedprice) {
        this.suggestedprice = suggestedprice;
    }

    public String getDevelopmentteam() {
        return developmentteam;
    }

    public void setDevelopmentteam(String developmentteam) {
        this.developmentteam = developmentteam;
    }

    public String getDevelopmenttime() {
        return developmenttime;
    }

    public void setDevelopmenttime(String developmenttime) {
        this.developmenttime = developmenttime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
}
