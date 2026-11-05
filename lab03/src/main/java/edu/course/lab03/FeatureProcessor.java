package edu.course.lab03;

public class FeatureProcessor {
    private final NormalizationStrategy strategy;

    public FeatureProcessor(NormalizationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("strategy must not be null");
        }
        this.strategy = strategy;
    }

    public double[] process(double[] values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        return strategy.normalize(values); // стратегия возвращает новый массив
    }
}