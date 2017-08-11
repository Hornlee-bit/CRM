package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.DictType;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.impl.DictTypeServiceImpl;
import com.zhidi.system.vo.DictVO;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017-07-28.
 */
@ParentPackage("struts-default")
@Namespace("/system/dict")
public class DictAction extends BaseAction{

    private Integer page;
    private Integer rows;
    private DictType dictType;
    private String ids;
    private DictVO dictVO;
    private String typeCode;
    @Action(value = "DictAction_index",results = {
            @Result(location = "index_dict.jsp")
    })
    public String dictAction_index(){
        return SUCCESS;
    }

    /**
     * 加载所有字典类型
     */
    @Action(value = "DictTypeAction_findAll")
    public void dictTypeAction_findAll() throws IOException{
        List<DictType> list = dictTypeService.getAll();
        resultData = ResultData.buildSuccessResult("success",list);
        printJSONObject(resultData,"dicts","userByCreateby","userByUpdateby");
    }

    /**
     * 通过字典类型id获取所有字典
     * @throws IOException
     */
    @Action(value = "DictAction_findByDictTypeId")
    public void dictAction_findByDictTypeId() throws IOException{
          pager = dictService.findAllDictsByDictTypeId(page,rows,dictType);
          resultData = resultData.buildSuccessResult("成功",pager);
          printJSONObject(resultData);
    }
    @Action(value = "DictAction_findByTypecode")
    public void dictAction_findByTypecode() throws IOException{
        List<DictVO> list = dictService.getDictVOByDictType(typeCode);
        resultData = ResultData.buildSuccessResult("",list);
        printJSONObject(resultData);
    }
    /**
     * 转向字典类型修改和添加页面
     * @return
     */
    @Action(value = "DictTypeAction_edit",results = {
            @Result(location = "edit_dictType.jsp")
    })
    public String dictTypeAction_edit(){
        if(dictType!=null){
            dictType = dictTypeService.get(dictType.getId());
        }
        return SUCCESS;
    }

    /**
     * 保存和修改字典类型
     */
    @Action(value = "DictTypeAction_saveOrUpdate")
    public void dictTypeAction_saveOrUpdate() throws IOException{
          if(dictType.getId().length()!=0){
              DictType dictType_update = dictTypeService.get(dictType.getId());
              BeanUtils.copyProperties(dictType,dictType_update);
              dictType_update.setUserByUpdateby((User) getSession().getAttribute("user"));
              dictType_update.setUpdatetime(new Date());
              dictTypeService.update(dictType_update);
              resultData = ResultData.buildSuccessResult("修改成功");
              printJSONObject(resultData);
              return;
          }
          dictType.setUserByCreateby((User) getSession().getAttribute("user"));
          dictType.setCreatetime(new Date());
          dictTypeService.save(dictType);
          resultData = ResultData.buildSuccessResult("保存成功");
          printJSONObject(resultData);
    }

    /**
     * 删除字典类型
     */
    @Action(value = "DictTypeAction_remove")
    public void dictTypeAction_remove() throws IOException{
        boolean state = dictTypeService.deleteByIds(dictType.getId());
        if(state) {
            resultData = ResultData.buildSuccessResult("删除成功");
        }
        else {
            resultData = ResultData.buildFailureResult("存在子纪录，无法删除");
        }
        printJSONObject(resultData);

    }

    /**
     * 转到字典修改和新增页面
     * @return
     */
    @Action(value = "DictAction_edit",results = {
            @Result(location = "edit_dict.jsp")
    })
    public String dictAction_edit(){
        if(dictVO!=null){
            dictVO = dictService.getDictVOById(dictVO.getId());
        }
        else {
            dictVO = new DictVO();
            dictVO.setDictTypeId(dictType.getId());
        }
        return SUCCESS;
    }
    @Action(value = "DictAction_saveOrUpdate")
    public void DictAction_saveOrUpdate() throws IOException{
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictVO,dict);
        dict.setDictType(dictTypeService.get(dictVO.getDictTypeId()));
        if(dictVO.getId().length()!=0){
            dictService.update(dict);
            resultData = ResultData.buildSuccessResult("更新成功");
            printJSONObject(resultData);
            return;
        }
        dictService.save(dict);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }

    /**
     * 删除字典
     */
    @Action(value = "DictAction_remove")
    public void dictAction_remove() throws IOException{
        boolean state = dictService.deleteByIds(ids);
        if(state){
            resultData =ResultData.buildSuccessResult("删除成功");
        }
        else{
            resultData =ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }
    public DictType getDictType() {
        return dictType;
    }

    public void setDictType(DictType dictType) {
        this.dictType = dictType;
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public DictVO getDictVO() {
        return dictVO;
    }

    public void setDictVO(DictVO dictVO) {
        this.dictVO = dictVO;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
