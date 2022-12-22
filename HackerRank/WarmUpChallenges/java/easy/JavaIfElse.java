// https://www.hackerrank.com/challenges/java-if-else/problem
package hackerrank.warmupChallenges.java.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JavaIfElse {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static ArrayList<Integer> createList(int inclusiveStart, int inclusiveEnd){
        ArrayList startToEnd = new ArrayList<Integer>();
        for(int i = inclusiveStart; i <= inclusiveEnd; i++){
            startToEnd.add(i);
        }
        return startToEnd;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList sixToTwenty = createList(6, 20);
        ArrayList twoToFive = createList(2, 5);
        if(n%2 != 0 || (n%2 == 0 && sixToTwenty.contains(n) )){
            System.out.print("Weird");
        }
        else System.out.print("Not Weird");
        scanner.close();
    }
}
