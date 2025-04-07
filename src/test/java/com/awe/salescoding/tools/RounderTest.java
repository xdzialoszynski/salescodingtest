package com.awe.salescoding.tools;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class RounderTest {
    @Test
    public void testRoundUpToNearest005() {
        assertThat(Rounder.roundUpToNearest005(0.000)).isEqualTo(0.000, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.001)).isEqualTo(0.05, within(0.001))  ;
        assertThat(Rounder.roundUpToNearest005(0.005)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.006)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.010)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.011)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.049)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.050)).isEqualTo(0.05, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.051)).isEqualTo(0.1, within(0.001));
        assertThat(Rounder.roundUpToNearest005(0.117)).isEqualTo(0.15, within(0.001));
    }

    @Test
    public void testRound2Digits() {
        assertThat(Rounder.round2Digits(1.234)).isEqualTo(1.23);
        assertThat(Rounder.round2Digits(1.235)).isEqualTo(1.24);
        assertThat(Rounder.round2Digits(1.2345)).isEqualTo(1.23);
        assertThat(Rounder.round2Digits(1.286)).isEqualTo(1.29);
        assertThat(Rounder.round2Digits(0.004)).isEqualTo(0.00);
        assertThat(Rounder.round2Digits(0.005)).isEqualTo(0.01);
    }

}