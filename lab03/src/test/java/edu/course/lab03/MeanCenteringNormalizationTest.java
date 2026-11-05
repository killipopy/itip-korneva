package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MeanCenteringNormalizationTest {
    private final MeanCenteringNormalization strategy = new MeanCenteringNormalization();

    @Test
    void centersAroundMean() {
        assertArrayEquals(
                new double[]{-2.0, 0.0, 2.0},
                strategy.normalize(new double[]{1.0, 3.0, 5.0}),
                1e-9);
    }

    @Test
    void equalValuesProduceZeros() {
        assertArrayEquals(
                new double[]{0.0, 0.0},
                strategy.normalize(new double[]{4.0, 4.0}),
                1e-9);
    }
}