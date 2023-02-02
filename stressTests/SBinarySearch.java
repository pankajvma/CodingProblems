package stressTests;

import java.util.Random;

public class SBinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        int mid = (left + right)/2;
        while(left <= right){
            if(a[mid] == x) return mid;
            else if(a[mid] > x) right = mid - 1;
            else left = mid + 1;
            mid = (left + right)/2;
        }
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean passed = true;
        int test = 0;
        while (passed) {
            test++;
            Random random = new Random(test);
            int n = random.nextInt(2999) + 1;
            int[] a = new int[n];
            int binarySearch;
            int linearSearch;
            a[0] = random.nextInt(1000000) + 1;
            for (int i = 1; i < n; i++) {
                a[i] = a[i - 1] + random.nextInt(1000); // to store random number in increassing order
            }

            int m = random.nextInt(9999) + 1;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = random.nextInt(100000000) + 1;
            }
            for (int i = 0; i < m; i++) {
                binarySearch = binarySearch(a, b[i]);
                linearSearch = linearSearch(a, b[i]);
                if (binarySearch != linearSearch){
                    System.out.println("\nTest"+ test +" Failed for " + b[i] + "\nLinear search returned " + linearSearch
                            + "\nBinary search returned " + binarySearch);
                    System.out.println("Array being considered: ");
                    for (Integer integer : a) {
                        System.out.print(integer + " ");
                    }
                    System.out.print("\nArray size: "+ n);
                    passed = false;
                    break;
                }
            }
            if(passed){
                System.out.print("\nTest"+ test + " completed successfully");
            }
        }
    }
}