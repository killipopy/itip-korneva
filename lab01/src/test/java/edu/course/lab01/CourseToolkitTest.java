package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    private static final double DELTA = 1e-9;

    // ---------- isEven ----------

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    // ---------- isPrime ----------

    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(1));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(-7));
    }

    @Test
    void isPrimeReturnsTrueForPrimes() {
        assertTrue(CourseToolkit.isPrime(2));
        assertTrue(CourseToolkit.isPrime(3));
        assertTrue(CourseToolkit.isPrime(97));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void isPrimeReturnsFalseForSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(9));
        assertFalse(CourseToolkit.isPrime(49));
    }

    // ---------- isPalindrome ----------

    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome("abba"));
    }

    @Test
    void isPalindromeIsCaseAndSpaceSensitive() {
        // Без учета регистра "Level" был бы палиндромом, без учета пробелов "a ba" тоже.
        assertFalse(CourseToolkit.isPalindrome("Level"));
        assertFalse(CourseToolkit.isPalindrome("a ba"));
    }

    @Test
    void isPalindromeThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // ---------- average ----------

    @Test
    void averageReturnsFractionalResult() {
        int[] values = {1, 2};

        double result = CourseToolkit.average(values);

        assertEquals(1.5, result, DELTA);
        // Входной массив не должен измениться.
        assertArrayEquals(new int[] {1, 2}, values);
    }

    @Test
    void averageWorksWithNegativeValues() {
        double result = CourseToolkit.average(new int[] {-4, -2, 0, 2});

        assertEquals(-1.0, result, DELTA);
    }

    @Test
    void averageThrowsForNullAndEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[0]));
    }

    // ---------- min ----------

    @Test
    void minReturnsSmallestElement() {
        int result = CourseToolkit.min(new int[] {5, 2, 9, 3});

        assertEquals(2, result);
    }

    @Test
    void minThrowsForNullAndEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(new int[0]));
    }

    // ---------- max ----------

    @Test
    void maxWorksWithNegativeValues() {
        int result = CourseToolkit.max(new int[] {-7, -3, -10});

        assertEquals(-3, result);
    }

    @Test
    void maxThrowsForNullAndEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(new int[0]));
    }
}