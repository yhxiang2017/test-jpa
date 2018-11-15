package cn.xyh.testjpa.param;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class PageParam {

    @Min(0)
    @Max(100)
    private int pageIndex;

    @Min(1)
    @Max(value = 100)
    private int pageSize;

    private int offset;

    public int getOffset() {
        return pageIndex * pageSize;
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
}
