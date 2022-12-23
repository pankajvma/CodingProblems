
// https://www.hackerrank.com/challenges/java-loops-i/problem
package hackerrank.warmupChallenges.java.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaLoops1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();
        for(int i =1; i <= 10; i++){
            System.out.printf("%d x %d = %s\n",N,i,N*i);
        }
    }
}
