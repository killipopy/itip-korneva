package edu.course.lab02;

import java.util.Arrays;

public class DataSample {

    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;

    public DataSample(String id, String label, double[] features) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Идентификатор не может быть пустым");
        }
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("Метка не может быть пустой");
        }
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("Нужен хотя бы 1 признак");
        }
        for (double value : features) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Признак должен быть конечным числом");
            }
        }

        this.id = id;
        this.label = label;
        this.status = SampleStatus.NEW;
        this.features = Arrays.copyOf(features, features.length);
    }
    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть пустым");
        }
        this.status = newStatus;
    }
    public boolean isReady() {
        return status == SampleStatus.READY;
    }
    public double averageFeature() {
        double sum = 0;
        for (double value : features) {
            sum += value;
        }
        return sum / features.length;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public double[] getFeatures() {
        return Arrays.copyOf(features, features.length);
    }
}
