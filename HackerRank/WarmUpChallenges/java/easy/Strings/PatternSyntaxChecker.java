// https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while(testCases>0){
        String pattern = in.nextLine();
        try{
            Pattern.compile(pattern);
            System.out.println("Valid");
        } catch(PatternSyntaxException ex){
            System.out.println("Invalid");
        }
        testCases--;
          //Write your code
    }
}
