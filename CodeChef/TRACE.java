import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class TRACE {
    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            Scanner sc = new Scanner(System.in);
            int testCases = sc.nextInt();
            while (testCases != 0) {
                int arrSize = sc.nextInt();
                int[][] A = new int[arrSize][arrSize];
                for(int i = 0; i < arrSize; i++){
                    for(int j = 0; j < arrSize; j++){
                        A[i][j] = sc.nextInt();
                    }
                }

                System.out.println(traceSum(A, arrSize));
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int traceSum(int[][] arr, int arrSize){
        int sum = 0;
        int round = arrSize-1;
        int j = 0;
        int i = round;
        ArrayList<Integer> sumArray = new ArrayList<>();
        while (i >= 0){
            while(i < arrSize){
                sum += arr[i][j];
                i++;
                j++;
            }
            round--;
            i = round;
            j = 0;
            sumArray.add(sum);
            sum = 0;
        }


        round = arrSize-1;
        i = 0;
        j = round;
        while (j > 0){
            while(j < arrSize){
                sum += arr[i][j];
                i++;
                j++;
            }
            round--;
            i = 0;
            j = round;
            sumArray.add(sum);
            sum = 0;
        }

        return Collections.max(sumArray);
    }
}