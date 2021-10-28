package com.example.testingweb.entrypoint.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
    @RequestMapping("/2")
    public @ResponseBody String greeting2() {
        return "Hello, World 2";
    }

}