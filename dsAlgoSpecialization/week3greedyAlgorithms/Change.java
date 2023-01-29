package dsAlgoSpecialization.week3greedyAlgorithms;

import java.util.Scanner;

public class Change {
    private static int getChangeFast(int m){
        return (m/10) + (m%10)/5 + ((m%10)%5)/1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChangeFast(m));

    }
}