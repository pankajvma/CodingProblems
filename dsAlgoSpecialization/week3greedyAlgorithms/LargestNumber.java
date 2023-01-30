package dsAlgoSpecialization.week3greedyAlgorithms;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {

        Comparator<String> comparator = new Comparator<>() {
            public int compare(String a, String b){
                if(a.equals(b)){
                    return 0;
                } else if(a.length() < b.length()){
                    return b.compareTo(a);
                } return a.compareTo(b);
            }
        };

        List<String> numList = Arrays.asList(a);
        Collections.sort(numList, comparator);

        StringBuilder result = new StringBuilder();

        for (int i = numList.size() - 1; i >= 0; i--) {
            result.append(numList.get(i));
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

