// https://www.hackerrank.com/challenges/insertionsort1/problem
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
        }
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        int num = arr.get(n-1);
        for(int i = n - 1; i >= 0; i--){
            if(i == 0 || arr.get(i - 1) < num){
                arr.set(i, num);
                printList(n, arr);
                break;
            } else{
                arr.set(i, arr.get(i - 1));
            }
            printList(n, arr);
            System.out.println();
        }
    }

}

public class InsertionSortPart1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
