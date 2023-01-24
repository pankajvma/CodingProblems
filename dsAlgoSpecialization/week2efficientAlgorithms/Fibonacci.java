package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        for(int i = 0; i <= a; i++){
            System.out.println(fibRecursive(i));
        }
    }

    public static int fibRecursive(int a){
        if(a <= 1){
            return a;
        } return fibRecursive(a - 1) + fibRecursive(a - 2);
    }
}