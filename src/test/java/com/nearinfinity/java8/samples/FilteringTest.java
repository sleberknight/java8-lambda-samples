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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilteringTest {

    private List<Integer> _numbers;
    private List<String> _names;

    @Before
    public void setUp() {
        _numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        _names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");
    }

    @Test
    public void testFilter_Simple() {
        Iterator<Integer> iter = _numbers.stream().filter(value -> value % 2 == 0).iterator();
        ArrayList<Integer> evens = Lists.newArrayList(iter);
        MatcherAssert.assertThat(evens, is(Arrays.asList(2, 4, 6, 8, 10)));
    }

    @Test
    public void testFilter_UsingReusablePredicate() {
        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        Iterator<String> jIterator = _names.stream().filter(startsWithLetter.apply("J")).iterator();
        List<String> jNames = Lists.newArrayList(jIterator);
        MatcherAssert.assertThat(jNames, is(Arrays.asList("Jeff", "Jennifer")));
    }

    @Test
    public void testFindFirst_WhenExists() {
        Optional<String> firstS =
                _names.stream().filter(name -> name.startsWith("S")).findFirst();
        MatcherAssert.assertThat(firstS.isPresent(), is(true));
        MatcherAssert.assertThat(firstS.get(), is("Scott"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindFirst_WhenDoesNotExist() {
        Optional<String> firstZ =
                _names.stream().filter(name -> name.startsWith("Z")).findFirst();
        MatcherAssert.assertThat(firstZ.isPresent(), is(false));
        MatcherAssert.assertThat(firstZ.orElse("Nope"), is("Nope"));
        firstZ.get();
    }

}
