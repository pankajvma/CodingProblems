// https://www.hackerrank.com/challenges/extra-long-factorials/problem
package hackerrank.problemSolving.medium.algorithms.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.math.BigInteger;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void extraLongFactorials(int n) {
        BigInteger bigFactorial = new BigInteger("1");
        for(int i = 2; i <= n; i++){
            bigFactorial = bigFactorial.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println(bigFactorial);
    }

}

public class ExtraLongFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
