package com.example.testingweb.entrypoint.controllers;

import com.example.testingweb.core.GreetingUseCase;
import com.example.testingweb.models.ObjectTestRequest;
import com.example.testingweb.models.ObjectTestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    private final GreetingUseCase service;

    public GreetingController(GreetingUseCase service) {
        this.service = service;
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return service.greet();
    }

    @RequestMapping("/greeting2")
    public @ResponseBody String greeting2() {
        return service.greet2();
    }

    @RequestMapping("/teste/{id}")
    public @ResponseBody
    ObjectTestResponse teste(@PathVariable("id") int id, @RequestBody ObjectTestRequest request) {
        return service.teste(request);
    }

}