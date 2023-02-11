package saksoft;

// 1. Write a programme in Java to check if a number is even or odd in Java?
import java.util.Scanner;

public class EvenOdd{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String message = a % 2 == 0 ? "Even" : "Odd";
        System.out.println(message);
    }
}