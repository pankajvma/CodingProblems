// https://www.hackerrank.com/challenges/java-2d-array/problem
package hackerrank.java.easy.DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class TwoDArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("io\\twoDArray_input.txt"));
        System.setOut(new PrintStream("io\\twoDArray_expected_output.txt"));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.print(getMaxSum(arr));

        bufferedReader.close();
    }
    
    public static int getMaxSum(List<List<Integer>> arr){
        int i = 0;
        int maxSum = -63; // initializing maxSum with the lowest possible value where the hourglass has all values as -9
        int sumIJ = 0;
        while(i <= 3){
            for(int j = 0; j <= 3; j++){
                sumIJ = getSum(i, j, arr);
                if(sumIJ > maxSum){
                    maxSum = sumIJ;
                }
            }
            i++;
        }
        return maxSum;
    }
    
    public static int getSum(int i, int j, List<List<Integer>> arr){
        int sum = 0;
        for(int k = j; k <= j+2; k++){
            sum += arr.get(i).get(k);
            sum += arr.get(i+2).get(k);
        }
        return sum + arr.get(i+1).get(j+1);
        
    }
}