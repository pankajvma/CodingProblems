package dsAlgoSpecialization.week3greedyAlgorithms;

import java.util.*;

public class LargestNumber {
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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}