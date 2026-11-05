package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PercentDiscountTest {
    @Test
    void twentyPercentOfHundredIsEighty() {
        assertEquals(80.0, new PercentDiscount(20).apply(100.0), 1e-9);
    }

    @Test
    void zeroPercentLeavesPrice() {
        assertEquals(100.0, new PercentDiscount(0).apply(100.0), 1e-9);
    }

    @Test
    void rejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }
}