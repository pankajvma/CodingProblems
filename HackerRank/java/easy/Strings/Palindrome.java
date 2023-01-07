// https://www.hackerrank.com/challenges/java-string-reverse/problem
package hackerrank.java.easy.Strings;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int low = 0;
        int up = A.length()-1;
        boolean isPalin = true;
        while(low < up){
            if(A.charAt(low) != A.charAt(up)){
                isPalin = false;
                break;
            }
            low++;up--;
        }
        if(isPalin) System.out.println("Yes");
        else System.out.println("No");
        /* Enter your code here. Print output to STDOUT. */
        
    }
}