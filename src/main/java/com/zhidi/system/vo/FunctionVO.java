package com.zhidi.system.vo;


import com.zhidi.system.entity.Function;
import com.zhidi.util.DateUtil;

/**
 * Created by Administrator on 2017/7/26.
 */
public class FunctionVO {
    private String id;
    private String funcName;
    private Integer funcType;
    private String funcURL;
    private String funcNote;
    private String createByUserName;
    private String createTime;
    private String updateByUserName;
    private String updateTime;
    private Integer status;
    private String parentId;
    private String funcCode;
    private Integer sortNum;
    private String createById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public String getFuncURL() {
        return funcURL;
    }

    public void setFuncURL(String funcURL) {
        this.funcURL = funcURL;
    }

    public String getFuncNote() {
        return funcNote;
    }

    public void setFuncNote(String funcNote) {
        this.funcNote = funcNote;
    }

    public String getCreateByUserName() {
        return createByUserName;
    }

    public void setCreateByUserName(String createByUserName) {
        this.createByUserName = createByUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateByUserName() {
        return updateByUserName;
    }

    public void setUpdateByUserName(String updateByUserName) {
        this.updateByUserName = updateByUserName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public static FunctionVO fromFunction(Function function){
        FunctionVO functionVO = new FunctionVO();
        if(function != null){
            functionVO.setId(function.getId());
            functionVO.setFuncName(function.getFuncname());
            functionVO.setFuncType(function.getFunctype());
            functionVO.setFuncURL(function.getFuncurl());
            functionVO.setFuncNote(function.getFuncnote());
            functionVO.setCreateTime(DateUtil.formatDate(function.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
            functionVO.setUpdateTime(DateUtil.formatDate(function.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            functionVO.setStatus(function.getStatus());
            functionVO.setFuncCode(function.getFunccode());
            if(function.getUserByCreateby()!=null){
                functionVO.setCreateByUserName(function.getFuncname());
                functionVO.setCreateById(function.getId());
            }
            if(function.getUserByUpdateby()!=null){
                functionVO.setUpdateByUserName(function.getFuncname());
            }
            if(function.getFunction()!=null){
                functionVO.setParentId(function.getFunction().getId());
            }
            functionVO.setSortNum(function.getSortnum());
            return functionVO;
        }
        return null;
    }

    public static Function toFunction(FunctionVO functionVO){
        Function function = new Function();
        if(functionVO!=null){
            if(functionVO.getId().length()!=0) {
                function.setId(functionVO.getId());
            }
            function.setFuncname(functionVO.getFuncName());
            function.setFuncurl(functionVO.getFuncURL());
            function.setFunccode(functionVO.getFuncCode());
            function.setFunctype(functionVO.getFuncType());
            function.setSortnum(functionVO.getSortNum());
            function.setStatus(functionVO.getStatus());
            function.setFuncnote(functionVO.getFuncNote());
            return function;
        }
        return null;
    }
}
