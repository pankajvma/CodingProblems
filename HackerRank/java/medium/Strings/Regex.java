// https://www.hackerrank.com/challenges/java-regex/problem
package hackerrank.java.medium.Strings;

import java.util.Scanner;

public class Regex {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex{
    String ipDigitPattern = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    String pattern = ipDigitPattern + "[.]" + ipDigitPattern + "[.]" + ipDigitPattern + "[.]" + ipDigitPattern ;

    /* Explaining above ipDigitPattern
    #1. \d{1,2} -------> Any 2 digit number
    #2. | -------------> OR
    #3. (0|1)\\d{2} ---> 0 or 1 followed by any 2 digit number
    #4. | -------------> OR
    #5. 2[0-4]\\d -----> 2 followed by a number between 0 to 4(inclusive), folowed by any one digit number (To handle numbers between 200 to 249)
    #6. | -------------> OR
    #7. 25[0-5]  ------> 25 followed by a number between 0 to 5. (To handle numbers between 250 to 255)
    #8. Enclose #1 to #7 within () to group them in a single regex statement since we have to use it with [.] to create the full pattern

    Explaining pattern
    Utilizing ipDigitPattern and using it with [.] to create the full pattern
     */
    
}