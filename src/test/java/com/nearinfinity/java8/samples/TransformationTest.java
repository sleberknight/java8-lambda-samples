package com.nearinfinity.java8.samples;

import static org.hamcrest.CoreMatchers.is;

import com.google.common.collect.Lists;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TransformationTest {

    private List<Integer> _numbers;
    private List<String> _fruits;

    @Before
    public void setUp() {
        _numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        _fruits = Arrays.asList("apple", "orange", "pear", "banana", "guava", "clementine");
    }

    @Test
    public void testForEachTransformation() {
        List<Integer> doubledNumbers = new ArrayList<>();
        _numbers.forEach(value -> doubledNumbers.add(value * 2));
        assertDoubledNumbers(doubledNumbers);
    }

    @Test
    public void testMappingTransformation() {
        Iterator <Integer> iter = _numbers.stream().map(value -> value * 2).iterator();
        List<Integer> doubledNumbers = Lists.newArrayList(iter);
        assertDoubledNumbers(doubledNumbers);
    }

    @Test
    public void testMappingTransformation_UsingMethodReference() {
        Iterator<String> iter = _fruits.stream().map(String::toUpperCase).iterator();
        List<String> upCaseFruits = Lists.newArrayList(iter);
        MatcherAssert.assertThat(upCaseFruits, is(Arrays.asList("APPLE", "ORANGE", "PEAR", "BANANA", "GUAVA", "CLEMENTINE")));
    }

    private void assertDoubledNumbers(List<Integer> doubledNumbers) {
        MatcherAssert.assertThat(doubledNumbers, is(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)));
    }

}
