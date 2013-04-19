package com.nearinfinity.java8.samples;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringJoinerTest {

    private List<String> _fruits;

    @Before
    public void setUp() {
        _fruits = Arrays.asList("Apple", "Orange", "Banana", "Guava");
    }

    @Test
    public void testStringJoin() {
        assertThat(String.join(", ", _fruits), is("Apple, Orange, Banana, Guava"));
    }

    @Test
    public void testToStringJoiner() {
        StringJoiner joiner = _fruits.stream().map(String::toUpperCase).collect(Collectors.toStringJoiner(", "));
        String upperCasedFruits = joiner.toString();
        assertThat(upperCasedFruits, is("APPLE, ORANGE, BANANA, GUAVA"));
    }
}
