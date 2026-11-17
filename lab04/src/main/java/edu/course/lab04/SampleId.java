package edu.course.lab04;

import java.util.Objects;

public final class SampleId {
    private final String datasetName;
    private final int observationNumber;

    public SampleId(String datasetName, int observationNumber) {
        this.datasetName = datasetName;
        this.observationNumber = observationNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SampleId)) {
            return false;
        }

        SampleId sampleId = (SampleId) other;
        return observationNumber == sampleId.observationNumber
                && Objects.equals(datasetName, sampleId.datasetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetName, observationNumber);
    }
}