package com.gaohanna.oasis.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
public class PageResult<T> implements Serializable{
    private static final long serialVersionUID = 7336512198224817711L;

    private int pageNo;
    private int pageSize;

    private int totalCount;

    private List<T> result;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getTotalPage(){
        if (pageNo < 1){
            return 1;
        }
        return totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
    }

    public PageResult(int pageNo, int pageSize, int totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        result = new LinkedList();
    }

    public PageResult(int pageNo, int pageSize, int totalCount, List<T> result) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.result = result;
    }
}
