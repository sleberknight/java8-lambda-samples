package com.nearinfinity.java8.samples.iteration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForEachUntilExample {
    /**
     * Tests using the forEachUntil. Since BooleanSupplier's getAsBoolean() method has no argument,
     * and if you want to stop the iteration based on something related to the values in the stream,
     * then you need some way to get at the state. I used an AtomicBoolean to do this, and unfortunately
     * it is defined outside the outside lamdba expression because I could not see a better way to do
     * it. So not exactly pretty, but it does work.
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AtomicBoolean stopCondition = new AtomicBoolean(false);
        numbers.stream().forEachUntil(value -> {
            System.out.println(value);
            if (value >= 6) stopCondition.set(true);
        }, () -> stopCondition.get());
    }
}
