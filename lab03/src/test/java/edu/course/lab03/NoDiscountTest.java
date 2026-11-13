package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NoDiscountTest {
    @Test
    void returnsSamePrice() {
        assertEquals(100.0, new NoDiscount().apply(100.0), 1e-9);
    }

    @Test
    void zeroStaysZero() {
        assertEquals(0.0, new NoDiscount().apply(0.0), 1e-9);
    }
}