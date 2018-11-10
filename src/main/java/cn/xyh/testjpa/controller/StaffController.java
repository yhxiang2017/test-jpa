package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.mapper.StaffMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StaffController {


    @Resource
    private StaffMapper staffMapper;

    @GetMapping("/mappertest")
    public void mapperTest(){
        cn.xyh.testjpa.model.Staff staff = staffMapper.selectByPrimaryKey(1);
        System.out.println(staff.getStaffName() + staff.getAddress() + staff.getInTime());
    }
}
