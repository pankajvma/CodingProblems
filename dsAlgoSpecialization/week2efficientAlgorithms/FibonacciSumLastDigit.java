package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class FibonacciSumLastDigit {
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
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n%60); // Since 60 is the pisano period for 10
        System.out.println(s);
    }
}

