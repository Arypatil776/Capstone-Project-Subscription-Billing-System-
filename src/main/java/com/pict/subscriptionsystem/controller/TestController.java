package com.pict.subscriptionsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String home() {
        return "Subscription System is Running!";
    }
}