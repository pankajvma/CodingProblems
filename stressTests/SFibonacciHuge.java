package stressTests;

import java.util.Random;

public class SFibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) { // doesn't work for very huge number since fib(80+) goes out of long range
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = tmpPrevious + current;
        }

        return current % m;
    }

    private static long getFibonacciHugeFast(long n, int m) { // slow when it comes to huge numbers
        int first = 0;
        int second = 1;
        if(n <= 1){
            return n;
        }
        for(int i = 2; i <= n; i++){
            int temp = second;
            second = (second + first)%m;
            first = temp;
        } return second;
    }

    private static long getPisano(long n, long m) {
        long first = 0;
        long second = 1;
        long count = 0;

        if(n <= 1){
            return n;
        }
        count = 1;
        while(true){
            long temp = second;
            second = (second + first)%m;
            first = temp;
            if(second == 1 && first == 0){
                break;
            }
            count++;
        }
        return count;
    }

    public static long getFibonacciHugeWithPisano(long a, long m){
        long first = 0;
        long second = 1;
        if(a <= 1){
            return a;
        }
        for(int i = 2; i <= a; i++){
            long temp = second;
            second = (second + first)%m;
            first = temp;
        } return second;
    }
    
    public static void main(String[] args) {
        Random random = new Random(5);
        while(true){
            long n = random.nextInt(100000);
            int m = random.nextInt(1000)+1;
            long pisano = getPisano(n, m);
            long ansNaive = getFibonacciHugeWithPisano(n%pisano, m);
            long ansFast = getFibonacciHugeFast(n, m);
            if(ansNaive == ansFast){
                System.out.println("OK");
            } else{
                System.out.println("Failed for n: "+ n +" and m: "+ m +"\nNaive: "+ ansNaive +", Fast: "+ ansFast);
                break;
            }
        }
    }
}

