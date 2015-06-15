package org.rhseeger.euler;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Integer[][] input = new Integer[][] {
                new Integer[] {75},
                new Integer[] {95, 64},
                new Integer[] {17, 47, 82},
                new Integer[] {18, 35, 87, 10},
                new Integer[] {20,  4, 82, 47, 65},
                new Integer[] {19,  1, 23, 75,  3, 34},
                new Integer[] {88,  2, 77, 73,  7, 63, 67},
                new Integer[] {99, 65,  4, 28,  6, 16, 70, 92},
                new Integer[] {41, 41, 26, 56, 83, 40, 80, 70, 33},
                new Integer[] {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                new Integer[] {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                new Integer[] {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                new Integer[] {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                new Integer[] {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                new Integer[] { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
        };
        System.out.println(solve(
                Arrays.copyOfRange(input, 0, input.length-1),
                input[input.length-1]));
    }

    /**
     *
     * @param inputArray - all rows but the last of the pyramid
     * @param lastRow - the last row of the pyramid
     * @return
     */
    static int solve(Integer[][] inputArray, Integer[] lastRow) {
        // If there's no inputArray left, then lastRow has only one element... the answer
        if(inputArray.length == 0) {
            return lastRow[0];
        }

        // Calculate an array of the maximums of each pair for the lastRow
        Integer maxRow[] = zip(
                Arrays.copyOfRange(lastRow, 0, lastRow.length-1),
                Arrays.copyOfRange(lastRow, 1, lastRow.length),
                (v1,v2) -> Math.max(v1,v2));
        // Calculate a new lastRow by adding the maximums to the last row of the inputArray
        Integer newLastRow[] = zip(inputArray[inputArray.length-1], maxRow, (v1,v2) -> v1+v2);

        // And, recursively call solve with the pyramid (minus it's last row) and the new last row
        return solve(Arrays.copyOfRange(inputArray, 0, inputArray.length-1), newLastRow);

        /** Or, as a "one liner"
        return solve(Arrays.copyOfRange(inputArray, 0, inputArray.length-1),
                     zip(inputArray[inputArray.length-1],                        // calculate the sums (the new last row)
                         zip(Arrays.copyOfRange(lastRow, 0, lastRow.length-1),   // calculate the maxes of the last row
                             Arrays.copyOfRange(lastRow, 1, lastRow.length),
                             (v1,v2) -> Math.max(v1,v2)),
                         (v1,v2) -> v1+v2));
         */
    }

    /**
     * An Integer specific version of zip, because Java8 left zip out... wtf
     * @param v1
     * @param v2
     * @param zipper
     * @return
     */
    static Integer[] zip(Integer[] v1, Integer[] v2, BiFunction<Integer, Integer, Integer> zipper) {
        assert(v1.length == v2.length);
        Integer[] result = new Integer[v1.length];
        for(int i=0; i<v1.length; i++) {
            result[i] = zipper.apply(v1[i], v2[i]);
        }
        return result;
    }

}
