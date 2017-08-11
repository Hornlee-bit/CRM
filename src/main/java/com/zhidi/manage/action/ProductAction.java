package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Product;
import com.zhidi.manage.vo.ProductVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;


/**
 * Created by Administrator on 2017-08-02.
 */
@ParentPackage("struts-default")
@Namespace("/manage/product")
public class ProductAction extends BaseAction{
    private String ids;
    private Integer page;
    private Integer rows;
    private ProductVO productVO;
    @Action(value = "ProductAction_list",results = {
            @Result(location ="list_product.jsp" )
    })
    public String productAction_list(){
        return SUCCESS;
    }

    /**
     * 分页查询产品信息
     */
    @Action(value = "ProductAction_findByPage")
    public void productAction_findByPage() throws IOException{
        pager = productService.getProductListByPage(page,rows,productVO);
        resultData = ResultData.buildSuccessResult("success",pager);
        printJSONObject(resultData);
    }

    /**
     * 转到修改和新增界面
     */
    @Action(value = "ProductAction_edit",results = {
            @Result(location = "edit_product.jsp")
    })
    public String productAction_edit(){
        if(productVO!=null){
            productVO = productService.getProductVOById(productVO.getProductid());
        }
        return SUCCESS;
    }

    /**
     * 新增和修改Action
     */
    @Action(value = "ProductAction_saveOrUpdate")
    public void ProductAction_saveOrUpdate() throws IOException{
        Product product;
        //新增
        if("".equals(productVO.getProductid())){
            product = ProductVO.toProduct(productVO);
            product.setUser((User) getSession().getAttribute("user"));
            productService.save(product);
            resultData = ResultData.buildSuccessResult("保存成功");
        }
        //修改
        else{
            product = ProductVO.toProduct(productVO);
            productService.update(product);
            resultData = ResultData.buildSuccessResult("修改成功");
        }
        printJSONObject(resultData);
    }
    /**
     * 删除产品
     */
    @Action(value = "ProductAction_remove")
    public void productAction_remove() throws IOException{
        boolean state = productService.deleteByIds(ids);
        if(state){
            resultData = ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }
}
