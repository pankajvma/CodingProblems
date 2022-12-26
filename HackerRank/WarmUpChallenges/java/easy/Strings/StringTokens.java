
// https://www.hackerrank.com/challenges/java-string-tokens/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.trim().length() == 0){  //To check empty string
            System.out.println(0);
        } else{
            String[] sArr = s.trim().split("[ !,?._'@]+"); //trimming the string to remove trailing spaces
            System.out.println(sArr.length);
            for(Object obj : sArr)
                System.out.println(obj);
        }
        // Write your code here.
        scan.close();
    }
}
