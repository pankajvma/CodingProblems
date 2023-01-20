// https://www.hackerrank.com/challenges/strange-advertising/problem
package hackerrank.problemSolving.easy.algorithms.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int viralAdvertising(int n) {
        int seed = 5;
        int liked = 0;
        int totalLiked = 0;
        for(int i = 0; i < n; i++){
            liked = (int)(seed/2);
            seed = liked * 3;
            totalLiked += liked;
        } return totalLiked;
    }

}

public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
