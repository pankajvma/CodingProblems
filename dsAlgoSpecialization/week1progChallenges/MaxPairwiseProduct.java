package dsAlgoSpecialization.week1progChallenges;

import java.util.Scanner;

public class MaxPairwiseProduct{
    public static long maxPairProd(int n, int[] arr){
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        int secondMax = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > secondMax && i != maxIndex){
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