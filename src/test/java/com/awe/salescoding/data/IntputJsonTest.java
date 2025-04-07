package com.awe.salescoding.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class InputJsonTest {

    @Autowired
    JacksonTester<Input> json;

    @Test
    void shouldSerializeAnInput() throws IOException {
        assertThat(json.write(Tools.getInput())).isStrictlyEqualToJson("input.json");
        assertThat(json.write(Tools.getInput())).hasJsonPathValue("$.details");
    }

    @Test
    void shouldDeserializeAnInput() throws IOException {
        Input ticket = Tools.getInput();

        assertThat(json.read("input.json")).isNotNull();
        assertThat(json.read("input.json")).isEqualTo(ticket);
    }


}