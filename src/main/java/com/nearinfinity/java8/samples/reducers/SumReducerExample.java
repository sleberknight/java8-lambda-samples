package com.nearinfinity.java8.samples.reducers;

import java.util.Arrays;
import java.util.List;

public class SumReducerExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long sum = numbers.stream().mapToLong(value -> value * value).sum();
        System.out.println("sum = " + sum);
    }
}
