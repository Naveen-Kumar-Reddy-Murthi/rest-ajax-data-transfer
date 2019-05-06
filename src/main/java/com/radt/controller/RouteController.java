package com.radt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {


    @GetMapping("/")
    public String index() {
        return "hello";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @GetMapping("/user")
    public String userForm() {
        return "user";
    }
    
    @GetMapping("/message")
    public String message() {
        return "message";
    }
    
    @GetMapping("/password")
    public String password() {
        return "password";
    }
    
}