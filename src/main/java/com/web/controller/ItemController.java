package com.web.controller;

import com.service.UserService;
import com.web.support.ApiResponse;
import com.web.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private UserService userService;

    @GetMapping("/items")
    public Object getItems(@RequestParam("name") String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/test")
    public Object test(@RequestParam("name") String name, @RequestParam("id") int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("用户 ID 必须大于 0");
        }
        return ApiResponse.success(new User(id, name));
    }
}