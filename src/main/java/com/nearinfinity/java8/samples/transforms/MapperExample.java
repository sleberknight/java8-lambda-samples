package com.nearinfinity.java8.samples.transforms;

import java.util.Arrays;
import java.util.List;

public class MapperExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .map(value -> value * 2)
                .forEach(System.out::println);
    }
}
