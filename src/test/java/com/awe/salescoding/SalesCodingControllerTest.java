package com.awe.salescoding;

import com.awe.salescoding.data.Input;
import com.awe.salescoding.data.Output;
import com.awe.salescoding.data.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalesCodingControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    JacksonTester<Output> json;

    JacksonTester<Input> inputJacksonTester;



    @BeforeEach
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }


    @Test
    void testUnknownCategory() throws IOException {
        ObjectContent<Input> input = inputJacksonTester.read("category_non_referencee.json");
        assertThat(restTemplate.postForEntity("/sales/output", input.getObject(), String.class).getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Test
    void shouldGetOkFromPostSalesTicket() {
        Input input = Tools.getInput();
        assertThat(restTemplate.postForEntity("/sales/output", input, String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        String body = restTemplate.postForEntity("/sales/output", input, String.class).getBody();
        DocumentContext documentContext = JsonPath.parse(body);
        Number length = documentContext.read("$.length()");
        assertThat(length).isEqualTo(3);
    }

    @Test
    void shouldGetOutput_1FromInput_1() throws IOException {
        Input input = Tools.getInput_1();
        assertThat(restTemplate.postForEntity("/sales/output", input, String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        String body = restTemplate.postForEntity("/sales/output", input, String.class).getBody();
        ObjectContent<Output> actualBody = json.parse(body);
        ObjectContent<Output> expectedBody = json.read("output_1.json");
        assertThat(actualBody.getObject()).isEqualTo(expectedBody.getObject());
    }

    @Test
    void shouldGetOutput_2FromInput_2() throws IOException {
        Input input = Tools.getInput_2();
        assertThat(restTemplate.postForEntity("/sales/output", input, String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        String body = restTemplate.postForEntity("/sales/output", input, String.class).getBody();
        ObjectContent<Output> actualBody = json.parse(body);
        ObjectContent<Output> expectedBody = json.read("output_2.json");
        assertThat(actualBody.getObject()).isEqualTo(expectedBody.getObject());
    }

    @Test
    void shouldGetOutput_3FromInput_3() throws IOException {
        Input input = Tools.getInput_3();
        assertThat(restTemplate.postForEntity("/sales/output", input, String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        String body = restTemplate.postForEntity("/sales/output", input, String.class).getBody();
        ObjectContent<Output> actualBody = json.parse(body);
        ObjectContent<Output> expectedBody = json.read("output_3.json");
        assertThat(actualBody.getObject()).isEqualTo(expectedBody.getObject());
    }
}