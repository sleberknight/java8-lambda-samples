package com.nearinfinity.java8.samples.iteration;

public class ForEachUntilExample {
    /**
     * Tests using the forEachUntil. Since BooleanSupplier's getAsBoolean() method has no argument,
     * and if you want to stop the iteration based on something related to the values in the stream,
     * then you need some way to get at the state. I used an AtomicBoolean to do this, and unfortunately
     * it is defined outside the outside lamdba expression because I could not see a better way to do
     * it. So not exactly pretty, but it does work.
     * <p>
     * UPDATE 2020-10-16: forEachUntil did not make it into the final JDK 8 version, so the original code
     * for this example will not compile. It is commented out below. And JDK 8 does not have any other way
     * to do this cleanly that I am aware of. JDK 9 added a takeWhile which provides a more elegant solution
     * which is show below commented out.
     */
    public static void main(String[] args) {
        System.out.println("This example no longer works in the final JDK 8");

        // Original code that worked prior to the JDK 8 final version
/*
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AtomicBoolean stopCondition = new AtomicBoolean(false);
        numbers.stream().forEachUntil(value -> {
            System.out.println(value);
            if (value >= 6) stopCondition.set(true);
        }, stopCondition::get);
*/

        // Here is the JDK 9 solution using takeWhile:
/*
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .takeWhile(value -> value <= 6)
                .forEach(integer -> System.out.println(integer));
*/
    }
}
