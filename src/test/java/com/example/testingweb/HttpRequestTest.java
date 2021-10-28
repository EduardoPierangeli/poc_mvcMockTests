package com.example.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testes subindo um servidor e todas as controler são inicializadas
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("Hello, World");
    }

    @Test
    public void greetingShouldReturnDefaultMessage2() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting2",
                String.class)).contains("Hello, World 2");
    }

}