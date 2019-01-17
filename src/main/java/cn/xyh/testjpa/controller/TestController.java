package cn.xyh.testjpa.controller;

import cn.xyh.testjpa.jwt.JwtUtil;
import cn.xyh.testjpa.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Create by xyh on 2019/1/5
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

//    @Resource
//    private RedisTemplate<String, HashMap<String, String>> redisTemplate;
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;

//    @GetMapping("/token")
//    public ResponseResult test01(String var1) {
//        System.out.println(var1);
//        String token = JwtUtil.generateToken(var1);
//        HashMap<String, String> map = new HashMap<>(2);
//        map.put(token, "openId");
//        redisTemplate.opsForValue().set(token.replace("Bearer ",""), map, 30, TimeUnit.DAYS);
//        stringRedisTemplate.opsForValue().set("openId", "sessionKey", 30, TimeUnit.DAYS);
//        return ResponseResult.success(token);
//    }

    @GetMapping("/02")
    public ResponseResult test02(@RequestHeader(value = "openId") String openId, String var1) {
        System.out.println(var1);
        System.out.println(openId);
        return ResponseResult.success(var1);
    }

    @GetMapping("/03")
    public ResponseResult test03() {
        int i = 1 / 0;
        return ResponseResult.success();
    }

}
