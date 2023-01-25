package stressTests;

import java.util.Scanner;

public class SFibonacci {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        long start = System.nanoTime();
        fib(a);
        System.out.println("Time taken by iterative solution: " + (System.nanoTime() - start));
        start = System.nanoTime();
        getFibRecursive(a);
        System.out.println("Time taken by recursive solution: " + (System.nanoTime() - start));
    }

    public static void fib(int a){
        long first = 0;
        long second = 1;
        // for(int i = 0; i <= second; i++){
            // System.out.print(i+" ");
        // }
        for(int i = 2; i <= a; i++){
            long temp = second;
            second = second + first;
            first = temp;
            System.out.print(second+" ");
        } System.out.println(second);
    }

    public static void getFibRecursive(int a){
        System.out.println(fibRecursive(a)+" ");
        // for(int i = 0; i <= a; i++){
        //     long start = System.currentTimeMillis();
        //     // fibRecursive(i);
        //     System.out.print(fibRecursive(i)+" ");
        //     // System.out.println(i+ " " + (System.currentTimeMillis() - start));
        // }
    }

    public static long fibRecursive(long a){
        if(a <= 1){
            return a;
        } return fibRecursive(a - 1) + fibRecursive(a - 2);
    }
}