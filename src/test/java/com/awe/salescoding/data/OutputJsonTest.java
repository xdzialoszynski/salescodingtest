package com.awe.salescoding.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class OutputJsonTest {

    @Autowired
    JacksonTester<Output> json;

    @Test
    void shouldSerializeAnOutput() throws IOException {
        assertThat(json.write(Tools.getOutput())).isStrictlyEqualToJson("output.json");
        assertThat(json.write(Tools.getOutput())).hasJsonPathValue("$.details");
        assertThat(json.write(Tools.getOutput())).hasJsonPathValue("$.total");
        assertThat(json.write(Tools.getOutput())).hasJsonPathValue("$.salesTaxes");
    }

    @Test
    void shouldDeserializeAnOutput() throws IOException {
        Output ticket = Tools.getOutput();

        assertThat(json.read("output.json")).isNotNull();
        assertThat(json.read("output.json")).isEqualTo(ticket);
    }


}