// https://www.hackerrank.com/challenges/java-biginteger/problem
package hackerrank.java.easy.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInt {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BigInteger bigNum1 = new BigInteger(scn.nextLine());
        BigInteger bigNum2 = new BigInteger(scn.nextLine());
        System.out.println(bigNum1.add(bigNum2));
        System.out.println(bigNum1.multiply(bigNum2));
        scn.close();
    }
}