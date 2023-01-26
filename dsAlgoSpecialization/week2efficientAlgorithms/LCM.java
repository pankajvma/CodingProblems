package dsAlgoSpecialization.week2efficientAlgorithms;

import java.util.*;

public class LCM {
    private static long lcmFast(long a, long b) { 
        return (a * b)/getGCD(a, b);    // lcm(a, b) = |a.b|/gcd(a, b) for LCM calculation
      }

    public static long getGCD(long a, long b) { // Fast algorithm using Euclidean lemma
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcmFast(a, b)); // lcm(a, b) = |a.b|/gcd(a, b) for LCM calculation
    }
}
