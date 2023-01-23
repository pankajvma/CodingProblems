package stressTests;

import java.util.Random;
import java.util.Scanner;

public class SMaxPairwiseProduct{
    public static long[] maxPairProd(int n, int[] arr){
        long[] productAndNanoTime = new long[2];
        long startTime = System.nanoTime();
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
        productAndNanoTime[0] = (long)max * (long)secondMax;
        productAndNanoTime[1] = System.nanoTime() - startTime;
        return  productAndNanoTime;
    }

    public static long[] maxPairProdFast(int n, int[] arr){
        long[] productAndNanoTime = new long[2];
        long startTime = System.nanoTime();
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
        productAndNanoTime[0] = (long)max * (long)secondMax;
        productAndNanoTime[1] = System.nanoTime() - startTime;
        return  productAndNanoTime;
        // 6 6 2 6 2 3
    }

    public static void main(String[] args){
        while(true){
            Random rnd = new Random(5);
            int n = rnd.nextInt(2) + 50000;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = rnd.nextInt(10000) + 50000;
            }
            long[] prodTime = maxPairProd(n, arr);
            long[] prodTimeFast = maxPairProdFast(n, arr);
            if(prodTime[0] == prodTimeFast[0]){
                System.out.println("OK. Fast function time is "+ (prodTime[1] - prodTimeFast[1]) +" seconds faster.");
            } else{
                System.out.println("Wrong Answer");
                for(Integer ind:arr){
                    System.out.print(ind+" ");
                }
                System.out.println("\nFast function says: "+ prodTimeFast[0] +"\nSlow function says: "+ prodTime[0]);
                break;
            }
        }
    }
}