package stressTests;

import java.util.Random;

public class SFibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) { // start returning negative sums for values of n > 90
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = tmpPrevious + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        int first = 0;
        int second = 1;
        int sum = 1;
        if(n <= 1){
            return n;
        }
        for(int i = 2; i <= n; i++){
            int temp = second;
            second = (second + first)%10;
            first = temp;
            sum += second % 10;
            sum %= 10;
        } return sum;
    }

 
    public static void main(String[] args) {
        Random random = new Random(5);
        while(true){
            long n = Math.abs(random.nextInt(10000000));
            long sNaive = getFibonacciSumFast(n);
            long sFast = getFibonacciSumFast(n%60); //Since 60 is the pisano period for 10
            if(sFast == sNaive){
                System.out.println("OK");
            } else {
                System.out.println("Failed for n= "+ n +" Naive solution returned: "+sNaive+"\nSFast solution returned: "+ sFast);
                break;
            }
        }  
    }
}