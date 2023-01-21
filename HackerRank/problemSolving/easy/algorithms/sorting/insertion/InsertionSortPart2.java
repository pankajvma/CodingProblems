// https://www.hackerrank.com/challenges/insertionsort2/proble/m
package hackerrank.problemSolving.easy.algorithms.sorting.insertion;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void printList(int n, List<Integer> arr){
        System.out.print(arr.get(0));
        for(int j = 1; j < n; j++){
            System.out.print(" "+ arr.get(j));
        } System.out.println();
    }

    public static void insertionSort2(int n, List<Integer> arr) { //modifies method insertionSort1 from InsertionSortPart1
        for(int index = 1; index < n; index++){
            int num = arr.get(index);
            for(int i = index; i >= 0; i--){
                if(i == 0 || arr.get(i - 1) < num){
                    arr.set(i, num);
                    printList(n, arr);
                    break;
                } else{
                    arr.set(i, arr.get(i - 1));
                }              
            }
        }
    }

}

public class InsertionSortPart2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
