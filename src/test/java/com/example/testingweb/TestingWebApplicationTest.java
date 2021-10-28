package com.example.testingweb;

import static com.example.testingweb.WebMockTest.asJsonString;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testingweb.core.GreetingUseCase;
import com.example.testingweb.models.ObjectTestRequest;
import com.example.testingweb.models.ObjectTestResponse;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Testes sem subir um servidor, porém iniciando todas as controllers (essa anotação desta classe faz isso)
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingUseCase useCase;

    @Test
    public void teste() throws Exception {
        ObjectTestResponse expected = ObjectTestResponse.builder().atributoResponse1(1).atributoResponse2("2").atributoResponse3(3L).build();

        ObjectTestResponse useCaseResponse = ObjectTestResponse.builder().atributoResponse1(1).atributoResponse2("2").atributoResponse3(3L).build();

        when(useCase.teste(Mockito.any(ObjectTestRequest.class)))
                .thenReturn(useCaseResponse);        mockMvc.perform(MockMvcRequestBuilders
                        .put("/teste/{id}", 2)
                        .content(asJsonString(new ObjectTestRequest(5, "dsadasd", 4L)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.atributoResponse1").value(expected.getAtributoResponse1()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.atributoResponse2").value(expected.getAtributoResponse2()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.atributoResponse3").value(expected.getAtributoResponse3()));

    }
}