// https://www.hackerrank.com/challenges/big-sorting/problem
package hackerrank.problemSolving.easy.algorithms.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<String> bigSorting(List<String> unsorted) {
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String b1, String b2){
                // This is the optimized code, We tried to use BigInteger's compareTo() for comparing Big Numbers.
                // However, that gave TLE for some cases. Hence, We optimized the code by overriding compare() further as per our need.
                if(b1.equals(b2)){
                    return 0;
                } else if(b1.length() < b2.length()){
                    return -1;
                } else if(b1.length() > b2.length()){
                    return 1;
                }
                return b1.compareTo(b2);
            }
        };
        unsorted.sort(comparator);
        List<String> sorted = unsorted; // unsorted is now sorted :)
        return sorted;
    }
}

public class SortBigInt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}