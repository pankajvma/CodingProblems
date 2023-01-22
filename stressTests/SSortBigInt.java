package stressTests;

// package hackerrank.problemSolving.easy.algorithms.sorting;

import java.io.*;
import java.math.*;
import java.util.*;

class Result {

    public static List<String> bigSortingFast(List<String> unsorted) {
        long startTime = System.nanoTime();

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String b1, String b2){
                // This is the optimized code, We tried to use BigInteger's compareTo() for comparing Big Numbers.
                // However, that gave TLE for some cases. Hence, We optimized the code by overriding compare() further as per our need.
                if(b1.equals(b2)){
                    return 0;
                } 
                else if(b1.length() < b2.length()){
                    return -1;
                } 
                 if(b1.length() > b2.length()){
                    return 1;
                }
                return b1.compareTo(b2);
            }
        };
        unsorted.sort(comparator);
        List<String> sorted = new ArrayList<>(unsorted); // unsorted is now sorted :)
        System.out.println("bigSortingFast: "+ (System.nanoTime() - startTime));
        return sorted;
    }

    public static List<String> bigSorting(List<String> unsorted) {
        long startTime = System.nanoTime();

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String b1, String b2){
                return new BigInteger(b1).compareTo(new BigInteger(b2));
            }
        };
        unsorted.sort(comparator);
        List<String> sorted = new ArrayList<>(unsorted); // unsorted is now sorted :)
        System.out.println("bigSorting: "+ (System.nanoTime() - startTime));
        return sorted;
    }
}

public class SSortBigInt {
    public static void main(String[] args) throws IOException {
        while(true){

            Random rnd = new Random();
            
            List<String> randomNumberList = new ArrayList<>();
            for(int ind = 0; ind < rnd.nextInt(50) + 10; ind++){
                randomNumberList.add(new BigInteger(rnd.nextInt(50) + 50, rnd).toString());
            }
            if(Result.bigSorting(randomNumberList).equals(Result.bigSortingFast(randomNumberList))){
                System.out.println("OK");
            } else {
                System.out.println("Mismatch");
                break;
            }
        }
    }
}