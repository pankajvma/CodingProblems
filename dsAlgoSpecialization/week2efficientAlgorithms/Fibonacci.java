package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        System.out.println(fib(a));
    }

    public static long fib(int a){
        long first = 0;
        long second = 1;
        if(a <= 1){
            return a;
        }
        for(int i = 2; i <= a; i++){
            long temp = second;
            second = second + first;
            first = temp;
        } return second;
    }
}