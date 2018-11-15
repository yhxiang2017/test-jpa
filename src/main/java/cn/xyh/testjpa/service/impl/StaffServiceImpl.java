package cn.xyh.testjpa.service.impl;

import cn.xyh.testjpa.mapper.StaffMapper;
import cn.xyh.testjpa.model.Staff;
import cn.xyh.testjpa.param.PageData;
import cn.xyh.testjpa.param.SomeParam;
import cn.xyh.testjpa.service.StaffService;
import cn.xyh.testjpa.util.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Resource
    private StaffMapper staffMapper;

    /**
     * 分页测试
     * @param someParam
     * @return
     */
    @Override
    public ResponseResult fenyeTest(SomeParam someParam) {
        List<Staff> staffs = staffMapper.selectListByParam(someParam);
        int totalcount = staffMapper.selectListCount(someParam);
        return ResponseResult.success(new PageData(totalcount, someParam.getPageIndex(), someParam.getPageSize(), staffs));
    }
}
