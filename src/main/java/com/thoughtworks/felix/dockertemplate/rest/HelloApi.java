package com.thoughtworks.felix.dockertemplate.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class HelloApi {

    @GetMapping
    public String hello() {
        return "hello, world";
    }
}
