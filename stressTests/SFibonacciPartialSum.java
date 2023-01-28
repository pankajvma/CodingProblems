package stressTests;

import java.util.Random;

public class SFibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) { //Doesn't work well with big values of n
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSumNaiveOpt(long from, long to) {
        int first = 0;
        int second = 1;
        int sum = 0;
        if(to <= 1){
            return to;
        }
        for(int i = 1; i <= to; i++){
            if(i >= from){
                sum += second % 10;
                sum %= 10;
            }
            int temp = second;
            second = (second + first)%10;
            first = temp;
        } return sum;
    }

    private static long getFibonacciSumFast(long n) {
        int first = 0;
        int second = 1;
        int sum = 1;
        if(n <= 1){
            if(n < 0) return 0;
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
            long from = random.nextInt(1000000)+3;
            long to = random.nextInt(1000000)+3;
            if(from < to){
                // long naiveAns = getFibonacciPartialSumNaive(from, to);
                long naiveOpt = getFibonacciPartialSumNaiveOpt(from, to);
                long fastAns = getFibonacciSumFast(to%60) - getFibonacciSumFast((from-1)%60);
                fastAns = fastAns < 0 ? fastAns + 10 : fastAns;
                if(fastAns < 0){
                    fastAns += 10;
                }
                if(naiveOpt == fastAns){
                    System.out.println("OK");
                } else{
                    System.out.println("Failed for given condition\nfrom: "+ from +" to: "+ to +"\nNaive answer = "+ naiveOpt +"\nFast answer = "+ fastAns);
                    System.out.println("Sum till "+to+":" + getFibonacciSumFast(to%60));
                    System.out.println("Sum till "+(from - 1)+":" + getFibonacciSumFast((from-1)%60));
                    break;
                }

                // if(naiveAns == naiveOpt){ //Our Optimized Naive perform better than naive for big values of n.
                //     System.out.println("OK");
                // } else{
                //     System.out.println("Failed for given condition\nfrom: "+ from +" to: "+ to +"\nNaive answer = "+ naiveAns +"\nNaive opt answer = "+ naiveOpt);
                //     break;
                // }
            }
        }
        
    }
}