package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataSampleTest {

    //корректный объект

    @Test
    void createsValidSample() {
        DataSample sample = new DataSample("s-1", "cat", new double[]{1.0, 2.0, 3.0});

        assertEquals("s-1", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, sample.getFeatures());
        assertFalse(sample.isReady());
    }

    //каждое ограничение конструктора отдельно

    @Test
    void nullIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample(null, "cat", new double[]{1.0}));
    }

    @Test
    void blankIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("   ", "cat", new double[]{1.0}));
    }

    @Test
    void nullLabelThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", null, new double[]{1.0}));
    }

    @Test
    void blankLabelThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", "", new double[]{1.0}));
    }

    @Test
    void nullFeaturesThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", "cat", null));
    }

    @Test
    void emptyFeaturesThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", "cat", new double[0]));
    }

    @Test
    void nanFeatureThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", "cat", new double[]{1.0, Double.NaN}));
    }

    @Test
    void infiniteFeatureThrows() {
        assertThrows(IllegalArgumentException.class, () -> new DataSample("s-1", "cat", new double[]{Double.POSITIVE_INFINITY}));
    }

    // поведение

    @Test
    void changeStatusToReadyMakesSampleReady() {
        DataSample sample = new DataSample("s-1", "cat", new double[]{1.0});
        sample.changeStatus(SampleStatus.READY);
        assertEquals(SampleStatus.READY, sample.getStatus());
        assertTrue(sample.isReady());
    }

    @Test
    void changeStatusToNullThrows() {
        DataSample sample = new DataSample("s-1", "cat", new double[]{1.0});
        assertThrows(IllegalArgumentException.class, () -> sample.changeStatus(null));
        assertEquals(SampleStatus.NEW, sample.getStatus());
    }

    @Test
    void averageFeatureIsCalculated() {
        DataSample sample = new DataSample("s-1", "cat", new double[]{1.0, 2.0, 6.0});
        assertEquals(3.0, sample.averageFeature(), 1e-9);
    }

    // нельзя изменить состояние в обход методов

    @Test
    void changingOriginalArrayDoesNotAffectSample() {
        double[] original = {1.0, 2.0};
        DataSample sample = new DataSample("s-1", "cat", original);
        original[0] = 100.0;
        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());
    }

    @Test
    void changingReturnedArrayDoesNotAffectSample() {
        DataSample sample = new DataSample("s-1", "cat", new double[]{1.0, 2.0});
        double[] returned = sample.getFeatures();
        returned[0] = 100.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());
    }
}