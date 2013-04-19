package com.nearinfinity.java8.samples.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilteringWithFunctionExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");

        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        names.stream()
                .filter(startsWithLetter.apply("J"))
                .forEach(System.out::println);
    }
}
