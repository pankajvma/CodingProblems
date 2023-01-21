// https://www.hackerrank.com/challenges/quicksort1/problem
package hackerrank.problemSolving.easy.algorithms.sorting.quick;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> quickSort(List<Integer> arr) {
        int pivot = arr.get(0);
        int temp;
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) < pivot){
                temp = arr.get(i);
                for(int ind = i; ind > 0; ind--){
                    arr.set(ind, arr.get(ind - 1));
                }
                arr.set(0, temp);
            }
        }
        return arr;
    }

}

public class Quicksort1Partition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

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