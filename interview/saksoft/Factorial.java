package saksoft;
// 10. Write a programme to calculate factorial of integer number?
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(getFactorial(a));
    }

    public static int getFactorial(int a){
        int factorial = 1;
        for(int i = 1; i <= a; i++){
            factorial *= i;
        }
        return factorial;

    }
}
