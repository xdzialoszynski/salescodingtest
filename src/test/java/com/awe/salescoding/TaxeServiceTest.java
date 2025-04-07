package com.awe.salescoding;

import com.awe.salescoding.data.CommandDetail;
import com.awe.salescoding.data.Input;
import com.awe.salescoding.data.Tools;
import com.awe.salescoding.service.TaxeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class TaxeServiceTest {

    @Autowired
    TaxeServiceImpl taxeService;

    @Test
    void shouldGiveNoOutput() {
        Input input = new Input(null);
        assertThat(taxeService.computeOutput(input)).isNull();
    }

    @Test
    void shouldGetException() {
        Input input = new Input(Collections.singletonList(new CommandDetail(false, 1, "titi", 10)));
        assertThatThrownBy(()->taxeService.computeOutput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldGiveOutput_1() {
        Input input = Tools.getInput_1();
        assertThat(taxeService.computeOutput(input)).isEqualTo(Tools.getOutput_1());
    }

    @Test
    void shouldGiveOutput_2() {
        Input input = Tools.getInput_2();
        assertThat(taxeService.computeOutput(input)).isEqualTo(Tools.getOutput_2());
    }

    @Test
    void shouldGiveOutput_3() {
        Input input = Tools.getInput_3();
        assertThat(taxeService.computeOutput(input)).isEqualTo(Tools.getOutput_3());
    }
}