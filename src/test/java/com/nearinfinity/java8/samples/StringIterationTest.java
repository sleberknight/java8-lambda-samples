package com.nearinfinity.java8.samples;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringIterationTest {

    @Test
    public void testIterateStringFilteringByNumbers() {
        String s = "R2D2C3P0";
        List<Character> result = s.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> (char) ch)
                .collect(toList());
        MatcherAssert.assertThat(result, is(Arrays.asList('2', '2', '3', '0')));
    }

    @Test
    public void testIterateStringCollectingIntoList() {
        String s = "Java";
        List<Integer> result = s.chars()
                .boxed()
                .collect(toList());
        MatcherAssert.assertThat(result, is(Arrays.asList((int) 'J', (int) 'a', (int) 'v', (int) 'a')));
    }

}
