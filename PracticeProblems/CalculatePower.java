import java.math.BigInteger;
import java.util.Scanner;

public class CalculatePower{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int pow = scanner.nextInt();
        System.out.println(calPower(number, pow));
        scanner.nextLine();
        scanner.close();
    }

    public static int calPower(int number, int pow){
        System.out.println(pow);
        if (pow == 0)
            return 1;
        return (number * calPower(number, pow-1));
    }

}