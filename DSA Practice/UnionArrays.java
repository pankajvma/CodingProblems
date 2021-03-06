import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionArrays {
    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            Scanner sc = new Scanner(System.in);
            int testCases = sc.nextInt();
            while (testCases != 0) {
                int aSize = sc.nextInt();
                int bSize = sc.nextInt();
                int[] A = new int[aSize];
                int[] B = new int[bSize];
                for(int i = 0; i < aSize; i++){
                    A[i] = sc.nextInt();
                }for(int i = 0; i < bSize; i++){
                    B[i] = sc.nextInt();
                }
                System.out.println(doUnion(A, aSize, B, bSize));
                testCases--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int doUnion(int a[], int n, int b[], int m)
    {
        Set<Integer> union = new LinkedHashSet<>();
        for(int i = 0; i < n; i++){
            union.add(a[i]);
        }
        for(int i = 0; i < m; i++){
            union.add(b[i]);
        }

        return union.size();
    }


}