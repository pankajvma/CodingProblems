// https://www.hackerrank.com/challenges/java-string-compare/problem
package hackerrank.warmupChallenges.java.easy.Strings;

import java.util.Scanner;

public class SubstringComparision {

    public static String getSmallestAndLargest(String s, int k) {
        // String smallest = "";
        // String largest = "";
        int low = 0;
        int up = k;
        String smallest = s.substring(low, up); // it is good to assign some initial value especially for smallest
        String largest = s.substring(low, up);

        while(up <= s.length()){        //the upper range is exclusive while creating substring hence, we shall take <=
            if(s.substring(low, up).compareTo(largest)>0){
                largest = s.substring(low, up);
            }
            if(s.substring(low, up).compareTo(smallest)<0){
                        smallest = s.substring(low, up);
            }
            low++;up++;
        }
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}