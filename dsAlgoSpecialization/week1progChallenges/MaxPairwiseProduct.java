package dsAlgoSpecialization.week1progChallenges;

import java.util.Scanner;

public class MaxPairwiseProduct{

    public static long maxPairProd(int n, int[] arr){ // Optimized after stress testing, time complexity reduced from 2n to n.
        int max = 0;
        int secondMax = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if(arr[i] > secondMax){
                secondMax = arr[i];
            }
        }
        return  (long)max * (long)secondMax;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print(maxPairProd(n, arr));
    }
}