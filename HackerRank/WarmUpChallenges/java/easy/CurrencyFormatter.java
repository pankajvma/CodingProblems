// https://www.hackerrank.com/challenges/java-currency-formatter/problem
package hackerrank.warmupChallenges.java.easy;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        final Locale INDIA = new Locale("en", "in");
        NumberFormat us = NumberFormat.getCurrencyInstance();
        NumberFormat india = NumberFormat.getCurrencyInstance(INDIA);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}