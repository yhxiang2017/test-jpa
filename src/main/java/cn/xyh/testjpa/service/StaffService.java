package cn.xyh.testjpa.service;

import cn.xyh.testjpa.param.SomeParam;
import cn.xyh.testjpa.util.ResponseResult;

public interface StaffService {

    /**
     * 分页测试
     * @param someParam
     * @return
     */
    ResponseResult fenyeTest(SomeParam someParam);
}
