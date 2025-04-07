package com.awe.salescoding.tools;

import com.awe.salescoding.data.CommandDetail;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxeCaclulatorTest {

    @Test
    void shouldGenerateException() {
        CommandDetail basicGood = new CommandDetail(false, 1, "basic good", 10.0);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        Assertions.assertThatThrownBy(tc::compute).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void testFoodGood() {
        CommandDetail basicGood = new CommandDetail(false, 1, "chocolate bar", 10.0);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        tc.compute();

        Assertions.assertThat(tc.getPriceWithTaxe()).isEqualTo(10.0);
        Assertions.assertThat(tc.getTaxeValue()).isEqualTo(0.0);

    }

    @Test
    void testBookGood() {
        CommandDetail basicGood = new CommandDetail(false, 1, "book", 10.0);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        tc.compute();

        Assertions.assertThat(tc.getPriceWithTaxe()).isEqualTo(10.0);
        Assertions.assertThat(tc.getTaxeValue()).isEqualTo(0.0);

    }

    @Test
    void testMedicalGood() {
        CommandDetail basicGood = new CommandDetail(false, 1, "packet of headache pills", 9.75);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        tc.compute();

        Assertions.assertThat(tc.getPriceWithTaxe()).isEqualTo(9.75);
        Assertions.assertThat(tc.getTaxeValue()).isEqualTo(0.0);

    }

    @Test
    void testOtherGood() {
        CommandDetail basicGood = new CommandDetail(false, 1, "music CD", 10.0);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        tc.compute();

        Assertions.assertThat(tc.getPriceWithTaxe()).isEqualTo(11.0);
        Assertions.assertThat(tc.getTaxeValue()).isEqualTo(1.0);

    }

    @Test
    void testOtherImportedGood() {
        CommandDetail basicGood = new CommandDetail(true, 1, "music CD", 10.0);
        TaxeCaclulatorImpl tc = new TaxeCaclulatorImpl(basicGood);
        tc.compute();

        Assertions.assertThat(tc.getPriceWithTaxe()).isEqualTo(11.5);
        Assertions.assertThat(tc.getTaxeValue()).isEqualTo(1.5);

    }
}