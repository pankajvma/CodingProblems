package dsAlgoSpecialization.week4DandC;

import java.io.*;
import java.util.*;

public class BinarySearchDuplicates {

    static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        int mid = (left + right)/2;
        while(left <= right){
            if(a[mid] == x) {
                while(mid - 1 >= 0 && a[mid - 1] == x){
                    mid--;
                } return mid;
            }
            else if(a[mid] > x) right = mid - 1;
            else left = mid + 1;
            mid = (left + right)/2;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}