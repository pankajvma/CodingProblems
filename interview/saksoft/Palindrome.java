package saksoft;

// 3. Write a programme in Java to find out if a number is a palindrome in Java?
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(isPalin(a)){
            System.out.println(a+ " is Palindrome");
        } else{
            System.out.println(a+ " is not Palindrome");
        }
    }

    public static boolean isPalin(int a){
        int reverse = 0;
        int temp = a;//123

        while(temp%10 != 0){
            reverse = (reverse * 10) + (temp % 10);//321
            temp = temp/10;
        }
        System.out.println(reverse);
        if(reverse == a){
            return true;
        }

        return false;
    }
}
