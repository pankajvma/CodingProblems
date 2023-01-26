package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class FibonacciHuge {
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
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long pisano = getPisano(n, m);
        long ans = n == 1 ? 1 : getFibonacciHugeWithPisano(n%pisano, m);
        System.out.println(ans);
    }
}

