package com.example.employeecrudmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/greet")
    public String sayGreeting() {
        return "Say Greeting!";
    }

    @GetMapping("/say-spring")
    public String saySpringMvc() {
        return "Say Spring Mvc!";
    }
}