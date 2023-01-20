// https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
package hackerrank.problemSolving.easy.algorithms.implementation;

import java.io.*;
import java.util.*;

class Result {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int i = 0;
        int j = 1;
        int count = 0;
        while(i < n - 1){
            if((ar.get(i) + ar.get(j)) % k == 0 ){
                count++;
            }
            j++;
            if(j == n){
                i++;
                j = i + 1;
            }
        }
        return count;
    }

}

public class DivisibleSumPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
