package edu.course.lab03;

public class ZScoreNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        if (values.length == 0) {
            return new double[0];
        }
        double sum = 0.0;
        for (double v : values) {
            sum += v;
        }
        double mean = sum / values.length;

        double sqSum = 0.0;
        for (double v : values) {
            double d = v - mean;
            sqSum += d * d;
        }
        double std = Math.sqrt(sqSum / values.length);

        double[] result = new double[values.length];
        if (std == 0.0) {
            // все значения равны — нормировать не к чему, возвращаем нули
            return result;
        }
        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - mean) / std;
        }
        return result;
    }
}