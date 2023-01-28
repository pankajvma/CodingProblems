package stressTests;

import java.util.Random;

public class SFibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) { // this function starts returning -ve values of fibb(n)^2 for n > 46
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long square = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = tmpPrevious + current;
            square += current * current;
        }

        return square%10;
    }

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
        Random random = new Random(5);
        while(true){
            long n = random.nextInt(10000000)+3;
            // long naiveSumSquare = getFibonacciSumSquaresNaive(n);
            long naiveSumSquare = getFibonacciSumSquaresNaiveOpt(n);
            long naiveSumSquareOpt = getFibonacciSumSquaresNaiveOpt(n%60); //60 is the pisano period for 10
            if(naiveSumSquare ==  naiveSumSquareOpt){
                System.out.println("OK");
            } else{
                System.out.println("Failed for n = "+n);
                System.out.println("Naive returned: "+ naiveSumSquare +"\nOptimized Naive returned: "+naiveSumSquareOpt);
                break;
            }
        }
        
    }
}