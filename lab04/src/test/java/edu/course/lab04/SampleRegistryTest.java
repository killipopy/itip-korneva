package edu.course.lab04;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleRegistryTest {
    @Test
    void findsAndRemovesSampleUsingEqualKey() {
        SampleRegistry registry = new SampleRegistry();
        SampleId first = new SampleId("flowers", 7);
        SampleId second = new SampleId("flowers", 7);
        DataSample sample = new DataSample(2.5);

        registry.put(first, sample);

        assertTrue(registry.containsKey(second));
        assertSame(sample, registry.get(second));
        assertEquals(1, registry.size());
        assertSame(sample, registry.remove(second));
        assertFalse(registry.containsKey(first));
        assertNull(registry.get(first));
        assertEquals(0, registry.size());
    }

    @Test
    void replacesSampleWithoutIncreasingSize() {
        SampleRegistry registry = new SampleRegistry();
        SampleId first = new SampleId("flowers", 7);
        SampleId second = new SampleId("flowers", 7);
        DataSample replacement = new DataSample(4.0);

        registry.put(first, new DataSample(2.5));
        registry.put(second, replacement);

        assertSame(replacement, registry.get(first));
        assertEquals(1, registry.size());
    }

    @Test
    void storesDifferentKeysWithSameHashCode() {
        SampleRegistry registry = new SampleRegistry();
        SampleId first = new SampleId("Aa", 7);
        SampleId second = new SampleId("BB", 7);
        DataSample firstSample = new DataSample(2.5);
        DataSample secondSample = new DataSample(4.0);

        assertNotEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());

        registry.put(first, firstSample);
        registry.put(second, secondSample);

        assertSame(firstSample, registry.get(first));
        assertSame(secondSample, registry.get(second));
        assertEquals(2, registry.size());
    }

    @Test
    void keyIsDifferentFromNullAndOtherTypes() {
        SampleId id = new SampleId("flowers", 7);

        assertFalse(id.equals(null));
        assertFalse(id.equals("flowers"));
    }

    @Test
    void changingMutableKeyBreaksLookup() {
        HashMap<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey();
        key.number = 1;

        map.put(key, "Наблюдение");
        assertEquals("Наблюдение", map.get(key));

        key.number = 2;

        assertNull(map.get(key));
        assertEquals(1, map.size());
    }

    private static final class MutableKey {
        private int number;

        @Override
        public boolean equals(Object other) {
            return other instanceof MutableKey
                    && number == ((MutableKey) other).number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}