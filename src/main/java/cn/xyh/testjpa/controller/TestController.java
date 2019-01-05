package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by xyh on 2019/1/5
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @GetMapping("/01")
    public ResponseResult test01(String var1) {
        System.out.println(var1);
        return ResponseResult.success(var1);
    }

    @GetMapping("/02")
    public ResponseResult test02(String var1) {
        System.out.println(var1);
        return ResponseResult.success(var1);
    }
}
