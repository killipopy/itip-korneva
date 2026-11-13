package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinMaxNormalizationTest {
    private final MinMaxNormalization strategy = new MinMaxNormalization();

    @Test
    void mapsToUnitRange() {
        assertArrayEquals(
                new double[]{0.0, 0.5, 1.0},
                strategy.normalize(new double[]{0.0, 5.0, 10.0}),
                1e-9);
    }

    @Test
    void equalValuesProduceZeros() {
        assertArrayEquals(
                new double[]{0.0, 0.0, 0.0},
                strategy.normalize(new double[]{3.0, 3.0, 3.0}),
                1e-9);
    }
}