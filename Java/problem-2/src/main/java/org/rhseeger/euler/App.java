package org.rhseeger.euler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        int sum = 0;
        int current = 1;
        int last = 1;
        while ( current <= 4000000 ) {
            if ( current % 2 == 0 ) {
                sum += current;
            }
            int newValue = current + last;
            last = current;
            current = newValue;
        }
        System.out.println(sum);
    }
}
