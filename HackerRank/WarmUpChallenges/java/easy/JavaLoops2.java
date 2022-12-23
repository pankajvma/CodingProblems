// https://www.hackerrank.com/challenges/java-loops/problem
package hackerrank.warmupChallenges.java.easy;

import java.util.*;
import java.lang.Math;

public class JavaLoops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.println(getSeries(a, b, n));
        }
        in.close();
    }
    public static String getSeries(int a, int b, int n){
        int result = a+b;
        String series = Integer.toString(result);
        for(int i = 1; i < n; i++){
            result += Math.pow(2,i)*b;
            series += " "+result;
        }
        return series;
    }
}