// https://www.hackerrank.com/challenges/closest-numbers/problem
package hackerrank.problemSolving.easy.algorithms.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        int minAbsDiff = 10000000;
        List<Integer> minAbsDiffList = new ArrayList<>();
        for(int i = 0; i < arr.size() - 1; i++){
            int absDiff = Math.abs(arr.get(i) - arr.get(i + 1));
            if(absDiff < minAbsDiff){
                minAbsDiff = absDiff;
            }
        }
        System.out.println(minAbsDiff);
        for(int i = 0; i < arr.size() - 1; i++){
            int absDiff = Math.abs(arr.get(i) - arr.get(i + 1));
            if(absDiff == minAbsDiff){
                minAbsDiffList.add(arr.get(i));
                minAbsDiffList.add(arr.get(i + 1));
            }
        } 
        return minAbsDiffList;
    }

}

public class ClosestNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
