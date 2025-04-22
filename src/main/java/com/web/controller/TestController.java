package com.web.controller;

import com.infrastructure.Demo;
import com.web.support.ApiResponse;
import com.web.view.DemoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private Demo demo;

    @GetMapping("/test")
    public Object test(@RequestParam("id") int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("用户 ID 必须大于 0");
        }
        demo.mysqlDemo();
        demo.redisDemo();
        return ApiResponse.success(new DemoVo(id));
    }
}