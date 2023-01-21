// https://www.hackerrank.com/challenges/runningtime/problem
package hackerrank.problemSolving.easy.algorithms.sorting.insertion;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int runningTime(List<Integer> A) {
        int count = 0;
            for(int i = 1; i < A.size(); i++){ // insertion sort
                int value = A.get(i);
                int j = i - 1;
                while(j >= 0 && A.get(j) > value){
                    A.set(j + 1, A.get(j));
                    j = j - 1;
                    count++;            // counting number of shifts
                }
                A.set(j + 1, value);
            }
        return count;
    }

}

public class RunTime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
