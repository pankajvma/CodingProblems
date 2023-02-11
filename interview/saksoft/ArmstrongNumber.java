package saksoft;


import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(isArmstrong(a)){
            System.out.println("Armstrong");
        } else {
            System.out.println("Arms not so strong");
        }

    }

    public static boolean isArmstrong(int a){
        int numberOfDigits = Integer.toString(a).length();
        double sumOfDigitsPowers = 0;
        int temp = a;

        for(int i = 0; i < numberOfDigits; i++){
            sumOfDigitsPowers = sumOfDigitsPowers + Math.pow((double)temp%10, numberOfDigits);
            temp = temp/10;
        }
        // System.out.println(sumOfDigitsPowers);
        if(sumOfDigitsPowers == a){
            return true;
        }

        return false;
    }
    
}
