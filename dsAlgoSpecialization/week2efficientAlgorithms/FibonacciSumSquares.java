package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaiveOpt(long n) { // better performing naive
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long square = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = (tmpPrevious + current)%10;
            square += (current * current) % 10;
            square %= 10;
        }

        return square;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSumSquaresNaiveOpt(n%60)); //60 is the pisano period for 10
    }
}