package com.nearinfinity.java8.samples.streams;

import java.util.stream.Streams;

public class StreamsExample {

    // See Venkat's blog for the origin of this example:
    // http://blog.agiledeveloper.com/2013/01/functional-programming-in-java-is-quite.html
    public static void main(String[] args) {
        Streams.iterate(1, number -> number + 1)
                .map(number -> number * number)
                .limit(25)
                .forEach(number -> System.out.print(number + " "));
    }

}
