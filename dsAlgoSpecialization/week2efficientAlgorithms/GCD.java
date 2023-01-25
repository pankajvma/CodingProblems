package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args){
        // Scanner scn = new Scanner(System.in);
        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // scn.close();
        Random rnd = new Random(5);
        // for(int i = 0; i < 10; i++){
            int a = (rnd.nextInt(10)+10)*2;
            int b = (rnd.nextInt(10)+10)*3;
            // System.out.println("GCD of "+ a + " and "+ b +"= "+ getGCD(a, b));
            System.out.println("GCD of "+ a + " and "+ b +"= "+ getGCD(a, b));
        // }
        // int a = rnd.nextInt();
        // int b = rnd.nextInt();
        // System.out.println("GCD of "+ a + "and "+ b +"= "+ getGCD(a, b));
    }

    public static int getGCD(int a, int b){
        int gcd = 0;
        int limit = a < b ? a : b;
        for(int i = 1; i <= limit; i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}
