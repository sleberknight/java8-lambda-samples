package com.nearinfinity.java8.samples;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinerTest {

    private List<String> _fruits;

    @Before
    public void setUp() {
        _fruits = Arrays.asList("Apple", "Orange", "Banana", "Guava");
    }

    @Test
    public void testStringJoin() {
        MatcherAssert.assertThat(String.join(", ", _fruits), is("Apple, Orange, Banana, Guava"));
    }

    @Test
    public void testToStringJoiner() {
        String upperCasedFruits = _fruits.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        MatcherAssert.assertThat(upperCasedFruits, is("APPLE, ORANGE, BANANA, GUAVA"));
    }
}
