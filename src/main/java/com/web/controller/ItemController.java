package com.web.controller;

import com.service.ItemService;
import com.web.support.ApiResponse;
import com.web.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/items")
    public Object getItems(@RequestHeader("token") String token) {
        return itemService.getItemsByToken(token);
    }

    @GetMapping("/test")
    public Object test(@RequestParam("name") String name, @RequestParam("id") int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("用户 ID 必须大于 0");
        }
        return ApiResponse.success(new User(id, name));
    }
}