package edu.course.lab04;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {
    @Test
    void findsValueUsingAnotherBookWithSameIsbn() {
        Book first = new Book("123", "Основы Java");
        Book second = new Book("123", "Java для начинающих");

        HashMap<Book, String> books = new HashMap<>();
        books.put(first, "На полке");

        assertEquals("На полке", books.get(second));
    }

    @Test
    void booksWithDifferentIsbnAreNotEqual() {
        Book first = new Book("123", "Основы Java");
        Book second = new Book("456", "Основы Java");

        assertNotEquals(first, second);
    }
}