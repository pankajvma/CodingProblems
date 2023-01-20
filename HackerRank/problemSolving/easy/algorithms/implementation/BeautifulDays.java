// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
package hackerrank.problemSolving.easy.algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    public static int reverse(int i){
        int reverse = 0;
        while(i != 0){
            reverse = (reverse * 10 + i % 10);
            i /= 10;
        }
        return reverse;
    }

    public static int beautifulDays(int i, int j, int k) {
        int countBeautifulDays = 0;
        for(int date = i; date <= j; date++){
            if(Math.abs(date - reverse(date)) % k ==0){
                countBeautifulDays++;
            }
        }
        return countBeautifulDays;
    }

}

public class BeautifulDays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
