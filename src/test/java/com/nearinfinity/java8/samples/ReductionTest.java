package com.nearinfinity.java8.samples;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;

public class ReductionTest {

    private List<Integer> _numbers;
    private List<String> _names;

    @Before
    public void setUp() {
        _numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        _names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");
    }

    @Test
    public void testSumOfSquaresReducer() {
        MatcherAssert.assertThat(_numbers.stream().mapToInt(value -> value * value).sum(), is(385));
    }

    @Test
    public void testAverageOfSquaresReducer() {
        OptionalDouble result = _numbers.stream().mapToDouble(value -> value * value).average();
        MatcherAssert.assertThat(result.orElse(-1.0), is(38.5));
    }

    @Test
    public void testFindLongestNameReducer() {
        Optional<String> longestName = _names.stream().reduce((name1, name2) ->
                name1.length() >= name2.length() ? name1 : name2);
        MatcherAssert.assertThat(longestName.orElse("Alexa"), is("Jennifer"));
    }

    @Test
    public void testReducingNamesWithToStringJoinerCollector() {
        String joinedLowerCaseNames = _names.stream().map(String::toLowerCase).collect(joining(", "));
        MatcherAssert.assertThat(joinedLowerCaseNames, is("bob, tom, jeff, scott, jennifer, steve"));
    }

    @Test
    public void testGreetEachNameAndCollectIntoNewList() {
        List<String> greetings = _names.stream()
                .map(name -> "Hello " + name)
                .collect(toList());
        MatcherAssert.assertThat(greetings, is(Arrays.asList(
                "Hello Bob", "Hello Tom", "Hello Jeff", "Hello Scott", "Hello Jennifer", "Hello Steve")));
    }

    @Test
    public void testDoublingNumbersAndTurningIntoArray() {
        Integer[] doubled = _numbers.stream()
                .map(value -> value * 2)
                .toArray(Integer[]::new);
        MatcherAssert.assertThat(doubled, is(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}));
    }

    /**
     * From Venkat, the overloaded map() method in Stream causes some issues dealing with
     * casts. One way to avoid this is to declare a Function separately and pass that to
     * map().
     */
    @Test
    public void testDoublingNumbersAndCollectingIntoList_UsingSeparateFunctionForMap() {
        Function<Integer, Integer> lambda = value -> value * 2;
        List<Integer> doubled = _numbers.stream()
                .map(lambda)
                .collect(toList());
        MatcherAssert.assertThat(doubled, is(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)));
    }

    /**
     * Venkat's second tip is, instead of having a separate Function object for the lambda,
     * to use the boxed() method to convert from IntStream back to Stream, from which we
     * can then call collect(toList()) without issue.
     * <p>
     * UPDATE 2020-10-16: This tip is no longer necessary in the final JDK 8 version.
     */
    @Test
    public void testDoublingNumbersAndCollectingIntoList_UsingBoxedMethodFromIntStream() {
        List<Integer> doubled = _numbers.stream()
                .map(value -> value * 2)
//                .boxed()
                .collect(toList());
        MatcherAssert.assertThat(doubled, is(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)));
    }

    @Test
    public void testFilteringEvenNumbersAndCollectingIntoList() {
        List<Integer> evens = _numbers.stream()
                .filter(value -> value % 2 == 0)
                .collect(toList());
        MatcherAssert.assertThat(evens, is(Arrays.asList(2, 4, 6, 8, 10)));
    }
}
