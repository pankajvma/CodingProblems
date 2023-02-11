package saksoft;

// 8. Write a programme in Java to print Fibonacci series up to a given number?
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        printFibo(a);
    }

    public static void printFibo(int a){
        int first = 0;
        int second = 1;
        int temp = 0;
        for(int i = 0; i < a; i++){
            if(i <= 1){
                System.out.print(i +" ");
            } else{
                temp = second;
                second = second + first;
                first = temp;
                System.out.print(second + " ");
            }
        }
    }
}
