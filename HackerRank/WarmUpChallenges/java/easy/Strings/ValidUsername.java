// https://www.hackerrank.com/challenges/valid-username-checker/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;

public class ValidUsername {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}

class UsernameValidator {

    public static final String regularExpression = "[a-zA-Z]([a-zA-Z]|[0-9]|_){7,29}";

    /* Explaining above regularExpression
    #1. [a-zA-Z] ------------> Should start with Any upper or lower case letter
    #2. ([a-zA-Z]|[0-9]|_) --> Followed by any upper case or lower case letter or any digit or _
    #3. {7,29} --------------> Prethe preceeding token i. e. #2 should have a length between 7-29
    #4. Since we are already taking step1 into consideration we have specified the length as 7-29 in #3
     */
}
