// https://www.hackerrank.com/challenges/java-end-of-file/problem
package hackerrank.warmupChallenges.java.easy;

import java.util.Scanner;

public class JavaEndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = new String();
        int count = 0;
        while(scn.hasNext()){
            count++;
            str += count+" "+scn.nextLine()+"\n";
        }
        System.out.println(str);
    }
}