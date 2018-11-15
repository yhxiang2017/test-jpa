package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.mapper.StaffMapper;
import cn.xyh.testjpa.param.SomeParam;
import cn.xyh.testjpa.service.StaffService;
import cn.xyh.testjpa.util.ResponseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class StaffController {


    @Resource
    private StaffMapper staffMapper;

    @Resource
    private StaffService staffService;

    @GetMapping("/mappertest")
    public void mapperTest(){
        cn.xyh.testjpa.model.Staff staff = staffMapper.selectByPrimaryKey(1);
        System.out.println(staff.getStaffName() + staff.getAddress() + staff.getInTime());
    }

    @PostMapping("/fenyetest")
    public ResponseResult fenyeTest(@RequestBody @Valid SomeParam someParam) {
        return staffService.fenyeTest(someParam);
    }
}
