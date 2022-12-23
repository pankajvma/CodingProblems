// https://www.hackerrank.com/challenges/java-strings-introduction/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;

public class StringsIntroduction {

    public static String properCase(String charSequence){
        return Character.toUpperCase(charSequence.charAt(0))+charSequence.substring(1);
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length()+B.length());
        if(A.compareTo(B) > 0){             //For comparing Strings lexicographically
            System.out.println("Yes");
        }else System.out.println("No");
        System.out.println(properCase(A)+" "+properCase(B));
        
        
    }
}