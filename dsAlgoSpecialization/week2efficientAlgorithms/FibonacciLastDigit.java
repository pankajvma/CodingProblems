package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int a) {
        int first = 0;
        int second = 1;
        if(a <= 1){
            return a;
        }
        for(int i = 2; i <= a; i++){
            int temp = second;
            second = (second + first)%10;
            first = temp;
        } return second;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

