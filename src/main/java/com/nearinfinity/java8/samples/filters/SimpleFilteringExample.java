package com.nearinfinity.java8.samples.filters;

import java.util.Arrays;
import java.util.List;

public class SimpleFilteringExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);
    }
}
