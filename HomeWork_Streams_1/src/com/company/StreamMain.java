package com.company;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> streamArrayList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        Stream<Integer> stream = streamArrayList.stream().filter(x -> x > 0).
                filter(x -> x % 2 == 0).
                sorted(Comparator.naturalOrder());
        stream.forEach(x -> System.out.print(x + " "));
    }

}
