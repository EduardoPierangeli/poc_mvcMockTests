package com.example.testingweb.core;

import com.example.testingweb.models.ObjectTestRequest;
import com.example.testingweb.models.ObjectTestResponse;
import org.springframework.stereotype.Service;

@Service
public class GreetingUseCase {

    public String greet() {
        return "Hello, World";
    }

    public String greet2() {
        return "Hello, World 2";
    }

    public ObjectTestResponse teste(ObjectTestRequest input) {
        return ObjectTestResponse.builder().atributoResponse1(1).atributoResponse2("2").atributoResponse3(3L).build();
    }
}