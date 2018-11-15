package cn.xyh.testjpa.param;

import java.util.List;

public class PageData {

    private int totalCount;

    private int totalPages;

    private int pageIndex;

    private int pageSize;

    private List data;

    public PageData () {

    }

    public PageData (int totalCount, int pageIndex, int pageSize, List data) {

        int mod = totalCount % pageSize;
        int totalPages = mod == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;

        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.data = data;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
