package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {
    @Test
    void worksWithNoDiscount() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calc.calculate(100.0), 1e-9);
    }

    @Test
    void worksWithPercentDiscount() {
        PriceCalculator calc = new PriceCalculator(new PercentDiscount(20));
        assertEquals(80.0, calc.calculate(100.0), 1e-9);
    }

    @Test
    void rejectsNegativePrice() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-1.0));
    }
}