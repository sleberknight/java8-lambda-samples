package com.nearinfinity.java8.samples.reducers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LongestNameReducerExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Tom", "Jeff", "Scott", "Jennifer", "Steve");

        Optional<String> longestName = names.stream().reduce((name1, name2) ->
                name1.length() >= name2.length() ? name1 : name2);
        if (longestName.isPresent()) {
            System.out.println(longestName.get());
        } else {
            System.out.println("WTF?");
        }
    }
}
