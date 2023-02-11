package saksoft;

// 4. Find out if a number is the power of 2 in java?
import java.util.Scanner;

public class PowerOf2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(isPowerOf2(a)){
            System.out.println(a+ " is power of 2");
        } else{
            System.out.println(a+ " is not power of 2");
        }
    }

    public static boolean isPowerOf2(int a){
        double powerOf2 = 0;
        int i = 0;
        while(powerOf2 <= a){
            powerOf2 = Math.pow(2, i);
            if(powerOf2 == a){
                return true;
            } i++;
        } 
        return false;
    } 
}
