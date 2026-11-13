package edu.course.lab03;

public class MinMaxNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        if (values.length == 0) {
            return new double[0];
        }
        double min = values[0];
        double max = values[0];
        for (double v : values) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        double range = max - min;
        double[] result = new double[values.length];
        if (range == 0.0) {
            // все значения одинаковы — нормировать не к чему
            return result;
        }
        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - min) / range;
        }
        return result;
    }
}