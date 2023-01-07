// https://www.hackerrank.com/challenges/java-negative-subarray/problem
package hackerrank.java.easy.DataStructures;

import java.util.Scanner;

public class SubArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int windowSize = 0;
        int[] arr = new int[scanner.nextInt()];
        int countNegativeSubarrays = 0;
        for(int i = 0; i < arr.length; i ++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        while(windowSize < arr.length){
            for(int i = 0; i < arr.length - windowSize; i ++){
                if(getSum(arr, i, i + windowSize) < 0)
                    countNegativeSubarrays++;
                    
            }
            windowSize++;
        }
        System.out.println(countNegativeSubarrays);
        
        
    }
    
    public static int getSum(int[] arr, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += arr[i];
        }        
        return sum;
    }
}