// https://www.hackerrank.com/challenges/correctness-invariant/problem
package hackerrank.problemSolving.easy.algorithms.sorting.insertion;

import java.util.*;

/*
 * https://www.cs.scranton.edu/~mccloske/courses/cmps144/invariants_lec.html
 * 
 * Insertion Sort's Invariant
    Say, you have some InsertionSort code, where the outer loop goes through the whole array :

    for(int i = 1; i < A.length; i++){
    //insertion sort code

    You could then state the following loop invariant:

    At the start of every iteration of the outer loop (indexed with i), the subarray until arr[i] consists of the original elements that were there, but in sorted order.

    To prove Insertion Sort is correct, you will then demonstrate it for the three stages:

    Initialization - The subarray starts with the first element of the array, and it is (obviously) sorted to begin with.

    Maintenance - Each iteration of the loop expands the subarray, but keeps the sorted property. 
                An element E gets inserted into the array only when it is greater than the element to its left. 
                Since the elements to its left have already been sorted, it means E is greater than all the elements to its left, so the array remains sorted. 
                (In Insertion Sort 2 we saw this by printing the array each time an element was properly inserted.)

    Termination - The code will terminate after i has reached the last element in the array, which means the sorted subarray has expanded to encompass the entire array. The array is now fully sorted.
 */




public class LoopInvariant {

    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}