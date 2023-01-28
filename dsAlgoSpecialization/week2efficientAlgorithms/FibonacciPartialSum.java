package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class FibonacciPartialSum {
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
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        long fastAns = getFibonacciSumFast(to%60) - getFibonacciSumFast((from-1)%60); // 60 is the Pisano number
        fastAns = fastAns < 0 ? fastAns + 10 : fastAns;
        System.out.println(fastAns);
    }
}