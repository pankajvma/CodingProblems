// https://www.hackerrank.com/challenges/countingsort1/problem
package hackerrank.problemSolving.easy.algorithms.sorting.counting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> countingList = new ArrayList<>(100);
        for(int i = 0; i < 100; i++){
            countingList.add(0);
        }
        for(int i = 0; i < arr.size(); i++){
            int index = arr.get(i);
            int value = countingList.get(index);
            countingList.set(index, value + 1);
        }

        // Below code will print an index as many times as it appeared in the List
        // for(int i = 0; i < 100; i++){
        //     int temp = countingList.get(i);
        //     while(temp > 0){
        //         System.out.println(i);
        //         temp--;
        //     }
        // }
        return countingList;
    }

}

public class CounitngSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.countingSort(arr);

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
