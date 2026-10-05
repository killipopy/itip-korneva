package edu.course.lab01;


public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }


    public static boolean isEven(int number) {
        return number % 2 == 0;
    }


    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        // Приведение к long нужно, чтобы divisor * divisor не переполнил int
        // для больших чисел
        for (int divisor = 2; (long) divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть null");
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static double average(int[] values) {
        requireNotEmpty(values);
        // long, чтобы сумма не переполнилась на больших значениях
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        // Приведение к double обязательно, иначе деление было бы целочисленным
        return (double) sum / values.length;
    }

    public static int min(int[] values) {
        requireNotEmpty(values);
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < result) {
                result = values[i];
            }
        }
        return result;
    }


    public static int max(int[] values) {
        requireNotEmpty(values);
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > result) {
                result = values[i];
            }
        }
        return result;
    }

    private static void requireNotEmpty(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Значение не может быть null или пустым");
        }
    }
}