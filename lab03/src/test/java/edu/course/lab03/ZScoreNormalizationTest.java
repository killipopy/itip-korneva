package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ZScoreNormalizationTest {
    private final ZScoreNormalization strategy = new ZScoreNormalization();

    @Test
    void standardizesToZeroMeanUnitStd() {
        // {0, 2, 4}: mean = 2, population std = sqrt(8/3)
        // (0-2)/std = -sqrt(3/2), (4-2)/std = +sqrt(3/2)
        double s = Math.sqrt(3.0 / 2.0);
        assertArrayEquals(
                new double[]{-s, 0.0, s},
                strategy.normalize(new double[]{0.0, 2.0, 4.0}),
                1e-9);
    }

    @Test
    void equalValuesProduceZeros() {
        assertArrayEquals(
                new double[]{0.0, 0.0, 0.0},
                strategy.normalize(new double[]{7.0, 7.0, 7.0}),
                1e-9);
    }
}