package saksoft;

// 2. Write a programme in Java to find out if a number is prime in Java?
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(isPrime(a)){
            System.out.println("Prime");
        } else{
            System.out.println("Not Prime");
        }
    }

    public static boolean isPrime(int a){
        if(a == 1){
            return false;
        }
        for(int i = 2; i <= Math.pow(a, 0.5); i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
}
