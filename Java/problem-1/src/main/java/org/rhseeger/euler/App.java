package org.rhseeger.euler;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println(IntStream.range(1, 1000)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .sum());
    }
}
