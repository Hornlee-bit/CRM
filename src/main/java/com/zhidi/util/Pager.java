package com.zhidi.util;

import java.util.List;

/**
 * 分页的工具类
 * Created by lx on 2017/7/14.
 */
public class Pager {

    private Integer pageNumber = 1; //第几页
    private Integer pageSize = 10; //一页显示多少条
    private Integer totalRows; //总条数
    private Integer totalPage; //总页数

    private List list;          //数据

    public Integer getPageNumber() {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageNumber > totalPage) {
            pageNumber = totalPage;
        }
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPage() {
        return (totalRows + pageSize -1)/pageSize;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
