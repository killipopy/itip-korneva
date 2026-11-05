package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeatureProcessorTest {
    private static final double[] INPUT = {1.0, 2.0, 3.0};

    @Test
    void usesMinMax() {
        FeatureProcessor p = new FeatureProcessor(new MinMaxNormalization());
        assertArrayEquals(new double[]{0.0, 0.5, 1.0},
                p.process(INPUT.clone()), 1e-9);
    }

    @Test
    void swapsToMeanCentering() {
        FeatureProcessor p = new FeatureProcessor(new MeanCenteringNormalization());
        assertArrayEquals(new double[]{-1.0, 0.0, 1.0},
                p.process(INPUT.clone()), 1e-9);
    }

    @Test
    void doesNotModifyInput() {
        double[] input = INPUT.clone();
        double[] snapshot = INPUT.clone();
        new FeatureProcessor(new MinMaxNormalization()).process(input);
        assertArrayEquals(snapshot, input, 1e-9);
    }

    @Test
    void swapsToZScore() {
        FeatureProcessor p = new FeatureProcessor(new ZScoreNormalization());
        // {1, 2, 3}: mean = 2, population std = sqrt(2/3)
        // (1-2)/std = -sqrt(3/2), (3-2)/std = +sqrt(3/2)
        double s = Math.sqrt(3.0 / 2.0);
        assertArrayEquals(new double[]{-s, 0.0, s},
                p.process(INPUT.clone()), 1e-9);
    }
}