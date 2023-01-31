package stressTests;

import java.util.*;

public class SLargestNumber {
    private static String largestNumber(String[] a) {

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String a, String b){
                if(Integer.parseInt(a+b) >= Integer.parseInt(b + a)) return -1; // Instead of > we are using >= because the general conntract of TimSort says that the sort should be in-place
                return 1;
            }
        };

        List<String> numList = Arrays.asList(a);
        Collections.sort(numList, comparator);

        StringBuilder result = new StringBuilder();

        for (String string: numList) {
            result.append(string);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // 1 ≤ n ≤ 100; 1 ≤ ai ≤ 10^3 for all 1 ≤ i ≤ n
        Random random = new Random(5);
            for(int t = 0; t <= 5; t++){
                int n = random.nextInt(5)+2;
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.toString(random.nextInt(100)+1);
            }for (int i = 0; i < n; i++) {
                System.out.println(a[i]+" ");
            }
            System.out.println(largestNumber(a));
            System.out.println();
        }
    }

    // 100
    // 2 8 2 3 6 4 1 1 10 6 3 3 6 1 3 8 4 6 1 10 8 4 10 4 1 3 2 3 2 6 1 5 2 9 8 5 10 8 7 9 6 4 2 6 3 8 8 9 8 2 9 10 3 10 7 5 7 1 7 5 1 4 7 6 1 10 5 4 8 4 2 7 8 1 1 7 4 1 1 9 8 6 5 9 9 3 7 6 3 10 8 10 7 2 5 1 1 9 9 5

    // Your output:
    // 9999991099988777765544431088888888887777766666666554331110106555544444333333321111022222222111110111010111011

    // Correct output:
    // 9999999998888888888887777777776666666666555555554444444443333333333222222222111111111111111101010101010101010

    // 1219 12 121209 120912
}