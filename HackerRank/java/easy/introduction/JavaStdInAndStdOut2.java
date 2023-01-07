
package hackerrank.java.easy.introduction;

import java.util.Scanner;

public class JavaStdInAndStdOut2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        // String s = scan.next()+scan.nextLine();  // If we use this line we will not need the last 2

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}