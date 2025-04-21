package com.controller;

import com.model.Item;
import com.service.ItemService;
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
    public Object test() {
        return "hello";
    }
}